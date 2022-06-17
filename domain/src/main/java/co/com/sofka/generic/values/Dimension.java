package co.com.sofka.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dimension implements ValueObject<Integer> {
    private final Integer alto;
    private final Integer largo;
    private final Integer ancho;

    private final Integer volumen;


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
        this.volumen = calcularVolumen(alto, largo, ancho);
    }

    @Override
    public Integer value() {
        return volumen;
    }

    private int calcularVolumen(int alto, int largo, int ancho) {
        return alto * largo * ancho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimension dimension = (Dimension) o;
        return volumen.equals(dimension.volumen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen);
    }
}
