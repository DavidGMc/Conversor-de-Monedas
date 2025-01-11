# Conversor de Monedas - Latam Currency Converter 🌎💱

![Banner del Proyecto](https://firebasestorage.googleapis.com/YOUR_STORAGE_URL/banner.png)

## 📝 Descripción

Este proyecto es un conversor de monedas que se enfoca en las principales divisas de Latinoamérica. Permite realizar conversiones en tiempo real utilizando la API de Exchange Rate.

### Monedas soportadas:
- 🇦🇷 ARS - Peso argentino
- 🇧🇴 BOB - Boliviano boliviano
- 🇧🇷 BRL - Real brasileño
- 🇨🇱 CLP - Peso chileno
- 🇨🇴 COP - Peso colombiano
- 🇺🇸 USD - Dólar estadounidense

## 🛠️ Tecnologías Utilizadas

- Java 18
- Maven
- Gson para manejo de JSON
- HttpClient para consumo de API
- Exchange Rate API

## 📋 Requisitos Previos

- JDK 18 o superior
- Maven
- Una API key de [Exchange Rate API](https://www.exchangerate-api.com/)
- IntelliJ IDEA (recomendado) u otro IDE

## 🚀 Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/conversor-monedas.git
```

2. Navega al directorio del proyecto:
```bash
cd conversor-monedas
```

3. Instala las dependencias:
```bash
mvn install
```

4. Configura tu API key:
   - Abre `CurrencyConverter.java`
   - Reemplaza `TU_API_KEY_AQUÍ` con tu API key

## 💻 Uso

![Ejemplo de Uso](https://firebasestorage.googleapis.com/YOUR_STORAGE_URL/usage.gif)

1. Ejecuta la aplicación:
```bash
mvn exec:java -Dexec.mainClass="com.converter.Main"
```

2. Sigue las opciones del menú:
   - Ver monedas disponibles
   - Realizar conversión
   - Salir

## 📁 Estructura del Proyecto

```
conversor-monedas/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── converter/
│                   ├── Main.java
│                   └── CurrencyConverter.java
│
├── pom.xml
└── README.md
```

## 📸 Capturas de Pantalla

### Menú Principal
![Menú Principal](https://firebasestorage.googleapis.com/v0/b/chateapp-latino.appspot.com/o/Alura%2Fconversor_monedas.jpg?alt=media&token=bb33c9ad-830f-4677-9631-8e15420fa897)

### Proceso de Conversión
![Proceso de Conversión](https://firebasestorage.googleapis.com/v0/b/chateapp-latino.appspot.com/o/Alura%2Fconversor_monedas.jpg?alt=media&token=bb33c9ad-830f-4677-9631-8e15420fa897)

### Resultado
![Resultado](https://firebasestorage.googleapis.com/v0/b/chateapp-latino.appspot.com/o/Alura%2Fconversor_monedas.jpg?alt=media&token=bb33c9ad-830f-4677-9631-8e15420fa897)

## 🔗 Enlaces Útiles

- [Documentación de Exchange Rate API](https://www.exchangerate-api.com/docs)
- [Tutorial de HttpClient en Java](https://docs.oracle.com/en/java/javase/18/docs/api/java.net.http/java/net/http/HttpClient.html)
- [Gson User Guide](https://github.com/google/gson/blob/master/UserGuide.md)

## 📝 Notas sobre las Imágenes

Las imágenes del proyecto están alojadas en Firebase Storage. Para configurar tus propias imágenes:

1. Crea un proyecto en [Firebase](https://firebase.google.com/)
2. Configura Firebase Storage
3. Sube tus imágenes
4. Reemplaza las URLs en este README con tus propias URLs de Firebase

Estructura recomendada para las imágenes:
- banner.png (1200x300)
- usage.gif (800x600)
- menu.png (800x400)
- conversion.png (800x400)
- result.png (800x400)

## 👨‍💻 Autor

[C David G ---Androidavid.com](https://github.com/DavidGMc)

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE.md](LICENSE) para detalles

## 🙋‍♂️ Contribuir

1. Fork el proyecto
2. Crea tu rama de características (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## ✨ Agradecimientos

- Exchange Rate API por proporcionar las tasas de cambio
- Oracle por la documentación de Java HttpClient
- Google por Gson
