package it.apuliadigital.shipping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.shipping.models.Shipping;
import it.apuliadigital.shipping.repository.ShippingRepository;

@Service
public class ShippingService implements IShipping {

    @Autowired
    private ShippingRepository repository;

    @Override
    public List<Shipping> getAllShippings() {
        return (List<Shipping>) repository.findAll();
    }

    @Override
    public boolean createShipping(Shipping newShipping) {
        if (newShipping != null) {
            repository.save(newShipping);
            return true;
        }
        return false;
    }

    @Override
    public Shipping getShippingById(int id) {
        // Logic to retrieve a shipping by ID
        return null; // Placeholder return
    }

    @Override
    public Shipping updateShipping(int id, Shipping updatedShipping) {
        // Logic to update an existing shipping
        return null; // Placeholder return
    }
    
    
    
}
