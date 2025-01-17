# foro-hub-challenge

# TopicoController API

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
