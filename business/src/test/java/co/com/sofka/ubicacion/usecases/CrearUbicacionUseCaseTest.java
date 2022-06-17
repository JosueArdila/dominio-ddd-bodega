package co.com.sofka.ubicacion.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.ubicacion.commands.CrearUbicacion;
import co.com.sofka.ubicacion.events.UbicacionCreada;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.values.Direccion;
import co.com.sofka.ubicacion.values.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearUbicacionUseCaseTest {

    @Test
    public void crearUbicacion() {

        // arrange
        EspacioId espacioId = EspacioId.of("xxx");
        Estado estado = new Estado(Estado.Estados.DISPONIBLE);
        Dimension dimension = new Dimension(10, 20, 30);
        Direccion direccion = new Direccion("P01", "E12", "C50");
        Categoria categoria = new Categoria(Categoria.Categorias.ELECTRODOMESTICO);

        CrearUbicacion command = new CrearUbicacion(espacioId, estado, dimension, direccion, categoria);

        CrearUbicacionUseCase useCase = new CrearUbicacionUseCase();

        // act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        UbicacionCreada event = (UbicacionCreada) events.get(0);
        Assertions.assertEquals("xxx", event.getEspacioId().value());
        Assertions.assertEquals(Estado.Estados.DISPONIBLE, event.getEstado().value());
        Assertions.assertEquals(6000, event.getDimension().value());
        Assertions.assertEquals("P01E12C50", event.getDireccion().value());
        Assertions.assertEquals(Categoria.Categorias.ELECTRODOMESTICO, event.getCategoria().value());
    }
}
