# Feria Empresarial


# Descripción del Proyecto

Este proyecto implementa un sistema de gestión para una feria empresarial utilizando programación orientada a objetos en Java. El sistema permite administrar empresas, stands, visitantes y sus interacciones en un evento ferial.
# Funcionalidades Principales
El sistema ofrece las siguientes funcionalidades:

# Gestión de Empresas:

- Registro de empresas con nombre, sector y correo electrónico
- Edición de información de empresas
- Eliminación de empresas
- Asignación de empresas a stands


# Gestión de Stands:

- Registro de stands con ubicación (pabellones A-Z), tamaño y número único
- Visualización de disponibilidad de stands
- Asignación de stands a empresas


# Gestión de Visitantes:

- Registro de visitantes con nombre, identificación y correo
- Edición de información de visitantes
- Eliminación de visitantes


# Sistema de Comentarios y Calificaciones:

- Registro de visitas a stands
- Evaluación de stands mediante calificaciones de 1 a 5
- Registro de comentarios con fecha de visita
- Visualización de comentarios por stand


# Informes y Estadísticas:

- Listado de stands ocupados y disponibles
- Visualización de empresas con sus stands asignados
- eporte de stands visitados por cada visitante
- Cálculo de calificación promedio de cada stand



# Estructura del Proyecto
El proyecto está organizado en las siguientes clases principales:

- Feria: Clase principal que contiene el método main y coordina todas las operaciones del sistema.
- Empresa: Gestiona la información y operaciones relacionadas con las empresas participantes.
- Stand: Administra los espacios físicos donde se ubicarán las empresas.
- Visitante: Maneja la información y operaciones relacionadas con los visitantes de la feria.
- Comentario: Gestiona las opiniones, calificaciones y visitas registradas por los visitantes a los stands.

# Tests Unitarios
El proyecto incluye tests unitarios para verificar el correcto funcionamiento de las operaciones principales. La clase EmpresaTest contiene pruebas para:

- Selección de sector empresarial
- Registro de empresas
- Eliminación de empresas
- Visualización de empresas con stands asignados

#Instrucciones de Ejecución
Para ejecutar el proyecto:

- Clone el repositorio o descargue los archivos fuente
- Asegúrese de tener instalado Java JDK (versión 8 o superior)
- Compile todas las clases
- Ejecute la clase principal Feria()

  # Para ejecutar los tests unitarios:
  - Asegúrese de tener JUnit configurado en su entorno
  - Ejecute la clase EmpresaTest

# Flujo de Trabajo

Al iniciar el programa, se presenta un menú con 16 opciones que permiten realizar todas las operaciones del sistema. El usuario puede navegar por las diferentes funcionalidades siguiendo las instrucciones en pantalla.


1. Clonar el repositorio:  
   ```sh
   https://github.com/jeissonsierra1/Feria.git
```  
