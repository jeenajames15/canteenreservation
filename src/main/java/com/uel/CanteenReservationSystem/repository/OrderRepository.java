package com.uel.CanteenReservationSystem.repository;

import com.uel.CanteenReservationSystem.entity.Menu;
import com.uel.CanteenReservationSystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

   List<Order> findAllByUserId(String userId);
}
