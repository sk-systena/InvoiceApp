package com.example.invoice.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceSearchResponseDto implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 請求書情報.
   */
  private InvoiceInfo invoiceInfo;
}
