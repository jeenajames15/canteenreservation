package com.uel.CanteenReservationSystem.repository;

import com.uel.CanteenReservationSystem.entity.Menu;
import com.uel.CanteenReservationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

}
