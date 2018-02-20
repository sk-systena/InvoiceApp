package com.example.invoice.domain.model;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceInfo implements java.io.Serializable {

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
   * 請求書件名.
   */
  private String invoiceTitle;
  /**
   * 請求金額.
   */
  private int invoiceAmt;
  /**
   * 消費税.
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
