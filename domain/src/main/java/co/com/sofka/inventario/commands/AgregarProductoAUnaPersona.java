package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.ProductoFactory;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.persona.identities.PersonaId;

public class AgregarProductoAUnaPersona extends Command {
    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoFactory productoFactory;

    public AgregarProductoAUnaPersona(InventarioId inventarioId, PersonaId personaId, ProductoFactory productoFactory) {

        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoFactory = productoFactory;
    }

    public InventarioId getInventarioId() {
        return inventarioId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoFactory getProductoFactory() {
        return productoFactory;
    }
}
