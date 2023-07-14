# PROY_SALUD_RESTAPI_SPRING

## Descripción
El proyecto consiste en un aplicativo web (REST API) para la gestión de pacientes, doctores y citas médicas. Permite capturar información a través de formularios, almacenarla en una base de datos (MariaDB) y mostrarla en páginas web utilizando DOM.

## Objetivo
El objetivo es proporcionar una solución completa, eficiente y segura para la administración de datos médicos.

Según el archivo XML proporcionado, las tecnologías utilizadas en el proyecto son las siguientes:

## Tecnologías utilizadas
- [Spring Boot](https://spring.io/projects/spring-boot): Framework de desarrollo de aplicaciones Java. <i class="fab fa-java"></i> :rocket:
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Biblioteca de persistencia que facilita el acceso y la manipulación de datos relacionales en aplicaciones Java. <i class="fas fa-database"></i> :floppy_disk:
- [Spring Web](https://spring.io/projects/spring-web): Biblioteca para el desarrollo de aplicaciones web basadas en el framework Spring. <i class="fab fa-spring"></i> :globe_with_meridians:
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools): Conjunto de herramientas para facilitar el desarrollo en Spring Boot, como la reinicialización automática y la recarga en vivo. <i class="fas fa-tools"></i> :wrench:
- [MariaDB Java Client](https://mariadb.com/kb/en/mariadb-connector-j/): Controlador JDBC para la conexión y comunicación con la base de datos MariaDB. <i class="fas fa-database"></i> :computer:
- [Project Lombok](https://projectlombok.org/): Biblioteca que agrega funcionalidades a Java para reducir la cantidad de código boilerplate, como la generación automática de getters/setters y constructores. <i class="fab fa-java"></i> :bookmark:
- [Spring Boot Test](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.testing-autoconfigured-tests): Framework para realizar pruebas unitarias y de integración en aplicaciones Spring Boot. <i class="fas fa-vial"></i> :microscope:


Aquí tienes la adaptación del texto con los iconos correspondientes:

## Entorno de desarrollo

La aplicación se desarrolló y probó en el siguiente entorno:

- Sistema operativo: <i class="fab fa-linux"></i> Linux (derivado de Arch Linux, EndeavourOS) :penguin:
- Herramienta de desarrollo: <i class="fab fa-java"></i> IntelliJ IDEA :computer:
- Base de datos: <i class="fas fa-database"></i> DBeaver :floppy_disk:
- Navegador web: <i class="fab fa-chrome"></i> Google Chrome :globe_with_meridians:
- Cliente de solicitudes HTTP: <i class="fab fa-insomnia"></i> Insomnia :link:

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
:warning: **Advertencia:** Recuerde yo utilice mariaDB como motor de bases de datos por mi distribucion de entorno si en su caso utilizara mysql haga el cambio tanto en las dependecia como en el archivo anterior con una structura parecida a esta:
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

En esta prueba se hace la prueba para pacientes desde insomnia

| Descripcion                                                     |                   Soporte                   |
|:----------------------------------------------------------------| :-----------------------------------------: |
| En esta prueba se hace la prueba para pacientes desde insomnia  | ![Soporte 1](./img/1.gif?raw=true "import") |

