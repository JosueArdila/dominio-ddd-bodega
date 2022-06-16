package co.com.sofka.inventario;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.inventario.values.FechaEntrada;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class Producto extends Entity <ProductoId> {

    private Categoria categoria;
    private Dimension dimension;
    private Descripcion descripcion;
    private FechaEntrada fechaEntrada;
    private Stock stock;
    private UbicacionId ubicacionId;

    public Producto(ProductoId entityId, Categoria categoria, Dimension dimension, Descripcion descripcion, FechaEntrada fechaEntrada, Stock stock, UbicacionId ubicacionId) {
        super(entityId);
        this.categoria = categoria;
        this.dimension = dimension;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.stock = stock;
        this.ubicacionId= ubicacionId;
    }

    public Categoria categoria() {
        return categoria;
    }

    public Dimension dimension() {
        return dimension;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public FechaEntrada fechaEntrada() {
        return fechaEntrada;
    }

    public Stock stock() {
        return stock;
    }

    public UbicacionId ubicacionId() {
        return ubicacionId;
    }

    public void cambiarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void cambiarDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void cambiarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public void aumentarStock(Stock stock) {
        this.stock = stock.aumentar(stock);
    }

    public void disminuirStock(Stock stock) {
        this.stock = stock.disminuir(stock);
    }

    public void asignarUbicacion(UbicacionId ubicacionId) {
        this.ubicacionId = ubicacionId;
    }
}
