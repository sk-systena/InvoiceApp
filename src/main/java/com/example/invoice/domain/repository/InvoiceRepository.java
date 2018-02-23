package com.example.invoice.domain.repository;

import com.example.invoice.domain.model.InvoiceEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author kesuzuki
 *
 */
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

  @Query(value = "select * from invoice where invoice_no = :invoiceNo", nativeQuery = true)
  InvoiceEntity findByInvoice(@Param("invoiceNo") Integer invoiceNo);

  @Query(value = "select * from invoice where invoice_no = :invoiceNo", nativeQuery = true)
  List<InvoiceEntity> findManyByInvoices(@Param("invoiceNo") Integer invoiceNo);

  @Query(value = "select * from order where client_no = :clientNo "
      + "and create_datetime => :startDate" + " and create_datetime =< :endDate "
      + "and del_flg = 0", nativeQuery = true)
  InvoiceEntity find_priod(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
      @Param("clientNo") Integer clientNo);
}
