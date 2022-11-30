package com.uel.CanteenReservationSystem.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    public String upload(MultipartFile file) throws IOException;

}
