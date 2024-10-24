### AVAJ LAUNCHER

Es un proyecto simple de simulación de clima escrito en Java. El programa simula diferentes tipos de vehículos aéreos (helicópteros, aviones a reacción y globos) que interactúan con una torre meteorológica en un entorno dinámico donde las condiciones climáticas cambian aleatoriamente. La simulación lee de un archivo de escenario que define la flota de aeronaves y sus coordenadas iniciales, y el programa luego genera la salida basada en el comportamiento y estado de cada aeronave según las condiciones del clima.

Este proyecto sigue los principios de la programación orientada a objetos, usando patrones de diseño como Singleton y Factory, así como excepciones personalizadas para manejar entradas inválidas o comportamientos inesperados.

### Estrcutura del proyecto

    com/jdasilva/avaj/
    |-- simulator/
    |   |-- Simulator.java         // Clase principal para ejecutar la simulación
    |   |-- WeatherTower.java      // Clase que representa la torre meteorológica
    |-- weather/
    |   |-- WeatherProvider.java   // Clase Singleton que genera el clima
    |-- aircraft/
    |   |-- Aircraft.java          // Clase base para todas las aeronaves
    |   |-- Helicopter.java        // Clase Helicóptero que implementa Flyable
    |   |-- JetPlane.java          // Clase Avión a Reacción que implementa Flyable
    |   |-- Balloon.java           // Clase Globo que implementa Flyable
    |-- exceptions/
    |   |-- InvalidInputFormatException.java  // Excepción personalizada para errores de formato
    |   |-- SimulationException.java          // Excepciones generales de simulación


### Como Funciona

1. Archivo de Escenario: El simulador lee la entrada desde un archivo de escenario, que contiene el número de pasos de simulación y los detalles de las aeronaves (tipo, nombre y coordenadas).
2. Torre Meteorológica: Las aeronaves se registran con la torre meteorológica para recibir actualizaciones del clima. Cada tipo de aeronave se comporta de manera diferente en función de los cambios climáticos (por ejemplo, los helicópteros pueden descender más rápido en condiciones de niebla).
3. Salida: Durante cada paso de simulación, el programa registra las acciones de cada aeronave en un archivo de texto, mostrando cómo se ven afectadas por el clima y proporcionando actualizaciones sobre su estado.

### Manejo de Excepciones Personalizadas

Este proyecto incluye excepciones personalizadas para manejar errores como formatos numéricos inválidos o valores fuera de rango. Algunas de las excepciones clave:

. InvalidInputFormatException: Se lanza cuando el archivo de escenario contiene datos mal formateados.
. OutOfRangeException: Se lanza cuando las coordenadas de una aeronave están fuera del rango permitido
