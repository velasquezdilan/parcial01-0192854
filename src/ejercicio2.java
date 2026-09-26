
    import java.util.Scanner;

    public class ejercicio2{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            int FILAS = 4;   // Máquinas (1 a 4)
            int COLUMNAS = 5; // Días (1 a 5)
            int[][] produccion = new int[FILAS][COLUMNAS];
    
            // 1. Lectura y validación de datos
            System.out.println("=== INGRESO DE PRODUCCIÓN SEMANAL ===");
            for (int i = 0; i < FILAS; i++) {
                System.out.println("\n--- Máquina " + (i + 1) + " ---");
                for (int j = 0; j < COLUMNAS; j++) {
                    int piezas;
                    do {
                        System.out.print("Producción Día " + (j + 1) + ": ");
                        piezas = scanner.nextInt();
                        if (piezas < 0) {
                            System.out.println("Error: La producción no puede ser negativa. Intente de nuevo.");
                        }
                    } while (piezas < 0);
                    
                    produccion[i][j] = piezas;
                }
            }
    
            // 2. Totales por Máquina, registros < 20 y Máquina Mayor
            int[] totalPorMaquina = new int[FILAS];
            int registrosMenoresA20 = 0;
            
            for (int i = 0; i < FILAS; i++) {
                int sumaMaquina = 0;
                for (int j = 0; j < COLUMNAS; j++) {
                    sumaMaquina += produccion[i][j];
                    if (produccion[i][j] < 20) {
                        registrosMenoresA20++;
                    }
                }
                totalPorMaquina[i] = sumaMaquina;
            }
    
            int maquinaMayor = 1; // 1-indexed
            int maxProduccion = totalPorMaquina[0];
            for (int i = 1; i < FILAS; i++) {
                if (totalPorMaquina[i] > maxProduccion) {
                    maxProduccion = totalPorMaquina[i];
                    maquinaMayor = i + 1;
                }
            }
    
            // 3. Totales por Día y Día Menor
            int[] totalPorDia = new int[COLUMNAS];
            for (int j = 0; j < COLUMNAS; j++) {
                int sumaDia = 0;
                for (int i = 0; i < FILAS; i++) {
                    sumaDia += produccion[i][j];
                }
                totalPorDia[j] = sumaDia;
            }
    
            int diaMenor = 1; // 1-indexed
            int minProduccion = totalPorDia[0];
            for (int j = 1; j < COLUMNAS; j++) {
                if (totalPorDia[j] < minProduccion) {
                    minProduccion = totalPorDia[j];
                    diaMenor = j + 1;
                }
            }
    
            // 4. Salida de resultados organizados
            System.out.println("\n=============================================");
            System.out.println("            RESUMEN DE PRODUCCIÓN            ");
            System.out.println("=============================================");
    
            System.out.println("\n--- Total Producido por Máquina ---");
            for (int i = 0; i < FILAS; i++) {
                System.out.println("Máquina " + (i + 1) + ": " + totalPorMaquina[i] + " piezas");
            }
    
            System.out.println("\n--- Total Producido por Día ---");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.println("Día " + (j + 1) + ": " + totalPorDia[j] + " piezas");
            }
    
            System.out.println("\n--- Indicadores Clave ---");
            System.out.println("Máquina con mayor producción acumulada: Máquina " + maquinaMayor + " (" + maxProduccion + " piezas)");
            System.out.println("Día con menor producción total: Día " + diaMenor + " (" + minProduccion + " piezas)");
            System.out.println("Cantidad de registros inferiores a 20 piezas: " + registrosMenoresA20);
    
            // 5. Visualización de la Matriz completa
            System.out.println("\n--- Matriz Completa de Producción ---");
            System.out.printf("%-12s", "Máquina");
            for (int j = 1; j <= COLUMNAS; j++) {
                System.out.printf("%-10s", "Día " + j);
            }
            System.out.println();
    
            for (int i = 0; i < FILAS; i++) {
                System.out.printf("%-12s", "Máquina " + (i + 1));
                for (int j = 0; j < COLUMNAS; j++) {
                    System.out.printf("%-10d", produccion[i][j]);
                }
                System.out.println();
            }
    
            scanner.close();
        }
    } 

