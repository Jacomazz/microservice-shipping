package it.apuliadigital.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import it.apuliadigital.shipping.models.Shipping;
import it.apuliadigital.shipping.service.IShipping;

@RestController
public class ShippingController {
    @Autowired
    private IShipping shippingService;

    @GetMapping("/shippings")
    public ResponseEntity<List<Shipping>> getShippings() {
        List<Shipping> shippings = shippingService.getAllShippings();
        if (shippings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(shippings);
    }

    @PostMapping("/shippings/create")
    public ResponseEntity<Shipping> createShipping(Shipping newShipping) {
        Shipping saveShipping = shippingService.createShipping(newShipping);
        if(saveShipping == null) {
            return ResponseEntity.badRequest().build(); //bad request = error 400
        }
        return ResponseEntity.ok(saveShipping);
    }

    @GetMapping("/shippings/{id}")
    public ResponseEntity<Shipping> getShippingById(int id) {
        Shipping shipping = shippingService.getShippingById(id);
        if (shipping == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shipping);
    }

    @PutMapping("/shippings/{shipping}")
    public ResponseEntity<Shipping> updateShipping(@RequestParam Shipping updatedShipping) {
        Shipping existingShipping = shippingService.getShippingById(updatedShipping.getId());
        if (existingShipping == null) {
            return ResponseEntity.notFound().build();
        }
        Shipping updated = shippingService.updateShipping(updatedShipping);
        if (updated == null) {
            return ResponseEntity.badRequest().build(); //bad request = error 400
        }
        return ResponseEntity.ok(updated);
    }
}
