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
│ └── style.css // Estilos CSS
```

## Requisitos Previos
- Java JDK 11+
- Maven
- Cuenta en Firebase

## Configuración Inicial

1. **Firebase Setup:**
   - Crea un proyecto en [Firebase Console](https://console.firebase.google.com/)
   - Habilitar **Realtime Database**
   - Generar archivo de credenciales (`service-account.json`) en:
   `Firebase Console > Configuración del proyecto > Cuentas de servicio`

2. **Configuración de Credenciales:**
```bash
mkdir -p src/main/resources
cp tu-archivo-credenciales.json src/main/resources/service-account.json
```

```
<dependencies>
    <dependency>
        <groupId>com.google.firebase</groupId>
        <artifactId>firebase-admin</artifactId>
        <version>9.2.0</version>
    </dependency>
</dependencies>
```

Modo Fiesta 🎉

Al activarlo:
- Cambios de color de fondo aleatorios
- Lluvia de globos animados
- Barra de progreso para recarga (30 segundos)
```
function activatePartyMode() {
    let partyTimer;
    let balloonInterval;
    let balloonCount = 0; // Contador de globos

    // Cambiar el fondo de la página a un color aleatorio constantemente
    const colorChangeInterval = setInterval(() => {
        document.body.style.backgroundColor = `hsl(${Math.random() * 360}, 100%, 75%)`;
    }, 1000); // Cambiar el color cada segundo

    // Crear y soltar globos con un intervalo discontinúo
    balloonInterval = setInterval(() => {
        if (balloonCount < 15) { // Solo crear globos si no se han creado 15
            createBalloon();
            balloonCount++; // Incrementar el contador de globos
        } else {
            clearInterval(balloonInterval); // Detener la creación de globos
        }
    }, 500); // Crear un globo cada 500ms

    // Desactivar el botón de Modo Fiesta
    document.getElementById("partyModeBtn").disabled = true;

    // Detener el modo fiesta después de 10 segundos
    partyTimer = setTimeout(() => {
        clearInterval(colorChangeInterval); // Detener el cambio de color
        clearInterval(balloonInterval); // Detener la creación de globos

        // Iniciar la barra de progreso
        startProgressBar();

    }, 10000); // 10 segundos

    // Después de 10 segundos, restaurar el fondo
    setTimeout(() => {
        document.body.style.backgroundColor = ""; // Restaurar el color original del fondo
    }, 10000); // 10 segundos
}
```
