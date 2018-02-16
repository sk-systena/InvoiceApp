package com.example.invoice.domain.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceListSearchResponseDto implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 請求書情報リスト.
   */
  private List<InvoiceInfo> invoiceInfo;
}
