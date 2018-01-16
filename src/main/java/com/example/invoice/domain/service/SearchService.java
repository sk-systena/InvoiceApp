package com.example.invoice.domain.service;

import com.example.invoice.domain.model.Invoice;
import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceListSearchRequest;
import com.example.invoice.domain.repository.InvoiceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kesuzuki
 *
 */
public class SearchService {


  @Autowired
  InvoiceRepository invoiceRepository;

  /**
   * 請求書情報を取得.
   *
   * @param invoiceId Integer
   * @return ivInfo InvoiceInfo
   */
  public InvoiceInfo invoiceFindOne(Integer invoiceId) {
    InvoiceInfo ivInfo = new InvoiceInfo();
    Invoice result = invoiceRepository.findByInvoice(invoiceId);
    ivInfo.setClientNo(result.getClientNo());

    return ivInfo;
  }

  /**
   * 請求書情報リストを取得.
   * 
   * @param searchListReq
   *
   * @param invoiceId Integer
   * @return ivInfoList List<InvoiceInfo>
   */
  public List<InvoiceInfo> invoiceFindMany(InvoiceListSearchRequest searchListReq) {
    List<InvoiceInfo> ivInfoList = new ArrayList<InvoiceInfo>();
    Invoice result = invoiceRepository.findManyByInvoices();
    return ivInfoList;
  }

}
