package com.example.invoice.domain.model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceListSearchRequestDto implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 請求書管理番号.
   */
  private int invoiceNo;
  /**
   * 顧客管理番号.
   */
  private int clientNo;
  /**
   * 顧客名称.
   */
  private String clientName;
  /**
   * 請求状態.
   */
  private char invoiceStatus;
  /**
   * 請求期間開始日.
   */
  private Date invoiceStartDate;
  /**
   * 請求期間終了日.
   */
  private Date invoiceEndDate;
}
