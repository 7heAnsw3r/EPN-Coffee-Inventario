package inventario;

/**
 * MVP de consola: demuestra la Historia de Usuario 1
 * (registrar productos y consultar su stock / minimo).
 */
public class App {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.registrarProducto("P001", "Cafe en grano 1kg", 20, 5);
        inventario.registrarProducto("P002", "Leche entera 1L", 3, 10);
        inventario.registrarProducto("P003", "Vasos para espresso", 50, 15);

        System.out.println("=== Inventario EPN Coffee ===");
        for (Producto p : inventario.listar()) {
            String alerta = p.estaBajoMinimo() ? "  <-- BAJO MINIMO" : "";
            System.out.printf("%-6s %-22s stock=%-4d minimo=%-4d%s%n",
                    p.getId(), p.getNombre(), p.getCantidad(), p.getMinimo(), alerta);
        }
    }
}
