package com.example.invoice.domain.model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRegistResponseDto implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 請求書番号.
   */
  private int invoiceNo;
  /**
   * 顧客名称.
   */
  private String clientName;
  /**
   * 請求状態.
   */
  private char invoiceStatus;
  /**
   * 請求書件名.
   */
  private String invoiceTitle;
  /**
   * 請求金額.
   */
  private int invoiceAmt;
  /**
   * 税額.
   */
  private int taxAmt;
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
}
