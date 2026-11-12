- Diseño de Software - Módulo 2
- Ejercitación 2.2
Ejercicio 9: Cola Compartida de Impresión Administrativa
Contexto del problema:
Los sectores de recepción, facturación y archivo de un hospital utilizan una impresora administrativa compartida. Cuando envían documentos simultáneamente, la creación de gestores independientes provoca pérdidas o duplicaciones de trabajos.

Objetivo de aprendizaje:
Diferenciar la creación segura de un Singleton de la sincronización necesaria para operar sobre su estado.

Requisitos funcionales:

Encolar documentos con identificador único, nombre, sector y cantidad de páginas.

Recibir solicitudes desde varios hilos.

Procesar los documentos en el orden en que fueron incorporados a la cola.

Emitir un informe de los trabajos procesados.

Restricciones técnicas:

Todos los hilos deben obtener la misma instancia del gestor de impresión.

Tanto la creación de la instancia como las operaciones sobre la cola deben ser seguras ante concurrencia.

Se deben enviar al menos treinta documentos desde diez hilos.

Cada documento debe procesarse exactamente una vez.

La impresión debe simularse mediante mensajes, sin requerir una impresora real.
***
# Lógica y Funcionamiento del Programa:
Para resolver este ejercicio armé un Singleton clásico para que todos los módulos de la aplicación apunten a la misma impresora y compartan la misma lista de trabajos.

- Clase Documento: Es el molde para guardar los datos del archivo a imprimir y saber de qué sector viene.

- Clase GestorImpresion: Es el Singleton. Para mantener el orden de llegada usé la interfaz Queue (cola) implementada con un LinkedList. Esto me permite usar el método .poll() para ir sacando e imprimiendo siempre el documento más viejo de la lista hasta que se vacíe.

- Clase Main: Como en la cursada todavía no vimos concurrencia ni el uso de hilos (Threads), adapté la simulación de forma secuencial. Hice un ciclo for que simula 10 sectores diferentes, y dentro de ese, otro for para que cada sector envíe 3 archivos. Al final, llamé al método para procesar y comprobé que se imprimen los 30 documentos exactamente en el orden en que fueron encolados, sin perder ni duplicar ninguno.
***
# Ejecucion por consola
![Captura de pantalla 2026-11-11 214941.png](Captura%20de%20pantalla%202026-11-11%20214941.png)