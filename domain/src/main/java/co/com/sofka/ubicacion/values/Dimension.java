package co.com.sofka.ubicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dimension implements ValueObject<String> {
    private final String valor;

    public Dimension(String valor) {
        this.valor = Objects.requireNonNull(valor);

        if (valor.isBlank()) {
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
    }
    @Override
    public String value() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimension dimension = (Dimension) o;
        return valor.equals(dimension.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
