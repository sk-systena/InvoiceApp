package com.example.invoice.domain.repository;

import com.example.invoice.domain.model.Invoice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author kesuzuki
 *
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

  @Query(value = "select * from invoice where invoice_no = :invoiceNo", nativeQuery = true)
  Invoice findByInvoice(@Param("invoiceNo") Integer invoiceNo);

  @Query(value = "select * from invoice where invoice_no = :invoiceNo", nativeQuery = true)
  List<Invoice> findManyByInvoices(@Param("invoiceNo") Integer invoiceNo);
}
