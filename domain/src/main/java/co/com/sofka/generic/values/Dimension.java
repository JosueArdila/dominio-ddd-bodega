package co.com.sofka.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dimension implements ValueObject<Dimension.Value> {
    private final Integer alto;
    private final Integer largo;
    private final Integer ancho;

    public interface Value {
        Integer alto();

        Integer largo();

        Integer ancho();
    }

    public Dimension(int alto, int largo, int ancho) {
        this.alto = alto;
        if (this.alto <= 0) {
            throw new IllegalArgumentException("El alto debe ser mayor a 0");
        }
        this.largo = largo;
        if (this.largo <= 0) {
            throw new IllegalArgumentException("El largo debe ser mayor a 0");
        }
        this.ancho = ancho;
        if (this.ancho <= 0) {
            throw new IllegalArgumentException("El ancho debe ser mayor a 0");
        }
    }

    @Override
    public Value value() {
        return new Value() {
            @Override
            public Integer alto() {
                return null;
            }

            @Override
            public Integer largo() {
                return null;
            }

            @Override
            public Integer ancho() {
                return null;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimension dimension = (Dimension) o;
        return alto.equals(dimension.alto) && largo.equals(dimension.largo) && ancho.equals(dimension.ancho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alto, largo, ancho);
    }
}
