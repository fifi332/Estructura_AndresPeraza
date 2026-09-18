# Tarea 1

**Módulo:** Programación de servizos e procesos  
**Alumno:** Andres Peraza

---

## 1. 
![Captura desde 2026-09-18 12-29-53.png](capturas/Captura%20desde%202026-09-18%2012-29-53.png)
![Captura desde 2026-09-18 12-30-07.png](capturas/Captura%20desde%202026-09-18%2012-30-07.png)

## 2. El proceso, desde fuera

### Búsqueda del proceso (`ps -ef | grep InformeSistema`)

Al ejecutar el programa en la terminal mientras se encuentra en la espera final (`Pulsa INTRO para terminar...`), se obtiene la siguiente salida:

![PPID_PID.png](capturas/PPID_PID.png)

PID: 10389 PPID: 10366

Un proceso existente (Padre/PPID) ejecuta una llamada al sistema. Esa llamada clona el proceso y crea uno nuevo (Hijo/PID). El nuevo proceso hijo se queda con un registro de quién lo creó guardando el PID de su creador bajo la etiqueta PPID.

![Captura desde 2026-09-18 11-41-31.png](capturas/Captura%20desde%202026-09-18%2011-41-31.png)

### En terminal
![Captura desde 2026-09-18 11-42-57.png](capturas/Captura%20desde%202026-09-18%2011-42-57.png)

### En IDE

![Captura desde 2026-09-18 11-46-34.png](capturas/Captura%20desde%202026-09-18%2011-46-34.png)


Cuando se lanza desde IntelliJ IDEA, es el propio IDE el que crea y gestiona el subproceso Java.

Cuando se lanza en la Terminal, es el shell de la terminal el que genera el subproceso Java.

### Comparacion
![Captura desde 2026-09-18 11-52-22.png](capturas/Captura%20desde%202026-09-18%2011-52-22.png)
![Captura desde 2026-09-18 11-53-28.png](capturas/Captura%20desde%202026-09-18%2011-53-28.png)
Al ejecutar la aplicación especificando el parámetro -Xmx128m, le indicamos a la máquina virtual de Java que reserve un límite máximo de 128 MiB para la memoria.  

Cambian (Máxima, Total y Libre): Al usar -Xmx128m, la memoria Máxima se limita a 128MiB en lugar de los 3942MiB del principio. Esto obliga a la JVM a reducir la memoria Total reservada y, disminuye la memoria Libre disponible 120MiB de 242MiB. El consumo esta practicamente igual 8\10MiB porque el programa realiza las mismas tareas y carga los mismos objetos iniciales.  

### Ruta

![Captura desde 2026-09-18 12-08-32.png](capturas/Captura%20desde%202026-09-18%2012-08-32.png)

En Windows la ruta seria C:\Users\dam26\psp\informe.txt

## 3. Qué tipo de programación encaja

### a) Un servidor web que atiende 500 peticiones a la vez en una máquina de 8 núcleos.
Concurrente porque intercala la atención de las 500 peticiones para no bloquearse y Paralela porque sus 8 núcleos ejecutan hasta 8 tareas simultaneas. El inconveniente es que necesita sincronizar el acceso a recursos compartidos. 

### b) Renderizar una película de animación en un plazo de tres meses.
Distribuida porque al tener que renderizar una pelicula tan grande necesita repartir fotogramas entre una red de ordenadores. El inconveniente es la latencia de la red.

### c) Una app de móvil que descarga un fichero mientras seguís navegando.
Concurrente porque intercala la interfaz grafica con la descarga en hilos distintos. El inconveniente es la complejidad al gestionar los hilos.

### d) Cálculo que no cabe en la RAM de un solo equipo
Distribuida porque obliga a dividir la memoria y el calculo se distribuye entre varios equipos.El inconveniente es el riesgo a que nodo falle mientras hacen el calculo. 