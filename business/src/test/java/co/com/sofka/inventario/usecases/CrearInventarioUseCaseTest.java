package co.com.sofka.inventario.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.inventario.commands.CrearInventario;
import co.com.sofka.inventario.events.InventarioCreado;
import co.com.sofka.inventario.values.Periocidad;
import co.com.sofka.persona.identities.PersonaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class CrearInventarioUseCaseTest {
    @Test
    void crearInventario() {
        //arrange
        var periodicidad = new Periocidad(Periocidad.Periodo.ANUAL);
        var personaIds = Set.of(PersonaId.of("ABC123"), PersonaId.of("XYZ789"));
        var command = new CrearInventario(periodicidad, personaIds);
        var usecase = new CrearInventarioUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (InventarioCreado) events.get(0);
        Assertions.assertEquals(2, event.getPersonaIds().size());
        Assertions.assertEquals(Periocidad.Periodo.ANUAL, event.getPeriocidad().value());
    }
}