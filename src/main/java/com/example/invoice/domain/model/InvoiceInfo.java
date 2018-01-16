package com.example.invoice.domain.model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceInfo implements java.io.Serializable {

  /**
   * シリアルバージョンUID
   */
  private static final long serialVersionUID = 1L;

  /**
   * 請求書管理番号
   */
  private int invoiceNo;
  /**
   * 顧客管理番号
   */
  private int clientNo;
  /**
   * 請求状態
   */
  private char invoiceStatus;
  /**
   * 請求書作成日
   */
  private Date invoiceCreateDate;
  /**
   * 請求書件名
   */
  private String invoiceTitle;
  /**
   * 請求金額
   */
  private int invoiceAmt;
  /**
   * 消費税
   */
  private int taxAmt;
  /**
   * 請求期間開始日
   */
  private Date invoiceStartDate;
  /**
   * 請求期間終了日
   */
  private Date invoiceEndDate;
  /**
   * 備考
   */
  private String invoiceNote;
  /**
   * 登録ユーザID
   */
  private String createUser;
  /**
   * 登録日時
   */
  private Date createDatetime;
  /**
   * 更新ユーザID
   */
  private String updateUser;
  /**
   * 更新日時
   */
  private Date updateDatetime;
  /**
   * 削除フラグ
   */
  private char delFlg;
}
