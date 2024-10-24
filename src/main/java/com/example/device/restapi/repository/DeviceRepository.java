package com.example.device.restapi.repository;

import com.example.device.restapi.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Page<Device> findByDeviceBrand(String deviceBrand, Pageable pageable);
}
