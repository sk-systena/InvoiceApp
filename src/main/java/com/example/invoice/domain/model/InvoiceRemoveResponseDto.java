package com.example.invoice.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRemoveResponseDto implements java.io.Serializable {

  /**
   * シリアルバージョンUID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 削除結果メッセージ.
   */
  private String message;
}
