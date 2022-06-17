package co.com.sofka.persona.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String valor;

    public Nombre(String valor) {
        this.valor = Objects.requireNonNull(valor);
        if (this.valor.isBlank()) {
            throw new IllegalArgumentException("Se requiere un nombre");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return valor.equals(nombre.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String value() {
        return valor;
    }
}
