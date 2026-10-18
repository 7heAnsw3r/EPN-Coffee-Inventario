package inventario;

import java.util.NoSuchElementException;

import static inventario.Prueba.*;

public class InventarioTest {
    public static void ejecutar() {
        System.out.println("== InventarioTest ==");

        correr("registrar un producto permite consultar su stock", () -> {
            Inventario inv = new Inventario();
            inv.registrarProducto("P001", "Cafe en grano 1kg", 20, 5);
            assertEquals(20, inv.consultarStock("P001"));
        });

        correr("no se permite registrar dos veces el mismo id", () -> {
            Inventario inv = new Inventario();
            inv.registrarProducto("P001", "Cafe en grano 1kg", 20, 5);
            assertThrows(IllegalArgumentException.class,
                    () -> inv.registrarProducto("P001", "Otro", 1, 0));
        });

        correr("consultar un producto no registrado lanza excepcion", () -> {
            Inventario inv = new Inventario();
            assertThrows(NoSuchElementException.class, () -> inv.consultarStock("P999"));
        });

        correr("un producto bajo minimo se reporta correctamente", () -> {
            Inventario inv = new Inventario();
            inv.registrarProducto("P002", "Leche entera 1L", 3, 10);
            assertTrue(inv.estaBajoMinimo("P002"), "debia estar bajo minimo");
        });

        correr("listar devuelve todos los productos registrados", () -> {
            Inventario inv = new Inventario();
            inv.registrarProducto("P001", "Cafe en grano 1kg", 20, 5);
            inv.registrarProducto("P002", "Leche entera 1L", 3, 10);
            assertEquals(2, inv.listar().size());
        });
    }
}
