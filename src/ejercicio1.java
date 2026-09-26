
    import java.util.Scanner;

public class ejercicio1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] consumo = new int[10];
        int totalConsumo = 0;
        
        // 1. Lectura y validación de datos
        System.out.println("=== INGRESO DE CONSUMO DE AGUA POR SECTOR ===");
        for (int i = 0; i < consumo.length; i++) {
            int valor;
            do {
                System.out.print("Ingrese el consumo para el Sector " + (i + 1) + " (m3): ");
                valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("Error: El consumo no puede ser negativo. Intente de nuevo.");
                }
            } while (valor < 0);
            
            consumo[i] = valor;
            totalConsumo += valor;
        }

        // 2. Cálculo de Promedio y Sector con Mayor Consumo
        double promedio = (double) totalConsumo / consumo.length;
        
        int mayorConsumo = consumo[0];
        int sectorMayor = 1; // 1-indexed
        
        for (int i = 1; i < consumo.length; i++) {
            if (consumo[i] > mayorConsumo) {
                mayorConsumo = consumo[i];
                sectorMayor = i + 1;
            }
        }

        // 3. Conteo de sectores sobre el promedio y racha más larga
        int sectoresSobrePromedio = 0;
        int rachaActual = 0;
        int rachaMax = 0;

        for (int i = 0; i < consumo.length; i++) {
            if (consumo[i] > promedio) {
                sectoresSobrePromedio++;
                rachaActual++;
                if (rachaActual > rachaMax) {
                    rachaMax = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }

        // 4. Salida de resultados
        System.out.println("\n=============================================");
        System.out.println("            RESULTADOS DEL ANÁLISIS          ");
        System.out.println("=============================================");
        System.out.println("Consumo total: " + totalConsumo + " m3");
        System.out.printf("Promedio de consumo: %.2f m3\n", promedio);
        System.out.println("Sector con mayor consumo: Sector " + sectorMayor + " (" + mayorConsumo + " m3)");
        System.out.println("Sectores con consumo superior al promedio: " + sectoresSobrePromedio);
        System.out.println("Racha más larga superior al promedio: " + rachaMax + " sectores consecutivos");

        // 5. Listado final
        System.out.println("\n--- Listado Final de Consumo ---");
        for (int i = 0; i < consumo.length; i++) {
            System.out.println("Sector " + (i + 1) + ": " + consumo[i] + " m3");
        }
        
        scanner.close();
    }
}


