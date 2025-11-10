# 🧪 TESTING DE LA API - QueLeDoy Backend

## Herramientas Recomendadas

1. **Postman** - https://www.postman.com/
2. **Insomnia** - https://insomnia.rest/
3. **Thunder Client** (VS Code extension)
4. **cURL** (línea de comandos)
5. **Bruno** - https://www.usebruno.com/

---

## Base URL para Testing

```
http://localhost:8080/api
```

---

## 📌 EJEMPLOS DE REQUESTS

### 1️⃣ USUARIOS

#### Obtener todos los usuarios
```http
GET http://localhost:8080/api/usuarios
```

#### Obtener usuario por ID
```http
GET http://localhost:8080/api/usuarios/1
```

#### Crear usuario
```http
POST http://localhost:8080/api/usuarios
Content-Type: application/json

{
  "nombre": "Juan Pérez",
  "correo": "juan@example.com",
  "contrasena": "password123",
  "activo": true,
  "fechaRegistro": "2025-01-01"
}
```

#### Actualizar usuario
```http
PUT http://localhost:8080/api/usuarios/1
Content-Type: application/json

{
  "nombre": "Juan Carlos Pérez",
  "correo": "juancarlos@example.com",
  "contrasena": "newpassword",
  "activo": true,
  "fechaRegistro": "2025-01-01"
}
```

#### Eliminar usuario
```http
DELETE http://localhost:8080/api/usuarios/1
```

---

### 2️⃣ PRODUCTOS

#### Obtener todos los productos
```http
GET http://localhost:8080/api/productos
```

#### Obtener productos disponibles
```http
GET http://localhost:8080/api/productos/disponibles
```

#### Obtener productos destacados
```http
GET http://localhost:8080/api/productos/destacados
```

#### Crear producto
```http
POST http://localhost:8080/api/productos
Content-Type: application/json

{
  "nombre": "Camiseta Azul",
  "url": "https://example.com/camiseta-azul.jpg",
  "precio": 29.99,
  "descripcion": "Camiseta de algodón 100%",
  "activo": true,
  "destacado": true,
  "stock": 50
}
```

#### Actualizar producto
```http
PUT http://localhost:8080/api/productos/1
Content-Type: application/json

{
  "nombre": "Camiseta Azul Royal",
  "url": "https://example.com/camiseta-azul-royal.jpg",
  "precio": 34.99,
  "descripcion": "Camiseta de algodón 100% Royal",
  "activo": true,
  "destacado": false,
  "stock": 35
}
```

#### Eliminar producto
```http
DELETE http://localhost:8080/api/productos/1
```

---

### 3️⃣ CATEGORÍAS

#### Obtener todas las categorías
```http
GET http://localhost:8080/api/categorias
```

#### Crear categoría
```http
POST http://localhost:8080/api/categorias
Content-Type: application/json

{
  "nombre": "Electrónica"
}
```

#### Obtener categoría por nombre
```http
GET http://localhost:8080/api/categorias/nombre/Electrónica
```

---

### 4️⃣ ROLES

#### Obtener todos los roles
```http
GET http://localhost:8080/api/roles
```

#### Crear rol
```http
POST http://localhost:8080/api/roles
Content-Type: application/json

{
  "nombre": "ADMIN"
}
```

---

### 5️⃣ COLORES

#### Obtener todos los colores
```http
GET http://localhost:8080/api/colores
```

#### Crear color
```http
POST http://localhost:8080/api/colores
Content-Type: application/json

{
  "nombre": "Rojo"
}
```

---

### 6️⃣ GÉNEROS

#### Obtener todos los géneros
```http
GET http://localhost:8080/api/generos
```

#### Crear género
```http
POST http://localhost:8080/api/generos
Content-Type: application/json

{
  "nombre": "Hombre"
}
```

---

### 7️⃣ LISTAS

#### Obtener todas las listas
```http
GET http://localhost:8080/api/listas
```

#### Crear lista
```http
POST http://localhost:8080/api/listas
Content-Type: application/json

{
  "nombre": "Favoritos",
  "descripción": "Mi lista de productos favoritos"
}
```

---

### 8️⃣ IMÁGENES

#### Obtener todas las imágenes
```http
GET http://localhost:8080/api/imagenes
```

#### Crear imagen
```http
POST http://localhost:8080/api/imagenes
Content-Type: application/json

{
  "url": "https://example.com/imagen.jpg",
  "descripcion": "Imagen de producto"
}
```

---

## 🎯 TESTING CON cURL (Windows PowerShell)

### Obtener todos los usuarios
```powershell
curl -X GET "http://localhost:8080/api/usuarios" -H "Content-Type: application/json"
```

### Crear usuario
```powershell
$body = @{
    nombre = "Juan Pérez"
    correo = "juan@example.com"
    contrasena = "password123"
    activo = $true
    fechaRegistro = "2025-01-01"
} | ConvertTo-Json

curl -X POST "http://localhost:8080/api/usuarios" `
  -H "Content-Type: application/json" `
  -Body $body
```

### Crear producto
```powershell
$body = @{
    nombre = "Camiseta Azul"
    url = "https://example.com/camiseta.jpg"
    precio = 29.99
    descripcion = "Camiseta de algodón"
    activo = $true
    destacado = $true
    stock = 50
} | ConvertTo-Json

curl -X POST "http://localhost:8080/api/productos" `
  -H "Content-Type: application/json" `
  -Body $body
```

---

## 🔍 TESTING CON POSTMAN

### Pasos:

1. **Descargar e instalar Postman**
2. **Crear una nueva colección:** QueLeDoy API
3. **Crear request GET:**
   - URL: `http://localhost:8080/api/usuarios`
   - Método: GET
   - Click en Send

4. **Crear request POST:**
   - URL: `http://localhost:8080/api/productos`
   - Método: POST
   - Body → raw → JSON
   - Pegar JSON de producto
   - Click en Send

5. **Guardar requests** en la colección para reutilizar

---

## ✅ VERIFICACIÓN DE RESPUESTAS

### Respuesta Exitosa (GET)
```json
200 OK

[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "correo": "juan@example.com",
    "activo": true,
    "fechaRegistro": "2025-01-01",
    "rol": null,
    "lista": null
  }
]
```

### Respuesta Exitosa (POST)
```json
201 CREATED

{
  "id": 1,
  "nombre": "Camiseta Azul",
  "url": "https://example.com/camiseta.jpg",
  "precio": 29.99,
  "descripcion": "Camiseta de algodón",
  "activo": true,
  "destacado": true,
  "stock": 50
}
```

### Respuesta No Encontrada
```json
404 NOT FOUND

(vacío o mensaje de error)
```

### Respuesta Eliminación Exitosa
```json
204 NO CONTENT

(sin body)
```

---

## 🐛 TESTING DE ERRORES

### Request sin JSON (esperamos error)
```http
POST http://localhost:8080/api/usuarios
Content-Type: application/json

(vacío)
```

**Resultado:** 400 BAD REQUEST o 500 INTERNAL SERVER ERROR

### ID no existe
```http
GET http://localhost:8080/api/usuarios/99999
```

**Resultado:** 404 NOT FOUND

### Puerto no disponible
```
Error: connection refused
```

**Solución:** Verificar que el backend esté ejecutándose

---

## 📊 CHECKLIST DE TESTING

- [ ] GET todos los usuarios - 200 OK
- [ ] GET usuario por ID válido - 200 OK
- [ ] GET usuario por ID inválido - 404 NOT FOUND
- [ ] POST usuario válido - 201 CREATED
- [ ] PUT usuario - 200 OK
- [ ] DELETE usuario - 204 NO CONTENT
- [ ] GET todos los productos - 200 OK
- [ ] GET productos disponibles - 200 OK
- [ ] GET productos destacados - 200 OK
- [ ] POST producto - 201 CREATED
- [ ] PUT producto - 200 OK
- [ ] DELETE producto - 204 NO CONTENT
- [ ] GET categorías - 200 OK
- [ ] POST categoría - 201 CREATED
- [ ] GET roles - 200 OK
- [ ] POST rol - 201 CREATED
- [ ] GET colores - 200 OK
- [ ] POST color - 201 CREATED
- [ ] GET géneros - 200 OK
- [ ] POST género - 201 CREATED
- [ ] GET listas - 200 OK
- [ ] POST lista - 201 CREATED
- [ ] GET imágenes - 200 OK
- [ ] POST imagen - 201 CREATED
- [ ] CORS headers presentes - ✓

---

## 🔗 RELACIONES A TESTEAR (Próximas versiones)

Cuando se agreguen las relaciones en el JSON:

```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "correo": "juan@example.com",
  "rol": {
    "id": 1,
    "nombre": "ADMIN"
  },
  "lista": {
    "id": 1,
    "nombre": "Favoritos"
  }
}
```

---

## 📱 TESTING EN DISPOSITIVOS MÓVILES

### Acceder desde otro dispositivo en la red local:

1. Obtener IP local de tu PC:
```powershell
ipconfig
# Buscar IPv4 Address (ej: 192.168.x.x)
```

2. Usar esa IP en las requests:
```
http://192.168.1.100:8080/api/usuarios
```

---

## 📝 NOTAS IMPORTANTES

- ⚠️ La contraseña se devuelve con `@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)` - no se mostrará en GET
- ⚠️ Las fechas deben estar en formato `YYYY-MM-DD`
- ⚠️ Los IDs se generan automáticamente en POST
- ⚠️ No es necesario enviar `id` en POST (se ignora)
- ✅ Todos los endpoints soportan CORS

---

**Documento de Testing - 10 de Noviembre de 2025**
