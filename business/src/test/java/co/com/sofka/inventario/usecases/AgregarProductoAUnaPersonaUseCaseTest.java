package co.com.sofka.inventario.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.ProductoFactory;
import co.com.sofka.inventario.commands.AgregarProductoAUnaPersona;
import co.com.sofka.inventario.events.InventarioCreado;
import co.com.sofka.inventario.events.ProductoDeUnaPersonaAgregado;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.inventario.values.FechaEntrada;
import co.com.sofka.inventario.values.Periocidad;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.ubicacion.identities.UbicacionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class AgregarProductoAUnaPersonaUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarProductoAUnaPersonaUseCase useCase;

    @Test
    void agregarProductoAUnaPersona() {
        //arrange
        var inventarioId = new InventarioId();
        var personaId = PersonaId.of("ABC123");
        var productoFactory = ProductoFactory.getInstance()
                .crear(ProductoId.of("abc"), new Categoria(Categoria.Categorias.ELECTRODOMESTICO), new Dimension(10, 10, 10), new Descripcion("Tablet"), new FechaEntrada(17, 6, 2022), new Stock(10), UbicacionId.of("UBI1"));
        var command = new AgregarProductoAUnaPersona(inventarioId, personaId, productoFactory);
        Mockito.when(repository.getEventsBy(inventarioId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ProductoDeUnaPersonaAgregado) events.get(0);
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals(personaId.value(), event.getPersonaId().value());
        Assertions.assertEquals("abc", event.getProductoId().value());
        Assertions.assertEquals(Categoria.Categorias.ELECTRODOMESTICO, event.getCategoria().value());
        Assertions.assertEquals(1000, event.getDimension().value());
        Assertions.assertEquals("Tablet", event.getDescripcion().value());
        Assertions.assertEquals("17-06-2022", event.getFechaEntrada().value());
        Assertions.assertEquals(10, event.getStock().value());
        Assertions.assertEquals("UBI1", event.getUbicacionId().value());
    }

    private List<DomainEvent> history() {
        var periodicidad = new Periocidad(Periocidad.Periodo.ANUAL);
        var personaIds = Set.of(PersonaId.of("ABC123"), PersonaId.of("XYZ789"));
        return List.of(
                new InventarioCreado(periodicidad, personaIds)
        );
    }
}