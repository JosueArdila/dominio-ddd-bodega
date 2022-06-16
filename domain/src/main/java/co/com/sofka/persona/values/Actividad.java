package co.com.sofka.persona.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Actividad implements ValueObject<String> {
    private final String descripcion;

    public Actividad(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
        if (this.descripcion.isBlank()) {
            throw new IllegalArgumentException("Se requiere una descripcion");
        }
        if (this.descripcion.length() < 10) {
            throw new IllegalArgumentException("La descripcion debe tener como minimo 10 caracteres");
        }
        if (this.descripcion.length() > 100) {
            throw new IllegalArgumentException("La descripcion no debe superar los 100 caracteres");
        }
    }

    @Override
    public String value() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return descripcion.equals(actividad.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }
}
