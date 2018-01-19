package com.example.invoice.domain.service;

import com.example.invoice.domain.model.Invoice;
import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceRegistRequest;
import com.example.invoice.domain.model.Order;
import com.example.invoice.domain.repository.InvoiceRepository;
import com.example.invoice.domain.repository.OrderRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kesuzuki
 *
 */
@Service
public class RegistService {

  @Autowired
  InvoiceRepository invoiceRepository;

  @Autowired
  OrderRepository orderRepository;

  /**
   * 請求書情報を取得.
   *
   * @param registReq InvoiceRegistRequest 注文情報
   * @return ivInfo 請求書情報
   */
  public InvoiceInfo invoiceRegister(InvoiceRegistRequest registReq) {

    List<Order> orderList = orderRepository.find_priod_order(registReq.getInvoiceStartDate(),
        registReq.getInvoiceEndDate(), registReq.getClientNo());

    Invoice invoiceEntity = new Invoice();
    int amt = 0;
    Double tax = 0.08;
    for (Order order : orderList) {
      amt += order.getItemPrice() * order.getItemCount();
    }
    invoiceEntity.setInvoiceAmt(amt);
    int taxAmt = (int) (amt * tax);
    invoiceEntity.setTaxAmt(taxAmt);
    invoiceEntity.setClientNo(registReq.getClientNo());
    // Sequece noを払い出して登録
    invoiceEntity.setInvoiceNo(null);
    char invoiceStatus = 10;
    invoiceEntity.setInvoiceStatus(invoiceStatus);
    // 当日日時を生成
    Date today = new Date();
    invoiceEntity.setInvoiceCreateDate(today);
    invoiceEntity.setInvoiceTitle(registReq.getInvoiceTitle());
    invoiceEntity.setInvoiceStartDate(registReq.getInvoiceStartDate());
    invoiceEntity.setInvoiceEndDate(registReq.getInvoiceEndDate());
    invoiceEntity.setInvoiceNote(registReq.getInvoiceNote());
    invoiceEntity.setCreateUser(registReq.getUserId());
    invoiceEntity.setCreateDatetime(today);
    invoiceEntity.setUpdateUser(registReq.getUserId());
    invoiceEntity.setUpdateDatetime(today);
    char delFlg = 0;
    invoiceEntity.setDelFlg(delFlg);
    invoiceRepository.save(invoiceEntity);

    InvoiceInfo invoiceInfo = new InvoiceInfo();
    return invoiceInfo;
  }
}
