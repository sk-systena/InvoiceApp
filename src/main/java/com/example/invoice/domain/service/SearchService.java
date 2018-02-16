package com.example.invoice.domain.service;

import com.example.invoice.domain.model.InvoiceEntity;
import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceListSearchRequestDto;
import com.example.invoice.domain.model.InvoiceListSearchResponseDto;
import com.example.invoice.domain.model.InvoiceSearchRequestDto;
import com.example.invoice.domain.model.InvoiceSearchResponseDto;
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

  /**
   * 請求書情報を取得.
   *
   * @param searchReq Integer
   * @return ivInfo InvoiceInfo
   */
  public InvoiceSearchResponseDto invoiceFindOne(InvoiceSearchRequestDto searchReq) {
    InvoiceSearchResponseDto dto = new InvoiceSearchResponseDto();
    InvoiceInfo ivInfo = new InvoiceInfo();
    InvoiceEntity result = invoiceRepository.findByInvoice(searchReq.getInvoiceNo());
    ivInfo.setClientNo(result.getClientNo());

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
      ivInfo.setClientNo(row.getClientNo());
      ivInfoList.add(ivInfo);
    }
    dto.setInvoiceInfo(ivInfoList);
    return dto;
  }

}
