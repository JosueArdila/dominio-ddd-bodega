package co.com.sofka.inventario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Periocidad implements ValueObject<Periocidad.Periodo> {

    private final Periodo periodo;

    public Periocidad(Periodo periodo) {

        this.periodo = Objects.requireNonNull(periodo);

    }

    @Override
    public Periodo value() {
        return periodo;
    }

    public enum Periodo {
        TRIMESTRAL, SEMETRAL, ANUAL
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periocidad that = (Periocidad) o;
        return periodo == that.periodo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(periodo);
    }
}
