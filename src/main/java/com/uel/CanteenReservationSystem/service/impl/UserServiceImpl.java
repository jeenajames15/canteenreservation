package com.uel.CanteenReservationSystem.service.impl;

import com.uel.CanteenReservationSystem.entity.User;
import com.uel.CanteenReservationSystem.model.request.LoginModel;
import com.uel.CanteenReservationSystem.model.request.UserRequestModel;
import com.uel.CanteenReservationSystem.model.response.UserResponseModel;
import com.uel.CanteenReservationSystem.repository.UserRepository;
import com.uel.CanteenReservationSystem.service.UserService;
import com.uel.CanteenReservationSystem.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;


    @Override
    public UserResponseModel save(UserRequestModel userRequestModel) {
        return Optional.of(userRequestModel)
                .map(modelMapperUtil::convertUserModelToEntity)
                .map(u-> {
                    u.setActive(true);
                    u.setCreateUserID("1");
                    u.setUpdateUserID("1");
                    return u;
                })
                .map(userRepository::save)
                .map(modelMapperUtil::convertUserEntityToModel).get();
    }

    @Override
    public UserResponseModel getUser(String userId) {
        return userRepository.findById(userId)
                .map(modelMapperUtil::convertUserEntityToModel).get();
    }

    @Override
    public UserResponseModel login(LoginModel loginModel) {
        User user = userRepository.findByEmail(loginModel.getEmail());
        if(user.getPassword().equals(loginModel.getPassword()))
            return modelMapperUtil.convertUserEntityToModel(user);
        return null;
    }

    @Override
    public List<UserResponseModel> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(modelMapperUtil::convertUserEntityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseModel update(UserRequestModel userRequestModel, String userId) {
        User user = userRepository.findById(userId).get();
        user.setAddress(userRequestModel.getAddress());
        user.setEmail(userRequestModel.getEmail());
        user.setFirstName(userRequestModel.getFirstName());
        user.setLastName(userRequestModel.getLastName());
        user.setPhone(userRequestModel.getPhone());
        return modelMapperUtil.convertUserEntityToModel(userRepository.save(user));
    }
}
