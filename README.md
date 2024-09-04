# Libreta de Contactos API

## Descripción

Este proyecto es una API REST para la gestión de una libreta de contactos. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre contactos, utilizando Spring Boot para el backend y una base de datos relacional para el almacenamiento.

## Requisitos

Antes de lanzar el proyecto, asegúrate de tener instaladas las siguientes herramientas:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) o superior
- [Maven](https://maven.apache.org/download.cgi) (para gestionar las dependencias del proyecto)
- [MySQL](https://dev.mysql.com/downloads/) o cualquier otra base de datos relacional
- [Postman](https://www.postman.com/downloads/) (opcional, para probar los endpoints de la API)

## Configuración

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tu-usuario/libreta-contactos-api.git
   cd libreta-contactos-api
2.Configura la base de datos:

spring.datasource.url=jdbc:mysql://localhost:3306/tu_basededatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

3.Lanzar el Aplicativo Maven
