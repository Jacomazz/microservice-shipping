package it.apuliadigital.shipping.service;

import java.util.List;

import it.apuliadigital.shipping.models.Shipping;

public interface IShipping {
     List<Shipping> getAllShippings();
     Shipping createShipping(Shipping newShipping);
     Shipping getShippingById(int id);
     Shipping updateShipping(Shipping updatedShipping);
}
