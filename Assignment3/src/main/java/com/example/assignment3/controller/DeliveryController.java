package com.example.assignment3.controller;

import com.example.assignment3.model.Delivery;
import com.example.assignment3.repository.DeliveryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @GetMapping("/{id}")
    public Delivery findDeliveryById(@PathVariable Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }
}
