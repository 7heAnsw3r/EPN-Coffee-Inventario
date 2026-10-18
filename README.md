# Inventario - EPN Coffee (XP + TDD)

### Tarea: Inventario
### Roles (ultima iteracion):
- Developer (Programmer): Anthony
- Coach: David Guachamin
- On-site Customer: David Guachamin

Estructura:
  src/    codigo de produccion
  test/   pruebas (se escriben PRIMERO)
  datos/  inventario_ejemplo.csv

## Historia de Usuario 1
> Como encargado de bodega, quiero registrar el stock de un producto
> (id, nombre, cantidad y stock minimo) para saber cuanto tengo
> disponible y cuando debo reabastecer.

Criterios de aceptacion:
- No se permite registrar dos veces el mismo id de producto.
- No se permite una cantidad ni un stock minimo negativos.
- Se puede consultar el stock actual de un producto registrado.
- Se puede saber si un producto esta bajo su stock minimo.

## 1) RED (solo las pruebas, sin src -> NO compila / rojo)
    mkdir -p out
    javac -encoding UTF-8 -d out test/inventario/*.java

## 2) GREEN (con src + test -> todo verde)
    javac -encoding UTF-8 -d out src/inventario/*.java test/inventario/*.java
    java -cp out inventario.TodasLasPruebas

## 3) Ejecutar la aplicacion
    java -cp out inventario.App
