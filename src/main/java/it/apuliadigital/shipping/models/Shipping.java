package it.apuliadigital.shipping.models;

import it.apuliadigital.shipping.enums.EnumStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

public class Shipping {
    @Id
    @GeneratedValue
    private int id;
    private int codiceOrdine;
    private EnumStatus status;
    private String destinationAddress;
    private String courier;

    public Shipping() {
        // Default constructor
    }

    public Shipping(int id, int codiceOrdine, EnumStatus status, String destinationAddress, String courier) {
        this.id = id;
        this.codiceOrdine = codiceOrdine;
        this.status = status;
        this.destinationAddress = destinationAddress;
        this.courier = courier;
    }

    public int getId() {
        return id;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public String getdestinationAddress() {
        return destinationAddress;
    }

    public void setdestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shipping)) {
            return false;
        }
        Shipping shipping = (Shipping) o;
        return id == shipping.id && Objects.equals(status, shipping.status) && Objects.equals(destinationAddress, shipping.destinationAddress) && Objects.equals(courier, shipping.courier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, destinationAddress, courier);
    }
    
}

//CIAO98429834823740892