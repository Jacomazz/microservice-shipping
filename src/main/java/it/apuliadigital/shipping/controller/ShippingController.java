package it.apuliadigital.shipping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.apuliadigital.shipping.models.Shipping;
import it.apuliadigital.shipping.service.IShipping;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    @Autowired
    private IShipping shippingService;

    @Operation(summary = "Lista Spedizioni", description = "Metodo per restituire la lista di tutte le spedizioni.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista generata", content = @Content(schema = @Schema(implementation = Shipping.class))),
        @ApiResponse(responseCode = "204", description = "Nessun contenuto trovato"),
        @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })
    @GetMapping
    public ResponseEntity<List<Shipping>> getShippings() {
        List<Shipping> shippings = shippingService.getAllShippings();
        if (shippings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(shippings);
    }

    @Operation(summary = "Nuova Spedizione", description = "Metodo per creare una nuova spedizione.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Spedizione creata", content = @Content(schema = @Schema(implementation = Shipping.class))),
        @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })
    @PostMapping("/create")
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping newShipping) {
        Shipping saveShipping = shippingService.createShipping(newShipping);
        if (saveShipping == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(saveShipping);
    }

    @Operation(summary = "Cerca Spedizione con ID", description = "Metodo per cercare una spedizione col suo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Spedizione trovata", content = @Content(schema = @Schema(implementation = Shipping.class))),
        @ApiResponse(responseCode = "404", description = "Spedizione non trovata")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable int id) {
        Shipping shipping = shippingService.getShippingById(id);
        if (shipping == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shipping);
    }

    @Operation(summary = "Aggiorna Spedizione", description = "Metodo per aggiornare una spedizione esistente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Spedizione aggiornata", content = @Content(schema = @Schema(implementation = Shipping.class))),
        @ApiResponse(responseCode = "400", description = "Richiesta non valida"),
        @ApiResponse(responseCode = "404", description = "Spedizione non trovata")
    })
    @PutMapping("/update")
    public ResponseEntity<Shipping> updateShipping(@RequestBody Shipping updatedShipping) {
        Shipping existingShipping = shippingService.getShippingById(updatedShipping.getId());
        if (existingShipping == null) {
            return ResponseEntity.notFound().build();
        }
        Shipping updated = shippingService.updateShipping(updatedShipping);
        if (updated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updated);
    }
}
