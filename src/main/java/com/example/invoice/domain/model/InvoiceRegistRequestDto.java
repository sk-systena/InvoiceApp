package com.example.invoice.domain.model;

import java.sql.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRegistRequestDto implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 顧客管理番号.
   */
  @NotNull
  @Size(min = 0, max = 99999999)
  private Integer clientNo;
  /**
   * 請求状態.
   */
  private char invoiceStatus;
  /**
   * 請求書件名.
   */
  @NotNull
  private String invoiceTitle;
  /**
   * 請求期間開始日.
   */
  @NotNull
  private Date invoiceStartDate;
  /**
   * 請求期間終了日.
   */
  @NotNull
  private Date invoiceEndDate;
  /**
   * 備考.
   */
  @Size(min = 0, max = 3000)
  private String invoiceNote;
  /**
   * 登録ユーザID.
   */
  private String userId;
}
