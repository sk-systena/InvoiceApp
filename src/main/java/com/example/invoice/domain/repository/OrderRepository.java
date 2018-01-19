package com.example.invoice.domain.repository;

import com.example.invoice.domain.model.Order;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author kesuzuki
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

  @Query(value = "select * from order where client_no = :clientNo "
      + "and create_datetime => :startDate" + " and create_datetime =< :endDate "
      + "and del_flg = 0", nativeQuery = true)
  List<Order> find_priod_order(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
      @Param("clientNo") Integer clientNo);
}
