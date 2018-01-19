package com.example.invoice.domain.model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRegistRequest implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 顧客管理番号.
   */
  private int clientNo;
  /**
   * 請求状態.
   */
  private char invoiceStatus;
  /**
   * 請求書件名.
   */
  private String invoiceTitle;
  /**
   * 請求期間開始日.
   */
  private Date invoiceStartDate;
  /**
   * 請求期間終了日.
   */
  private Date invoiceEndDate;
  /**
   * 備考.
   */
  private String invoiceNote;
  /**
   * 登録ユーザID.
   */
  private String userId;
}
