package co.com.sofka.persona.usercases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.persona.commands.CrearPersona;
import co.com.sofka.persona.events.PersonaCreada;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.values.Nombre;
import co.com.sofka.persona.values.Rol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static co.com.sofka.persona.values.Rol.Roles.CLIENTE;
import static org.junit.jupiter.api.Assertions.*;

class CrearPersonaUseCaseTest {

    @Test
    void crearNuevaPersona(){
        var nombre= new Nombre("Sebastian");
        var clasificacionId = new ClasificacionId();
        var rol= new Rol(CLIENTE);
        var actividad= new Actividad("Actividad prueba1");

 var command= new CrearPersona(nombre, clasificacionId, rol, actividad );
 var useCase = new CrearPersonaUseCase();

 List<DomainEvent> events = UseCaseHandler.getInstance().
         syncExecutor(useCase,new RequestCommand<>(command)).
         orElseThrow().
         getDomainEvents();

        PersonaCreada event = (PersonaCreada) events.get(0);
        Assertions.assertEquals("Sebastian", event.getNombre().value());
        Assertions.assertEquals(clasificacionId.value(), event.getClasificacionId().value());
        Assertions.assertEquals(CLIENTE, event.getRol().value());
        Assertions.assertEquals("Actividad prueba1", event.getActividad().value());

    }

}