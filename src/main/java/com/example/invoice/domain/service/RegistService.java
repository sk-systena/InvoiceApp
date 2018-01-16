package com.example.invoice.domain.service;

import com.example.invoice.domain.model.Invoice;
import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceRegistRequest;
import com.example.invoice.domain.model.Order;
import com.example.invoice.domain.repository.InvoiceRepository;
import com.example.invoice.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kesuzuki
 *
 */
public class RegistService {

  @Autowired
  InvoiceRepository invoiceRepository;

  @Autowired
  OrderRepository orderRepository;

  /**
   * 請求書情報を取得.
   *
   * @param registReq
   *
   * @param InvoiceRegistRequest 注文情報
   * @return ivInfo 請求書情報
   */
  public InvoiceInfo invoiceRegister(InvoiceRegistRequest registReq) {

    Order orderEntity = new Order();


    orderRepository.save(orderEntity);

    Invoice invoiceEntity = new Invoice();

    invoiceRepository.save(invoiceEntity);


    return null;
  }
}
