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
    public Shipping createShipping(Shipping newShipping) {
        return repository.save(newShipping);
    }

    @Override
    public Shipping getShippingById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Shipping updateShipping(Shipping updatedShipping) {
        return repository.save(updatedShipping);
    }
}
