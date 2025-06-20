package it.apuliadigital.shipping.service;

import java.util.List;

import it.apuliadigital.shipping.models.Shipping;

public interface IShipping {
    public List<Shipping> getAllShippings();
    public Shipping createShipping(Shipping newShipping);
    public Shipping getShippingById(int id);
    public Shipping updateShipping(Shipping updatedShipping);
}
