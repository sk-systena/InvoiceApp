package com.example.invoice.domain.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order")
public class Order implements java.io.Serializable {

  /**
   * シリアルバージョンUID
   */
  private static final long serialVersionUID = 1L;

  /**
   * 注文管理番号
   */
  @Column(name = "order_no")
  private int orderNo;
  /**
   * 顧客管理番号
   */
  @Column(name = "client_no")
  private int clientNo;
  /**
   * 商品管理番号
   */
  @Column(name = "item_no")
  private int itemNo;
  /**
   * 商品名
   */
  @Column(name = "item_name")
  private String itemName;
  /**
   * 商材区分
   */
  @Column(name = "item_type")
  private char itemType;
  /**
   * 商品販売価格（税抜き）
   */
  @Column(name = "item_price")
  private int itemPrice;
  /**
   * 購入数量
   */
  @Column(name = "item_count")
  private int itemCount;
  /**
   * 登録日時
   */
  @Column(name = "create_datetime")
  private Date createDatetime;
  /**
   * 更新日時
   */
  @Column(name = "update_datetime")
  private Date updateDatetime;
  /**
   * 削除フラグ
   */
  @Column(name = "del_flg")
  private char delFlg;
}
