package co.com.sofka.inventario;

import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.inventario.values.FechaEntrada;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.ubicacion.identities.UbicacionId;

import java.util.Objects;

public class ProductoFactory {
    private Producto producto;
    private static ProductoFactory instance;

    private ProductoFactory() {
    }

    public static ProductoFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ProductoFactory();
            return instance;
        }
        return instance;
    }

    public ProductoFactory crear(ProductoId entityId, Categoria categoria, Dimension dimension, Descripcion descripcion, FechaEntrada fechaEntrada, Stock stock, UbicacionId ubicacionId) {
        this.producto = new Producto(entityId, categoria, dimension, descripcion, fechaEntrada, stock, ubicacionId);
        return this;
    }

    protected Producto producto() {
        return producto;
    }
}