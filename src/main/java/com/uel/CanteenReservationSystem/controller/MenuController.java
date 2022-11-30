package com.uel.CanteenReservationSystem.controller;

import com.uel.CanteenReservationSystem.model.request.MenuRequestModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.MenuResponseModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;
import com.uel.CanteenReservationSystem.service.MenuService;
import com.uel.CanteenReservationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/rest/v1")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/foods")
    ResponseEntity<MenuResponseModel> save(@RequestBody MenuRequestModel menuRequestModel) {
        return ResponseEntity.ok(menuService.save(menuRequestModel));
    }

    @GetMapping("/foods")
    ResponseEntity<List<MenuResponseModel>> getAllMenu() {
        return ResponseEntity.ok(menuService.getAllMenu());
    }

    @GetMapping("/foods/{foodId}")
    ResponseEntity<MenuResponseModel> getById(@PathVariable String foodId) {
        return ResponseEntity.ok(menuService.getByID(foodId));
    }

    @PutMapping("/foods/{foodId}")
    ResponseEntity<MenuResponseModel> update(@PathVariable String foodId, @RequestBody MenuRequestModel menuRequestModel) {
        return ResponseEntity.ok(menuService.update(menuRequestModel,foodId));
    }

    @DeleteMapping("/foods/{foodId}")
    ResponseEntity<String> delete(@PathVariable String foodId) {
        menuService.delete(foodId);
        return ResponseEntity.ok("Deleted");
    }
}
