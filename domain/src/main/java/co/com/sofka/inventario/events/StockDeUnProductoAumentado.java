package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.persona.identities.PersonaId;

public class StockDeUnProductoAumentado extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Stock stock;

    public StockDeUnProductoAumentado(PersonaId personaId, ProductoId productoId, Stock stock) {
        super("sofka.Inventario.StockDeUnProductoAumentado");
        this.personaId = personaId;
        this.productoId = productoId;
        this.stock = stock;
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
