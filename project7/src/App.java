import java.util.Random;

// medir tiempo
// diferencia entre concurrencia y paralelismo
// falta solucionar el caso en el que haya bugs por el tam%2!=0
public class App extends Thread {

    private static int tam = 800;
    private static int[][] matrix = new int[tam][tam];

    private int ini, fin;

    public App(int ini, int fin) {
        this.ini = ini;
        this.fin = fin;
    }

    public void run() {
        for (int i = ini; i < fin; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= 10;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Runtime runtime = Runtime.getRuntime();

        int nNucleos = runtime.availableProcessors();
        System.out.println(nNucleos);

        double tiempo_inicial, tiempo_final;
        Random rand = new Random(System.nanoTime());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        Thread[] hilos = new Thread[nNucleos];
        int rango = tam / nNucleos;
        int start = 0;
        int finish = rango;

        for (int i = 0; i < nNucleos; i++) {
            hilos[i] = new App(start, finish);
            hilos[i].start();
            start = finish;
            finish += rango;
        }

        for (int i = 0; i < nNucleos; i++) {
            try {
                hilos[i].join();
            } catch (Exception ex) {
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        // double tiempo_inicial2, tiempo_final2;
        // tiempo_inicial2 = System.nanoTime();
        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // matrix[i][j] *= 10;
        // }
        // }
        // tiempo_final2 = System.nanoTime();
        // double tiempo_total2 = tiempo_final2 - tiempo_inicial2;
        // System.out.println("Tiempo final sin concurrencia: " + tiempo_total2 /
        // 1000000 + "/ms");
    }

}
