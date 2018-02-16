package com.example.invoice.domain.service;

import com.example.invoice.domain.model.InvoiceEntity;
import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceRegistRequestDto;
import com.example.invoice.domain.model.InvoiceRegistResponseDto;
import com.example.invoice.domain.model.OrderEntity;
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
  public InvoiceRegistResponseDto invoiceRegister(InvoiceRegistRequestDto registReq) {
    List<OrderEntity> orderList = orderRepository.find_priod_order(registReq.getInvoiceStartDate(),
        registReq.getInvoiceEndDate(), registReq.getClientNo());

    InvoiceEntity invoiceEntity = new InvoiceEntity();
    int amt = 0;
    Double tax = 0.08;
    for (OrderEntity order : orderList) {
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

    InvoiceRegistResponseDto dto = new InvoiceRegistResponseDto();
    InvoiceInfo invoiceInfo = new InvoiceInfo();
    return dto;
  }
}
