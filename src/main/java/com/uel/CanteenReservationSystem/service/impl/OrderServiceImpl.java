package com.uel.CanteenReservationSystem.service.impl;

import com.uel.CanteenReservationSystem.entity.Menu;
import com.uel.CanteenReservationSystem.entity.Order;
import com.uel.CanteenReservationSystem.entity.OrderMenu;
import com.uel.CanteenReservationSystem.entity.OrderMenuID;
import com.uel.CanteenReservationSystem.model.request.OrderRequestModel;
import com.uel.CanteenReservationSystem.model.response.MenuResponseModel;
import com.uel.CanteenReservationSystem.model.response.OrderResponseModel;
import com.uel.CanteenReservationSystem.repository.MenuRepository;
import com.uel.CanteenReservationSystem.repository.OrderMenuRepository;
import com.uel.CanteenReservationSystem.repository.OrderRepository;
import com.uel.CanteenReservationSystem.service.OrderService;
import com.uel.CanteenReservationSystem.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMenuRepository orderMenuRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;


    @Override
    public OrderResponseModel save(OrderRequestModel orderRequestModel) {
        OrderResponseModel orderResponseModel = Optional.of(orderRequestModel)
                .map(modelMapperUtil::convertOrderModelToEntity)
                .map(u-> {
                    u.setActive(true);
                    u.setCreateUserID(orderRequestModel.getUserId());
                    u.setUpdateUserID(orderRequestModel.getUserId());
                    return u;
                })
                .map(orderRepository::save)
                .map(e-> {
                    OrderResponseModel o = modelMapperUtil.convertOrderEntityToModel(e);
                    o.setMenuItems(orderRequestModel.getMenuItems());
                    return o;
                }).get();
        updateOrderMenu(orderRequestModel,orderResponseModel);
        return orderResponseModel;
    }

    @Override
    public OrderResponseModel getOrder(String orderId) {
        OrderResponseModel orderResponseModel = orderRepository.findById(orderId)
                .map(modelMapperUtil::convertOrderEntityToModel).get();
        List<MenuResponseModel> menuResponseModelList = orderMenuRepository.findAllByOrderOrderId(orderId).stream()
                .map(e->{return e.getMenu();})
                .map(modelMapperUtil::convertMenuEntityToModel)
                .collect(Collectors.toList());
        orderResponseModel.setMenuItems(menuResponseModelList);
        return orderResponseModel;
    }

    @Override
    public List<OrderResponseModel> getAllOrder() {
        return orderRepository.findAll()
                .stream()
                .map(modelMapperUtil::convertOrderEntityToModel)
                .map(o -> {
                    List<MenuResponseModel> menuResponseModelList = orderMenuRepository.findAllByOrderOrderId(o.getOrderId()).stream()
                            .map(e->{return e.getMenu();})
                            .map(modelMapperUtil::convertMenuEntityToModel)
                            .collect(Collectors.toList());
                    o.setMenuItems(menuResponseModelList);
                    return o;
                })
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderResponseModel> getOrderByUserId(String userId) {
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(modelMapperUtil::convertOrderEntityToModel)
                .map(o -> {
                    List<MenuResponseModel> menuResponseModelList = orderMenuRepository.findAllByOrderOrderId(o.getOrderId()).stream()
                            .map(e->{return e.getMenu();})
                            .map(modelMapperUtil::convertMenuEntityToModel)
                            .collect(Collectors.toList());
                    o.setMenuItems(menuResponseModelList);
                    return o;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void cancelOrder(String orderId) {
        orderRepository.findById(orderId)
                .map(o-> {
                    o.setActive(false);
                    return o;
                })
                .map(orderRepository::save);
    }

    @Override
    public OrderResponseModel completeOrder(String orderId, String time) {
        return orderRepository.findById(orderId)
                .map(o->{
                    o.setComplete(true);
                    o.setTotalPreparationTime(Integer.parseInt(time));
                    return o;
                })
                .map(orderRepository::save)
                .map(modelMapperUtil::convertOrderEntityToModel).get();
    }

    private void updateOrderMenu(OrderRequestModel orderRequestModel, OrderResponseModel e) {
        orderRequestModel.getMenuItems().stream()
                .map(x->{
                    Menu menu = menuRepository.findById(x.getFoodId()).get();
                    Order o = orderRepository.findById(e.getOrderId()).get();
                    if(null!=menu) {
                        OrderMenu orderMenu = new OrderMenu();
                        orderMenu.setOrderMenuID(new OrderMenuID(e.getOrderId(),menu.getFoodId()));
                        orderMenu.setOrder(o);
                        orderMenu.setMenu(menu);
                        orderMenu.setActive(true);
                        orderMenu.setCreateUserID(orderRequestModel.getUserId());
                        orderMenu.setUpdateUserID(orderRequestModel.getUserId());
                        orderMenuRepository.save(orderMenu);
                    }
                    return menu;
                }).collect(Collectors.toList());
    }

}
