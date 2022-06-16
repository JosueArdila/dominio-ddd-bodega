package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.persona.identities.PersonaId;

public class DisminuirStockDeUnProducto extends Command {
    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Stock stock;

    public DisminuirStockDeUnProducto(InventarioId inventarioId, PersonaId personaId, ProductoId productoId, Stock stock) {

        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoId = productoId;
        this.stock = stock;
    }

    public InventarioId getInventarioId() {
        return inventarioId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Stock getStock() {
        return stock;
    }
}
