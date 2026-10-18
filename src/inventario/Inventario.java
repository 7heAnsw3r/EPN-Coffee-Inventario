package inventario;

import java.util.*;

/**
 * Historia de Usuario 1:
 * "Como encargado de bodega, quiero registrar el stock de un producto
 *  (id, nombre, cantidad y stock minimo) para saber cuanto tengo
 *  disponible y cuando debo reabastecer."
 */
public class Inventario {
    private final Map<String, Producto> productos = new LinkedHashMap<>();

    public Producto registrarProducto(String id, String nombre, int cantidad, int minimo) {
        if (productos.containsKey(id))
            throw new IllegalArgumentException("ya existe un producto con id " + id);

        Producto producto = new Producto(id, nombre, cantidad, minimo);
        productos.put(id, producto);
        return producto;
    }

    public int consultarStock(String id) {
        return obtener(id).getCantidad();
    }

    public boolean estaBajoMinimo(String id) {
        return obtener(id).estaBajoMinimo();
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }

    private Producto obtener(String id) {
        Producto producto = productos.get(id);
        if (producto == null)
            throw new NoSuchElementException("no existe un producto con id " + id);
        return producto;
    }
}
