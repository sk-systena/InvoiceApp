package com.example.invoice.domain.service;

import com.example.invoice.domain.model.ClientEntity;
import com.example.invoice.domain.model.InvoiceEntity;
import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceListSearchRequestDto;
import com.example.invoice.domain.model.InvoiceListSearchResponseDto;
import com.example.invoice.domain.model.InvoiceSearchResponseDto;
import com.example.invoice.domain.repository.ClientRepository;
import com.example.invoice.domain.repository.InvoiceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kesuzuki
 *
 */
@Service
public class SearchService {


  @Autowired
  InvoiceRepository invoiceRepository;

  @Autowired
  ClientRepository clientRepository;

  /**
   * 請求書情報を取得.
   *
   * @param id Integer
   * @return ivInfo InvoiceInfo
   */
  public InvoiceSearchResponseDto invoiceFindOne(Integer id) {
    InvoiceSearchResponseDto dto = new InvoiceSearchResponseDto();
    InvoiceInfo ivInfo = new InvoiceInfo();
    InvoiceEntity result = invoiceRepository.findByInvoice(id);
    if (result != null) {
      setInvoiceInfo(result, ivInfo);
    }
    dto.setInvoiceInfo(ivInfo);
    return dto;
  }

  /**
   * 請求書情報リストを取得.
   *
   * @param searchListReq InvoiceListSearchRequest
   * @return ivInfoList 請求書情報リスト
   *
   */
  public InvoiceListSearchResponseDto invoiceFindMany(InvoiceListSearchRequestDto searchListReq) {
    InvoiceListSearchResponseDto dto = new InvoiceListSearchResponseDto();
    List<InvoiceInfo> ivInfoList = new ArrayList<InvoiceInfo>();
    List<InvoiceEntity> result = invoiceRepository.findManyByInvoices(0);
    for (InvoiceEntity row : result) {
      InvoiceInfo ivInfo = new InvoiceInfo();
      setInvoiceInfo(row, ivInfo);
      ivInfoList.add(ivInfo);
    }
    dto.setInvoiceInfo(ivInfoList);
    return dto;
  }

  private void setInvoiceInfo(InvoiceEntity entity, InvoiceInfo ivInfo) {
    ivInfo.setInvoiceNo(entity.getInvoiceNo());
    ivInfo.setClientNo(entity.getClientNo());
    ivInfo.setInvoiceStatus(entity.getInvoiceStatus());
    ivInfo.setInvoiceTitle(entity.getInvoiceTitle());
    ivInfo.setInvoiceAmt(entity.getInvoiceAmt());
    ivInfo.setTaxAmt(entity.getTaxAmt());
    ivInfo.setInvoiceStartDate(entity.getInvoiceStartDate());
    ivInfo.setInvoiceEndDate(entity.getInvoiceEndDate());
    ivInfo.setInvoiceNote(entity.getInvoiceNote());
    ClientEntity client = clientRepository.findOne(entity.getClientNo());
    ivInfo.setClientName(client.getClientName());
  }
}
