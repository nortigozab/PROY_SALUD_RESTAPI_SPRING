# PROY_SALUD_RESTAPI_SPRING

## Descripción
El proyecto consiste en un aplicativo web (REST API) para la gestión de pacientes, doctores y citas médicas. Permite capturar información a través de formularios, almacenarla en una base de datos (MariaDB) y mostrarla en páginas web utilizando DOM.

## Objetivo
El objetivo es proporcionar una solución completa, eficiente y segura para la administración de datos médicos.

## Tecnologías utilizadas
- [Spring Boot](https://spring.io/projects/spring-boot): Framework de desarrollo de aplicaciones Java. <i class="fab fa-java"></i> :rocket:
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Biblioteca de persistencia que facilita el acceso y la manipulación de datos relacionales en aplicaciones Java. <i class="fas fa-database"></i> :floppy_disk:
- [Spring Web](https://spring.io/projects/spring-web): Biblioteca para el desarrollo de aplicaciones web basadas en el framework Spring. <i class="fab fa-spring"></i> :globe_with_meridians:
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools): Conjunto de herramientas para facilitar el desarrollo en Spring Boot, como la reinicialización automática y la recarga en vivo. <i class="fas fa-tools"></i> :wrench:
- [MariaDB Java Client](https://mariadb.com/kb/en/mariadb-connector-j/): Controlador JDBC para la conexión y comunicación con la base de datos MariaDB. <i class="fas fa-database"></i> :computer:
- [Project Lombok](https://projectlombok.org/): Biblioteca que agrega funcionalidades a Java para reducir la cantidad de código boilerplate, como la generación automática de getters/setters y constructores. <i class="fab fa-java"></i> :bookmark:
- [Spring Boot Test](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.testing-autoconfigured-tests): Framework para realizar pruebas unitarias y de integración en aplicaciones Spring Boot. <i class="fas fa-vial"></i> :microscope:


## Entorno de desarrollo

La aplicación se desarrolló y probó en el siguiente entorno:

- **Sistema operativo**: <i class="fab fa-linux"></i> Linux (derivado de Arch Linux, EndeavourOS) :penguin:
- **Herramienta de desarrollo**: <i class="fab fa-java"></i> IntelliJ IDEA :computer:
- **Base de datos**: <i class="fas fa-database"></i> DBeaver :floppy_disk:
- **Navegador web**: <i class="fab fa-chrome"></i> Google Chrome :globe_with_meridians:
- **Cliente de solicitudes HTTP**: <i class="fab fa-insomnia"></i> Insomnia :link:

## Instalación y Ejecución de la Aplicación :zap:

1. Clona este repositorio ejecutando el siguiente comando:

   ```bash
   git clone https://github.com/nortigozab/PROY_SALUD_RESTAPI_SPRING.git
   cd PROY_SALUD_RESTAPI_SPRING
   ```

2. Abre el proyecto en tu IDE preferido, como IntelliJ IDEA, Eclipse u otro.

3. Configura el entorno de desarrollo según las instrucciones de tu IDE.

4. Ejecuta la aplicación desde tu IDE.

Con estos pasos, podrás clonar el repositorio, abrir el proyecto en tu IDE preferido y ejecutar la aplicación de Spring Boot. Asegúrate de tener las configuraciones y dependencias adecuadas en tu entorno de desarrollo antes de ejecutar la aplicación.

## :key:Recuerda que se debe crear el archivo **application.properties** para que la API funcione.

- Asegurese que debe tener el nombre **application.properties** en la ruta **/src/main/resources**
- Ingresar los datos segun esta estructura

```bash
spring.datasource.url=jdbc:mariadb://localhost:3306/salud_spring
spring.datasource.username=root
spring.datasource.password=********
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql: true
```
:warning: **Advertencia:** Recuerde yo utilice mariaDB como motor de bases de datos por mi entorno de desarrollo, si en su caso utilizara mysql haga el cambio tanto en las dependencia como en el archivo anterior con una estructura parecida a esta:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/salud_spring
spring.datasource.username=root
spring.datasource.password=********
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
```
## Probar

**🎉Abre el software de solicitud http que utilices en este caso utilice **insomnia** y utiliza la url `https://127.0.0.1:8080` o el puerto que le asigne**


## Linea de Tiempo

### Prueba #1

En esta prueba se hace  para pacientes desde insomnia

| Descripcion                                                                                                                                                            |                   Soporte                   |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------| :-----------------------------------------: |
| En esta prueba se hace  para pacientes desde insomnia<br/> - Consulta Todos<br/>- Consulta un paciente<br/>- Edita Paciente<br/>- Elimina Paciente<br/>- Crea Paciente | ![Soporte 1](./img/1.gif?raw=true "import") |

### Prueba #2

En esta prueba se hace para doctores desde insomnia

| Descripcion                                                                                                                                                 |                   Soporte                   |
|:------------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------:|
| En esta prueba se hace para doctores desde insomnia<br/>- Consulta Todos<br/>- Consulta un doctor<br/>- Edita Doctor<br/>- Elimina Doctor<br/>- Crea Doctor | ![Soporte 2](./img/2.gif?raw=true "import") |

### Prueba #3

En esta prueba se hace para citas medicas desde insomnia

| Descripcion                                                                                                                                             |                   Soporte                   |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------:|
| En esta prueba se hace para citas medicas desde insomnia<br/>- Consulta Todos<br/>- Consulta una Cita medica<br/>- Crea Cita Medica | ![Soporte 3](./img/3.gif?raw=true "import") |


### Prueba #4

En esta prueba se hace ya con todas con algunas limitaciones de forma grafica

| Pacientes                              | Doctores | CitasMedicas                 |
|:---------------------------------------|:--------:|:-----------------------------|
| - Post<br/>- Get<br/>- Put<br/>-Delete |   - Post<br/>- Get<br/>-Delete       | - Post<br/>- Get             |


:warning: **Correcion:**  En el video se ve como se elimina paciente sin confirmacion, ya en el codigo esta corregido. 
---
## Rutas

## Citas Medicas
### Ruta: **GET /api/citasmedicas**
   - Descripción: Obtiene todas las citas médicas y especialidades.
  - Funcionalidad:

     - Llama al método getCitasMedicasTodo() del servicio citasMedicasTodoService para obtener todas las citas médicas. 
     - Llama al método getEspecialidades() del servicio especialidadesService para obtener todas las especialidades. 
     - Devuelve una respuesta con un objeto JSON que contiene las citas médicas y las especialidades.
### Ruta: **GET /api/citasmedicas/{id_cita}**
   - Descripción: Obtiene una cita médica específica por su ID.
  - Funcionalidad:
    - Recibe el parámetro de ruta id_cita que representa el ID de la cita médica. 
    - Llama al método getCitaMedicaTodo(id_cita) del servicio citasMedicasTodoService para obtener la cita médica correspondiente al ID. 
    - Si se encuentra la cita médica, devuelve una respuesta con un objeto JSON que contiene la cita médica. 
    - Si no se encuentra la cita médica, devuelve una respuesta de error con un mensaje.
---
### Ruta: **GET /api/citasmedicas/crear/{especia}**
   - Descripción: Crea una cita médica y obtiene las especialidades y doctores según el tipo de creación.
  - Funcionalidad:
    - Recibe el parámetro de ruta especia que representa el tipo de creación de cita médica. 
    - Si especia es "n", obtiene todas las especialidades y establece la lista de doctores como nula. 
    - Si especia no es "n", obtiene los doctores según el ID de la especialidad y establece la lista de especialidades como nula. 
    - Devuelve una respuesta con un objeto JSON que contiene las especialidades y los doctores según el tipo de creación.
---
### Ruta: **POST /api/citasmedicas** 
  - Descripción: Guarda una nueva cita médica.
  - Funcionalidad:
    - Recibe los datos de la cita médica en el cuerpo de la solicitud en formato JSON. 
    - Valida si se proporciona un número de cédula o no. 
    - Si no se proporciona un número de cédula, crea una nueva cita médica sin asociarla a ningún paciente. 
    - Si se proporciona un número de cédula, busca un paciente existente con esa cédula y crea una nueva cita médica asociada a ese paciente. 
    - Devuelve una respuesta con el objeto JSON de la cita médica guardada si se guarda correctamente. 
    - Si ocurre algún error durante el proceso de guardado, devuelve una respuesta de error con un mensaje.
---
## Doctores

### Ruta: GET /api/doctores

- Descripción: Obtiene todos los doctores y especialidades.
- Funcionalidad:
   - Llama al método `getDoctores()` del servicio `doctoresEspeService` para obtener todos los doctores.
   - Llama al método `getEspecialidades()` del servicio `especialidadesService` para obtener todas las especialidades.
   - Devuelve una respuesta con un objeto JSON que contiene los doctores y las especialidades.

---

### Ruta: GET /api/doctores/{id_doctor}

- Descripción: Obtiene un doctor específico por su ID.
- Funcionalidad:
   - Recibe el parámetro de ruta `id_doctor` que representa el ID del doctor.
   - Llama al método `getDoctorEspe(id_doctor)` del servicio `doctoresEspeService` para obtener el doctor correspondiente al ID.
   - Llama al método `getEspecialidades()` del servicio `especialidadesService` para obtener todas las especialidades.
   - Si se encuentra el doctor, devuelve una respuesta con un objeto JSON que contiene el doctor y las especialidades.
   - Si no se encuentra el doctor, devuelve una respuesta de error con un mensaje.

---

### Ruta: POST /api/doctores

- Descripción: Guarda un nuevo doctor.
- Funcionalidad:
   - Recibe los datos del doctor en el cuerpo de la solicitud en formato JSON.
   - Llama al método `saveOrUpdate(doctores)` del servicio `doctoresService` para guardar el doctor.
   - Si se guarda correctamente, devuelve una respuesta con el objeto JSON del nuevo doctor y el estado HTTP 201 (CREATED).
   - Si ocurre algún error durante el proceso de guardado, devuelve una respuesta de error con un mensaje y el estado HTTP 500 (INTERNAL_SERVER_ERROR).

---

### Ruta: PUT /api/doctores/{id_doctor}

- Descripción: Actualiza un doctor existente por su ID.
- Funcionalidad:
   - Recibe el parámetro de ruta `id_doctor` que representa el ID del doctor a actualizar.
   - Recibe los datos actualizados del doctor en el cuerpo de la solicitud en formato JSON.
   - Llama al método `getDoctor(id_doctor)` del servicio `doctoresService` para obtener el doctor existente.
   - Si se encuentra el doctor, actualiza los campos del doctor con los nuevos valores.
   - Llama al método `saveOrUpdate(doctorId)` del servicio `doctoresService` para guardar los cambios.
   - Si se guarda correctamente, devuelve una respuesta con el objeto JSON del doctor actualizado y el estado HTTP 201 (CREATED).
   - Si no se encuentra el doctor, devuelve una respuesta de error con el estado HTTP 404 (NOT_FOUND).
   - Si ocurre algún error durante el proceso de actualización, devuelve una respuesta de error con un mensaje y el estado HTTP 500 (INTERNAL_SERVER_ERROR).

---

### Ruta: DELETE /api/doctores/{id_doctor}

- Descripción: Elimina un doctor existente por su ID.
- Funcionalidad:
   - Recibe el parámetro de ruta `id_doctor` que representa el ID del doctor a eliminar.
   - Llama al método `getDoctor(id_doctor)` del servicio `doctoresService` para obtener el doctor existente.
   - Si se encuentra el doctor, llama al método `delete(id_doctor)` del servicio `doctoresService` para eliminar el doctor.
   - Si se elimina correctamente, devuelve una respuesta con un objeto JSON que indica el estado "Eliminado" como verdadero y el estado HTTP 200 (OK).
   - Si no se encuentra el doctor, devuelve una respuesta con un objeto JSON que indica el mensaje de error y el estado "Eliminado" como falso, y el estado HTTP 500 (INTERNAL_SERVER_ERROR).
---
## Pacientes

### Ruta: GET /api/pacientes

- Descripción: Obtiene todos los pacientes.
- Funcionalidad:
   - Llama al método `getPacientes()` del servicio `pacientesService` para obtener todos los pacientes.
   - Devuelve una lista de pacientes.

---

### Ruta: GET /api/pacientes/{id_paciente}

- Descripción: Obtiene un paciente específico por su ID.
- Funcionalidad:
   - Recibe el parámetro de ruta `id_paciente` que representa el ID del paciente.
   - Llama al método `getPaciente(id_paciente)` del servicio `pacientesService` para obtener el paciente correspondiente al ID.
   - Si se encuentra el paciente, devuelve una respuesta con un objeto JSON que contiene el paciente.
   - Si no se encuentra el paciente, devuelve una respuesta de error con un mensaje.

---

### Ruta: POST /api/pacientes

- Descripción: Guarda un nuevo paciente.
- Funcionalidad:
   - Recibe los datos del paciente en el cuerpo de la solicitud en formato JSON.
   - Llama al método `saveOrUpdate(pacientes)` del servicio `pacientesService` para guardar el paciente.
   - Si se guarda correctamente, devuelve una respuesta con el objeto JSON del nuevo paciente y el estado HTTP 201 (CREATED).
   - Si ocurre algún error durante el proceso de guardado, devuelve una respuesta de error con un mensaje y el estado HTTP 500 (INTERNAL_SERVER_ERROR).

---

### Ruta: PUT /api/pacientes/{id_paciente}

- Descripción: Actualiza un paciente existente por su ID.
- Funcionalidad:
   - Recibe el parámetro de ruta `id_paciente` que representa el ID del paciente a actualizar.
   - Recibe los datos actualizados del paciente en el cuerpo de la solicitud en formato JSON.
   - Llama al método `getPaciente(id_paciente)` del servicio `pacientesService` para obtener el paciente existente.
   - Si se encuentra el paciente, actualiza los campos del paciente con los nuevos valores.
   - Realiza la conversión y manipulación de la fecha de nacimiento:
      - Obtiene la fecha del paciente como una cadena.
      - Formatea la cadena de fecha a un objeto `LocalDate`.
      - Agrega un día a la fecha.
      - Asigna la fecha formateada al objeto `Pacientes`.
   - Llama al método `saveOrUpdate(pacienteId)` del servicio `pacientesService` para guardar los cambios.
   - Si se guarda correctamente, devuelve una respuesta con el objeto JSON del paciente actualizado y el estado HTTP 201 (CREATED).
   - Si no se encuentra el paciente, devuelve una respuesta de error con el estado HTTP 404 (NOT_FOUND).
   - Si ocurre algún error durante el proceso de actualización, devuelve una respuesta de error con un mensaje y el estado HTTP 500 (INTERNAL_SERVER_ERROR).

---

### Ruta: DELETE /api/pacientes/{id_paciente}

- Descripción: Elimina un paciente existente por su ID.
- Funcionalidad:
   - Recibe el parámetro de ruta `id_paciente` que representa el ID del paciente a eliminar.
   - Llama al método `getPaciente(id_paciente)` del servicio `pacientesService` para obtener el paciente existente.
   - Si se encuentra el paciente, llama al método `delete(id_paciente)` del servicio `pacientesService` para eliminar el paciente.
   - Si se elimina correctamente, devuelve una respuesta con un objeto JSON que indica el estado "Eliminado" como verdadero y el estado HTTP 200 (OK).
   - Si no se encuentra el paciente, devuelve una respuesta con un objeto JSON que indica el mensaje de error y el estado "Eliminado" como falso, y el estado HTTP 500 (INTERNAL_SERVER_ERROR).
