package com.uel.CanteenReservationSystem.repository;

import com.uel.CanteenReservationSystem.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, String> {

    List<OrderMenu> findAllByOrderOrderId( String id);
}
