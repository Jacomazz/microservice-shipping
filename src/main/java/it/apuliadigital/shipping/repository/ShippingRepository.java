package it.apuliadigital.shipping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.apuliadigital.shipping.enums.EnumStatus;
import it.apuliadigital.shipping.models.Shipping;

@Repository
public interface ShippingRepository extends CrudRepository<Shipping, Integer> {
    List<Shipping> findByStatus(EnumStatus status);

    List<Shipping> findByCourier(String courier);

    List<Shipping> findByDestinationAddressContainingIgnoreCase(String keyword);
}
