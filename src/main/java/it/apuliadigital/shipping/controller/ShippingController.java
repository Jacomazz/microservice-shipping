package it.apuliadigital.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.shipping.models.Shipping;
import it.apuliadigital.shipping.service.IShipping;

@RestController
public class ShippingController {
    @Autowired
    private IShipping service;

    @GetMapping("/shippings")
    public ResponseEntity<List<Shipping>> getShippings() {
        List<Shipping> shippings = service.getAllShippings();
        if (shippings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(shippings);
    }

    @PostMapping("/shippings/create")
    public boolean createShipping(Shipping newShipping) {
        if (newShipping == null) {
            return false;
        }
        return service.createShipping(newShipping);
    }
    @GetMapping("/shippings/{id}")
    public ResponseEntity<Shipping> getShippingById(int id) {
        Shipping shipping = service.getShippingById(id);
        if (shipping == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shipping);
    }
}
