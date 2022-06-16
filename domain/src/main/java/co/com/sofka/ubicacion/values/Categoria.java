package co.com.sofka.ubicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Categoria implements ValueObject<String> {
    private final String valor;

    public Categoria(String valor) {
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
        Categoria categoria = (Categoria) o;
        return valor.equals(categoria.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

}
