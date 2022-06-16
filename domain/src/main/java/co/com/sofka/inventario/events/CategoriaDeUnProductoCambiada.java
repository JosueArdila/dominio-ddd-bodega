package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;

public class CategoriaDeUnProductoCambiada extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;

    private final Categoria categoria;

    public CategoriaDeUnProductoCambiada(PersonaId personaId, ProductoId productoId,  Categoria categoria) {
        super("sofka.Inventario.CategoriaDeLaClasificacionDeUnProductoCambiada");
        this.personaId = personaId;
        this.productoId = productoId;

        this.categoria = categoria;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }


    public Categoria getCategoria() {
        return categoria;
    }
}
