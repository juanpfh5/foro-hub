# **🎯 Foro Hub**

Foro Hub es una aplicación desarrollada como parte del programa Oracle ONE. Su objetivo es gestionar usuarios y tópicos en un foro, ofreciendo una plataforma eficiente y segura para interactuar y compartir ideas.

---

## **🚀 Tecnologías Utilizadas**

- **☕ Java**: Lenguaje principal para el desarrollo.
- **🌱 Spring Boot**: Framework para el desarrollo de aplicaciones backend.
- **📦 Maven**: Herramienta de gestión de dependencias.
- **🐬 MySQL**: Base de datos relacional.

---

## **📋 Requisitos Previos**

Antes de iniciar, asegúrate de tener instalados los siguientes componentes:

- **✅ Java** 17 o superior
- **✅ Maven** 3.6.0 o superior
- **✅ MySQL** 5.7 o superior

---

## **⚙️ Configuración**

Es necesario configurar las siguientes variables de entorno en tu sistema para que la aplicación funcione correctamente:

- `🖧 DB_HOST`: Dirección del servidor MySQL.
- `🗄️ DB_NAME`: Nombre de la base de datos.
- `👤 DB_USER`: Usuario de la base de datos.
- `🔒 DB_PASSWORD`: Contraseña de la base de datos.
- `🛡️ JWT_SECRET`: Secreto para la generación de tokens JWT (por defecto: `123456`).

También puedes establecer estos valores directamente en el archivo de propiedades de la aplicación:  
📁 `src/main/resources/application.properties`.

---

## **📦 Instalación**

1. **Clonar el repositorio:**
   ```sh
   git clone https://github.com/juanpfh5/foro-hub.git
   cd foro-hub
   ```

2. **Configurar las propiedades de la aplicación:**  
   Edita las variables en el archivo `application.properties` o usa las variables de entorno indicadas anteriormente.

3. **Compilar y ejecutar la aplicación**

---

## **🌐 Endpoints**

### **📌 Tópicos**

- **📄 GET /topicos**  
  Lista todos los tópicos registrados.

- **➕ POST /topicos**  
  Crea un nuevo tópico.  
  **📥 Body JSON esperado:**
  ```json
  {
    "titulo": "Título del tópico",
    "mensaje": "Mensaje del tópico",
    "fecha": "2025-01-01T10:00:00",
    "id_usuario": 1,
    "id_curso": 1
  }
  ```

- **✏️ PUT /topicos/{id}**  
  Actualiza un tópico existente.  
  **📥 Body JSON esperado:** Igual al de creación.

- **❌ DELETE /topicos/{id}**  
  Elimina un tópico.

### **👤 Usuarios**

- **📄 GET /usuarios**  
  Lista todos los usuarios registrados.

- **➕ POST /usuarios**  
  Crea un nuevo usuario.  
  **📥 Body JSON esperado:**
  ```json
  {
    "nombre": "Nombre del usuario",
    "correoElectronico": "correo@ejemplo.com",
    "contrasenia": "contraseñaSegura"
  }
  ```

### **🔐 Autenticación (Login)**

- **🔑 POST /login**  
  Permite iniciar sesión y obtener un token JWT.  
  **📥 Body JSON esperado:**
  ```json
  {
    "correoElectronico": "correo@ejemplo.com",
    "contrasenia": "contraseñaSegura"
  }
  ```

  **📤 Respuesta JSON:**
  ```json
  {
    "bearer": "jwt_generado"
  }
  ```

---


## **📌 Notas Adicionales**

- 🔒 El sistema utiliza JWT (JSON Web Tokens) para la autenticación de los endpoints protegidos.
- ⚠️ Asegúrate de configurar correctamente el `JWT_SECRET` para mantener la seguridad de los tokens.

---
