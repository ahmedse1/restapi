package com.example.device.restapi.service;

import com.example.device.restapi.dto.DeviceDTO;
import com.example.device.restapi.entity.Device;
import com.example.device.restapi.mapper.DeviceMapper;
import com.example.device.restapi.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService implements IDeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    @Override
    public void createDevice(DeviceDTO deviceDTO) {
        Device device = DeviceMapper.mapToDevice(deviceDTO, new Device());
        device.setCreatedAt(LocalDateTime.now());
        deviceRepository.save(device);
    }

    @Override
    public DeviceDTO getDeviceById(int id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Device not found with id: " + id));
        return DeviceMapper.mapToDeviceDTO(device, new DeviceDTO());
    }

    @Override
    public List<DeviceDTO> getAllDevices() {
        // Fetch all devices from the repository and convert them to DTOs
        return deviceRepository.findAll().stream()
                .map(device -> DeviceMapper.mapToDeviceDTO(device, new DeviceDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateDevice(DeviceDTO deviceDTO) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceDTO.getDeviceId());
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            device.setDeviceName(deviceDTO.getDeviceName());
            device.setDeviceBrand(deviceDTO.getDeviceBrand());
            deviceRepository.save(device);
            return true;
        } else {
            throw new EntityNotFoundException("Device not found with ID: " + deviceDTO.getDeviceId());
        }
    }

    @Override
    public boolean deleteDevice(int id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Device not found with ID: " + id);
        }
    }

    @Override
    public DeviceDTO getDeviceByBrand(String brand) {
        Device device = deviceRepository.findByDeviceBrand(brand)
                .orElseThrow(() -> new EntityNotFoundException("Device not found with brand: " + brand));

        return DeviceMapper.mapToDeviceDTO(device, new DeviceDTO());
    }
}