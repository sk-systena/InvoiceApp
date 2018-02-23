package com.example.invoice.domain.service;

import com.example.invoice.domain.model.ClientEntity;
import com.example.invoice.domain.model.InvoiceEntity;
import com.example.invoice.domain.model.InvoiceRegistRequestDto;
import com.example.invoice.domain.model.InvoiceRegistResponseDto;
import com.example.invoice.domain.model.OrderEntity;
import com.example.invoice.domain.repository.ClientRepository;
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
  ClientRepository clientRepository;

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

    // 登録請求 情報作成
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

    // レスポンスデータ作成
    InvoiceRegistResponseDto dto = new InvoiceRegistResponseDto();
    InvoiceEntity result = invoiceRepository.find_priod(registReq.getInvoiceStartDate(),
        registReq.getInvoiceEndDate(), registReq.getClientNo());
    dto.setInvoiceNo(result.getInvoiceNo());
    dto.setInvoiceStatus(result.getInvoiceStatus());
    dto.setInvoiceTitle(result.getInvoiceTitle());
    dto.setInvoiceAmt(result.getInvoiceAmt());
    dto.setTaxAmt(result.getTaxAmt());
    dto.setInvoiceNote(result.getInvoiceNote());
    ClientEntity client = clientRepository.findOne(result.getClientNo());
    dto.setClientName(client.getClientName());
    return dto;
  }
}
