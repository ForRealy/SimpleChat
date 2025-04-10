# Simple Chat - Aplicación de Chat en Tiempo Real con Firebase

Aplicación de chat simple que permite comunicación en tiempo real utilizando Firebase. Incluye funciones como nicknames personalizados, historial de mensajes y un divertido "Modo Fiesta" con efectos visuales.

## Características Principales
- 🧑💻 Nicknames personalizados
- 🔥 Mensajería en tiempo real con Firebase
- 🎨 Colores únicos por usuario
- 🎉 Modo Fiesta con:
  - 🌈 Cambios de color dinámicos
  - 🎈 Animación de globos
  - ⏳ Sistema de enfriamiento (30 segundos)
- 📜 Historial de últimos 10 mensajes

## Estructura del Proyecto
```
project/
├── src/
│ ├── main/
│ │ ├── java/org/example/
│ │ │ ├── ChatCommand.java // Manejo de comandos
│ │ │ ├── ChatListener.java // Escucha mensajes
│ │ │ ├── FirebaseConfig.java // Configuración Firebase
│ │ │ └── Main.java // Punto de entrada
│ │ └── resources/
│ │ └── service-account.json // Credenciales Firebase
├── web/
│ ├── chat.html // Interfaz de chat
│ ├── login.html // Página de login
│ └── style.css // Estilos CSS`
```
