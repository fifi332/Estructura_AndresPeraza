import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

public class InformeSistema {

    public static void main(String[] args) {

        // Conversor a MiB
        final long MIB = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();

        System.out.println("PROCESADORES");
        System.out.println("=============================");
        System.out.println("Disponibles JVM: " + runtime.availableProcessors());
        System.out.println("(son hilos lógicos: con SMT no coinciden con los núcleos físicos)");
        System.out.println();

        System.out.println("MEMORIA ANTES");
        System.out.println("=============================");
        long totalAntes = runtime.totalMemory() / MIB;
        long libreAntes = runtime.freeMemory() / MIB;
        long enUsoAntes = totalAntes - libreAntes;
        long maxAntes = runtime.maxMemory() / MIB;
        long porcAntes = (enUsoAntes * 100) / totalAntes;

        System.out.println("Total reservada: " + totalAntes + " MiB");
        System.out.println("Libre: " + libreAntes + " MiB");
        System.out.println("En uso: " + enUsoAntes + " MiB (" + porcAntes + "% de la total)");
        System.out.println("Máxima (-Xmx): " + maxAntes + " MiB");
        System.out.println();

        long[] reservado = new long[8 * 1024 * 1024];

        System.out.println("MEMORIA DESPUÉS DE RESERVAR 64 MIB");
        System.out.println("=============================");
        long totalDespues = runtime.totalMemory() / MIB;
        long libreDespues = runtime.freeMemory() / MIB;
        long enUsoDespues = totalDespues - libreDespues;
        long maxDespues = runtime.maxMemory() / MIB;
        long porcDespues = (enUsoDespues * 100) / totalDespues;

        System.out.println("Total reservada: " + totalDespues + " MiB");
        System.out.println("Libre: " + libreDespues + " MiB");
        System.out.println("En uso: " + enUsoDespues + " MiB (" + porcDespues + "% de la total)");
        System.out.println("Máxima (-Xmx): " + maxDespues + " MiB");

        long incremento = enUsoDespues - enUsoAntes;
        System.out.println("Incremento en uso: " + incremento + " MiB");

        System.out.println("(el array sigue en memoria: reservado[0] = " + reservado[0] + ")");
        System.out.println();

        System.out.println("SISTEMA");
        System.out.println("=============================");
        String osName = System.getProperty("os.name");
        String sep = System.getProperty("file.separator");
        String userHome = System.getProperty("user.home");

        String ruta = userHome + sep + "psp" + sep + "informe.txt";

        System.out.println("os.name: " + osName);
        System.out.println("file.separator: \"" + sep + "\"");
        System.out.println("Ruta construida con las propiedades:");
        System.out.println(ruta);
        System.out.println();

        String[] prefijos;
        if (args.length > 0) {
            prefijos = args;
        } else {
            prefijos = new String[]{"os.", "user.", "java.version"};
        }

        System.out.println("PROPIEDADES QUE EMPIEZAN POR " + String.join(", ", prefijos));
        System.out.println("=============================");

        Map<String, String> listaOrdenada = new TreeMap<>();
        Properties props = System.getProperties();

        for (String nombreProp : props.stringPropertyNames()) {
            for (String pfc : prefijos) {
                if (nombreProp.startsWith(pfc)) {
                    listaOrdenada.put(nombreProp, props.getProperty(nombreProp));
                    break;
                }
            }
        }

        for (Map.Entry<String, String> entry : listaOrdenada.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        System.out.println("PROCESO EN ESPERA");
        System.out.println("=============================");
        System.out.println("Buscame desde otra terminal con:");
        System.out.println("ps -ef | grep InformeSistema");
        System.out.print("Pulsa INTRO para terminar...");

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.println("Fin del programa.");
    }
}