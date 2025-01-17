# Foro-hub-challenge

Este proyecto contiene la implementación de un controlador REST para gestionar la entidad **Tópico**. La API permite realizar operaciones CRUD sobre tópicos y está desarrollada en **Java** utilizando el framework **Spring Boot**.

## Endpoints

### Crear un nuevo tópico
- **URL**: `/topicos`
- **Método**: `POST`
- **Descripción**: Permite registrar un nuevo tópico en el sistema.
- **Request Body**:
  ```json
  {
      "titulo": "string",
      "mensaje": "string",
      "autor": "string",
      "curso": "string"
  }
  ```
  
- # Respuesta Exitosa:
- **Código**: 201 Created
- **Cuerpo**:
```json
  {
      "id": "long",
      "titulo": "string",
      "mensaje": "string",
      "fechaCreacion": "yyyy-MM-dd",
      "status": "string",
      "autor": "string",
      "curso": "string"
  }
```

### Listar todos los tópicos
- **URL**: `/topicos`
- **Método**: `GET`
- **Descripción**: Recupera una lista paginada de todos los tópicos registrados.
- **Parámetros de Consulta**:
  - `size` (opcional, por defecto 10): Tamaño de la página.
  - `page` (opcional): Número de la página.
- **Respuesta Exitosa**:
  - **Código**: `200 OK`
  - **Cuerpo**: Página de tópicos con el siguiente formato:
    ```json
    {
        "content": [
            {
                "id": "long",
                "titulo": "string",
                "mensaje": "string",
                "fechaCreacion": "yyyy-MM-dd",
                "status": "string",
                "autor": "string",
                "curso": "string"
            }
        ],
        "totalElements": "long",
        "totalPages": "int",
        "size": "int",
        "number": "int"
    }
    ```
### Actualizar un tópico
- **URL**: `/topicos`
- **Método**: `PUT`
- **Descripción**: Permite actualizar los detalles de un tópico existente.
- **Request Body**:
  ```json
  {
      "id": "long",
      "titulo": "string",
      "mensaje": "string",
      "status": "string",
      "autor": "string",
      "curso": "string"
  }
  ```
  - # Respuesta Exitosa:
- **Código**: 200 OK
- **Cuerpo**:
```json
  {
      "id": "long",
      "titulo": "string",
      "mensaje": "string",
      "status": "string",
      "autor": "string",
      "curso": "string"
  }
```
### Eliminar un tópico
- **URL**: `/topicos/{id}`
- **Método**: `DELETE`
- **Descripción**: Elimina un tópico por su ID.
- **Parámetros**:
  - `id`: ID del tópico a eliminar.
- **Respuesta Exitosa**:
  - **Código**: `204 No Content`

---

### Validaciones y Manejo de Errores
- **ValidacionException**: Se lanza en los siguientes casos:
  - No existe un tópico con el ID proporcionado.
  - El ID proporcionado es inválido (por ejemplo, menor o igual a 0).

---

### Tecnologías Utilizadas
- Java 17
- Spring Boot
- Hibernate
- JPA
- Validación con Bean Validation (Jakarta Validation)
- Base de datos (configurable, ejemplo: H2 o MySQL)

 
