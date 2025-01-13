# Motivus Exercise

Este proyecto implementa varias funcionalidades utilizando Spring Boot, incluyendo un CRUD para un catálogo de productos, filtrado de usuarios, un sistema de notificaciones basado en eventos y un sistema básico de autenticación JWT.

## Tabla de Contenidos

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Branches](#branches)
- [Endpoints](#endpoints)
- [Contribución](#contribución)
- [Licencia](#licencia)
- [Secretos](#secretos)

## Descripción del Proyecto

Este proyecto contiene las siguientes implementaciones:

1. **CRUD para un Catálogo de Productos**: Permite crear, leer, actualizar y eliminar productos.
2. **Filtrado de Usuarios**: Filtra usuarios por edad a partir de un archivo con millones de registros.
3. **Sistema de Notificaciones Basado en Eventos**: Implementa un microservicio para gestionar notificaciones.
4. **Autenticación JWT**: Sistema básico de autenticación y autorización basado en roles.

## Branches

### 1. [API Restful CRUD](https://github.com/Josedlc/motivus-exercise/tree/1-API-Restful-CRUD)

Se implementó un CRUD para un catálogo de productos con las siguientes propiedades:

- **ID** (único)
- **Nombre**
- **Descripción**
- **Precio**
- **Fecha de creación**

### Endpoints

- **Crear Producto**: `POST http://localhost:8080/backend/api/v1/api/productos/create`
- **Obtener Todos los Productos**: `GET http://localhost:8080/backend/api/v1/api/productos/get`
- **Actualizar Producto**: `PUT http://localhost:8080/backend/api/v1/api/productos/update/{id}`
- **Obtener Producto por ID**: `GET http://localhost:8080/backend/api/v1/api/productos/get/{id}`
- **Eliminar Producto**: `DELETE http://localhost:8080/backend/api/v1/api/productos/delete/{id}`

---

### 2. [Filtrado de Usuarios](https://github.com/Josedlc/motivus-exercise/tree/2-filtrado-usuarios)

Se implementó un algoritmo eficiente que procesa grandes volúmenes de datos.

**Requisitos**:
- Dado un archivo con millones de registros de usuarios, filtrar aquellos con edades entre 25 y 40 años y exportarlos a un nuevo archivo.
- Usar Streams y programación funcional para procesar los datos.
- Paralelizar la operación para mejorar el rendimiento.

### Endpoints

- **Filtrar Usuarios**: `GET http://localhost:8080/backend/api/v1/api/users/filter?min=25&max=40`

---

### 3. [Eventos Asincronos](https://github.com/Josedlc/motivus-exercise/tree/3-eventos-asincronos)

Se diseñó un sistema de notificaciones basado en eventos.

**Requisitos**:
- Implementar un microservicio que reciba solicitudes HTTP para registrar notificaciones.
- Procesar las solicitudes de forma asíncrona utilizando RabbitMQ o Kafka.
- Registrar las notificaciones procesadas en una base de datos (por ejemplo, PostgreSQL o MongoDB).
- Implementar un endpoint para consultar el historial de notificaciones.

### Endpoints

- **Enviar Notificación**: `POST http://localhost:8080/backend/api/v1/api/notificaciones/send`
- **Obtener Historial de Notificaciones**: `GET http://localhost:8080/backend/api/v1/api/notificaciones/get`

---

### 4. [Sistema de Autenticación JWT](https://github.com/Josedlc/motivus-exercise/tree/4-autenticacion-oauth)

Se implementó un sistema básico de autenticación JWT.

**Requisitos**:
- Crear un servicio que permita registrar usuarios con credenciales.
- Implementar login para generar un JWT.
- Proteger endpoints con autenticación basada en roles (por ejemplo, ADMIN, USER).
- Opcional: Habilitar integración con OAuth2 (Google o GitHub).

### Endpoints

- **Registrar Usuario**: `POST http://localhost:8080/backend/api/v1/api/auth/register`
- **Login**: `POST http://localhost:8080/backend/api/v1/api/auth/login`
- **Login Github**: `GET http://localhost:8080/backend/api/v1/oauth2/authorization/github`
- **Endpoints solo para ADMIN**:
  - **Actualizar Usuario**: `PUT http://localhost:8080/backend/api/v1/api/admin/update/1`
  - **Obtener Usuarios**: `GET http://localhost:8080/backend/api/v1/api/admin/getUsers`
  - **Eliminar Usuario**: `DELETE http://localhost:8080/backend/api/v1/api/admin/delete/1`

---

## Contribución

 Instrucciones sobre cómo contribuir al proyecto. Puedes incluir un enlace a un archivo `CONTRIBUTING.md` si lo tienes.

1. Haz un fork del proyecto.
2. Crea tu branch (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agregué una nueva característica'`).
4. Haz push a tu branch (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia



## Secretos

Los secretos y credenciales se comparten aparte por razones de seguridad. Asegúrate de no incluir información sensible en el repositorio. Utiliza un archivo de configuración o variables de entorno para manejar secretos de manera segura.
