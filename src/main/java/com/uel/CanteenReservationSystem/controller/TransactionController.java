package com.uel.CanteenReservationSystem.controller;

import com.uel.CanteenReservationSystem.model.request.TransactionRequestModel;
import com.uel.CanteenReservationSystem.model.response.TransactionResponseModel;
import com.uel.CanteenReservationSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/rest/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    ResponseEntity<TransactionResponseModel> save(@RequestBody TransactionRequestModel transactionRequestModel) {
        return ResponseEntity.ok(transactionService.save(transactionRequestModel));
    }

    @GetMapping("/transactions/{id}")
    ResponseEntity<TransactionResponseModel> getById(@PathVariable String id) {
        return ResponseEntity.ok(transactionService.getById(id));
    }

    @GetMapping("/transactions/order/{orderId}")
    ResponseEntity<TransactionResponseModel> getByOrderId(@PathVariable String orderId) {
        return ResponseEntity.ok(transactionService.getByOrderId(orderId));
    }

    @GetMapping("/transactions/user/{userId}")
    ResponseEntity<List<TransactionResponseModel>> getByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(transactionService.getAllByUserId(userId));
    }

    @GetMapping("/transactions")
    ResponseEntity<List<TransactionResponseModel>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

}
