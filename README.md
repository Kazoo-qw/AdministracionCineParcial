# AdministracionCineParcial

## Preguntas de sustentación (Punto 6)

### 1. Estructura de almacenamiento elegida

Para las **funciones** usé una lista simplemente enlazada (la clase `NodoFuncion` encadenada desde `head` en `Cine`). La elegí porque el enunciado pide poder registrar una cantidad indefinida de funciones, y con una lista no tengo que definir de una vez cuántas van a caber; cada vez que se registra una nueva simplemente se engancha un nodo más al final.

Para los **puestos** usé un arreglo fijo de 20 posiciones (`boolean[20]`, dentro de `Funcion`). Aquí no tenía sentido usar una lista enlazada porque la cantidad de puestos nunca cambia, siempre son 20, así que con un arreglo puedo entrar directo a cualquier puesto por su índice sin tener que recorrer nada.

### 2. Cómo buscaría una función por su código

Hice una búsqueda secuencial, que es lo que hace el método `buscarPorCodigo` de `Cine`:

1. Empiezo en el primer nodo (`head`).
2. Mientras el nodo actual no sea `null`, comparo su código con el que estoy buscando.
3. Si coincide, devuelvo esa función y ya.
4. Si no coincide, paso al siguiente nodo (`actual.getNext()`) y sigo comparando.
5. Si llego al final de la lista sin encontrar nada, devuelvo `null`.

Ahora mismo devuelve `null` cuando no encuentra el código, aunque ya tengo creada `FuncionNoEncontradaException` en el paquete `Excepciones` — me falta conectarla ahí, sería la mejora obvia.

### 3. Problema de recorrer al revés en una lista simplemente enlazada

El problema es que cada nodo solo sabe cuál es el *siguiente*, no tiene forma de saber cuál era el anterior. Entonces si necesitara recorrer la lista de atrás hacia adelante, o buscar qué función se registró justo antes que otra, tocaría recorrer toda la lista desde el `head` cada vez comparando el `next` de cada nodo hasta encontrar cuál apunta al que busco, lo cual es bastante ineficiente. La solución de verdad sería usar una lista doblemente enlazada, donde cada nodo también tenga un puntero al anterior.

### 4. Qué tendría que cuidar al eliminar una función

Todavía no implementé eliminar, pero si lo hiciera tendría que tener en cuenta:

- Revisar primero que la lista no esté vacía (igual que ya hago en otros métodos, lanzando `ListaVaciaException`).
- Si el código que quiero eliminar no existe, lanzar `FuncionNoEncontradaException` antes de tocar cualquier puntero.
- Si el nodo que voy a eliminar es el `head`, tengo que mover el `head` al siguiente nodo antes de perder la referencia al viejo.
- Si está en la mitad o al final, necesito guardar una referencia al nodo anterior mientras recorro, para poder hacer `anterior.setNext(nodoAEliminar.getNext())` y saltarlo sin romper la cadena.
- Nunca llamar `.getNext()` sobre algo que ya sea `null`, porque ahí es donde se cae el programa con un `NullPointerException`.
- Si la lista solo tiene un nodo y lo elimino, el `head` debe quedar en `null`.
