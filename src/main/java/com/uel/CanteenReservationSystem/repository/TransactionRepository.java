package com.uel.CanteenReservationSystem.repository;

import com.uel.CanteenReservationSystem.entity.Rating;
import com.uel.CanteenReservationSystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    Transaction findByOrderId(String orderId);

    List<Transaction> findAllByUserId(String userId);
}
