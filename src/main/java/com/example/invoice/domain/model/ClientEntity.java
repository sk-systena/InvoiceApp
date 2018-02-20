package com.example.invoice.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client")
public class ClientEntity implements java.io.Serializable {

  /**
   * シリアルバージョンUID
   */
  private static final long serialVersionUID = 1L;

  /**
   * 顧客管理番号
   */
  @Id
  @Column(name = "client_no")
  private int clientNo;

  @Column(name = "client_charge_last_name")
  private String clientChargeLastName;
  @Column(name = "client_charge_first_name")
  private String clientChargeFirstName;
  @Column(name = "client_name")
  private String clientName;
  @Column(name = "client_address")
  private String clientAddress;
  @Column(name = "client_tel")
  private String clientTel;
  @Column(name = "client_fax")
  private String clientFax;
  @Column(name = "create_datetime")
  private String createDatetime;
  @Column(name = "update_datetime")
  private String updateDatetime;
  @Column(name = "del_flg")
  private String delFlg;
}
