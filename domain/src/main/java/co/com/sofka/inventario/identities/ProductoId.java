package co.com.sofka.inventario.identities;

import co.com.sofka.domain.generic.Identity;

public class ProductoId extends Identity {
    private ProductoId(String id) {
        super(id);
    }

    public ProductoId() {
    }

    public static ProductoId of(String id) {
        return new ProductoId(id);
    }
}