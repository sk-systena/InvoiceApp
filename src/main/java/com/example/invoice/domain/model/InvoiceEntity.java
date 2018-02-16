package com.example.invoice.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "invoice")
public class InvoiceEntity implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 請求書管理番号.
   */
  @Id
  @Column(name = "invoice_no")
  private Integer invoiceNo;
  /**
   * 顧客管理番号.
   */
  @Column(name = "client_no")
  private int clientNo;
  /**
   * 請求状態.
   */
  @Column(name = "invoice_status")
  private char invoiceStatus;
  /**
   * 請求書作成日.
   */
  @Column(name = "invoice_create_date")
  private Date invoiceCreateDate;
  /**
   * 請求書件名.
   */
  @Column(name = "invoice_title")
  private String invoiceTitle;
  /**
   * 請求金額.
   */
  @Column(name = "invoice_amt")
  private int invoiceAmt;
  /**
   * 消費税.
   */
  @Column(name = "tax_amt")
  private int taxAmt;
  /**
   * 請求期間開始日.
   */
  @Column(name = "invoice_start_date")
  private Date invoiceStartDate;
  /**
   * 請求期間終了日.
   */
  @Column(name = "invoice_end_date")
  private Date invoiceEndDate;
  /**
   * 備考.
   */
  @Column(name = "invoice_note")
  private String invoiceNote;
  /**
   * 登録ユーザID.
   */
  @Column(name = "create_user")
  private String createUser;
  /**
   * 登録日時.
   */
  @Column(name = "create_datetime")
  private Date createDatetime;
  /**
   * 更新ユーザID.
   */
  @Column(name = "update_user")
  private String updateUser;
  /**
   * 更新日時.
   */
  @Column(name = "update_datetime")
  private Date updateDatetime;
  /**
   * 削除フラグ.
   */
  @Column(name = "del_flg")
  private char delFlg;
}
