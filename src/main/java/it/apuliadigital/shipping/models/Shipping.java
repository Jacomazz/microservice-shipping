package it.apuliadigital.shipping.models;

import it.apuliadigital.shipping.enums.EnumStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private int codiceOrdine;
    @NotNull
    private EnumStatus status;
    @NotBlank(message = "L'indirizzo di destinazione non può essere vuoto")
    @Column(name = "destination_address", nullable = false)
    private String destinationAddress;
    @NotBlank
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

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public int getCodiceOrdine() {
        return codiceOrdine;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shipping)) {
            return false;
        }
        Shipping shipping = (Shipping) o;
        return id == shipping.id && Objects.equals(status, shipping.status)
                && Objects.equals(destinationAddress, shipping.destinationAddress)
                && Objects.equals(courier, shipping.courier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, destinationAddress, courier);
    }

}
