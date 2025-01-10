package com.androidavid;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CurrencyConverter {
    private static final String API_KEY = "2f4cead5b4311ebb7f5c0e4a";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final Scanner scanner;
    private final HttpClient httpClient;
    private final Gson gson;

    // Mapa de monedas soportadas con sus nombres
    private static final Map<String, String> MONEDAS_SOPORTADAS = new LinkedHashMap<>() {{
        put("ARS", "Peso argentino");
        put("BOB", "Boliviano boliviano");
        put("BRL", "Real brasileño");
        put("CLP", "Peso chileno");
        put("COP", "Peso colombiano");
        put("USD", "Dólar estadounidense");
    }};

    public CurrencyConverter() {
        this.scanner = new Scanner(System.in);
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcionUsuario();

            if (opcion == 3) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            procesarOpcion(opcion);
        }
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n=== Conversor de Monedas  ===");
        System.out.println("1. Ver monedas disponibles");
        System.out.println("2. Realizar conversión");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void mostrarMonedasDisponibles() {
        System.out.println("\nMonedas disponibles:");
        System.out.println("--------------------");
        MONEDAS_SOPORTADAS.forEach((codigo, nombre) ->
                System.out.printf("%s - %s%n", codigo, nombre));
    }

    private int obtenerOpcionUsuario() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarMonedasDisponibles();
                break;
            case 2:
                realizarConversion();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void realizarConversion() {
        mostrarMonedasDisponibles();

        scanner.nextLine(); // Limpiar el buffer

        String monedaOrigen = obtenerMonedaValida("Ingrese el código de la moneda de origen: ");
        String monedaDestino = obtenerMonedaValida("Ingrese el código de la moneda de destino: ");

        System.out.print("Ingrese la cantidad a convertir: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        double cantidad = scanner.nextDouble();

        try {
            double tasaCambio = obtenerTasaCambio(monedaOrigen, monedaDestino);
            double resultado = cantidad * tasaCambio;

            System.out.println("\nResultado de la conversión:");
            System.out.println("-------------------------");
            System.out.printf("%.2f %s (%s)%n", cantidad, monedaOrigen, MONEDAS_SOPORTADAS.get(monedaOrigen));
            System.out.println("es igual a");
            System.out.printf("%.2f %s (%s)%n", resultado, monedaDestino, MONEDAS_SOPORTADAS.get(monedaDestino));
            System.out.printf("Tasa de cambio: 1 %s = %.4f %s%n", monedaOrigen, tasaCambio, monedaDestino);

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }

    private String obtenerMonedaValida(String mensaje) {
        String moneda;
        while (true) {
            System.out.print(mensaje);
            moneda = scanner.nextLine().toUpperCase();

            if (MONEDAS_SOPORTADAS.containsKey(moneda)) {
                break;
            }
            System.out.println("Moneda no válida. Por favor, elija una de las monedas disponibles.");
        }
        return moneda;
    }

    private double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Error al obtener tasa de cambio. Código: " +
                    response.statusCode());
        }

        ExchangeRateResponse exchangeRate = gson.fromJson(
                response.body(),
                ExchangeRateResponse.class
        );

        return exchangeRate.getConversion_rate();
    }

    private static class ExchangeRateResponse {
        private double conversion_rate;

        public double getConversion_rate() {
            return conversion_rate;
        }
    }
}
