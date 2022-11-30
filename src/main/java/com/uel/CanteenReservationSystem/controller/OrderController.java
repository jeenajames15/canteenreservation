package com.uel.CanteenReservationSystem.controller;

import com.uel.CanteenReservationSystem.model.request.OrderRequestModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.MenuResponseModel;
import com.uel.CanteenReservationSystem.model.response.OrderResponseModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;
import com.uel.CanteenReservationSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/rest/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    ResponseEntity<OrderResponseModel> save(@RequestBody OrderRequestModel orderRequestModel) {
       return ResponseEntity.ok(orderService.save(orderRequestModel));
    }

    @GetMapping("/orders/{orderId}")
    ResponseEntity<OrderResponseModel> getById(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @GetMapping("/orders")
    ResponseEntity<List<OrderResponseModel>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/orders/users/{userId}")
    ResponseEntity<List<OrderResponseModel>> getAllOrdersByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.getOrderByUserId(userId));
    }

    @PutMapping("/orders/complete/{orderId}/{time}")
    ResponseEntity<OrderResponseModel> completeOrder(@PathVariable String orderId,@PathVariable String time) {
        return ResponseEntity.ok(orderService.completeOrder(orderId, time));
    }


}
