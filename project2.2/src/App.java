import java.util.Random;

// medir tiempo
// diferencia entre concurrencia y paralelismo
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
        double tiempo_inicial, tiempo_final;
        Random rand = new Random(System.nanoTime());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }

        App h1 = new App(0, 200);
        App h2 = new App(201, 400);

        tiempo_inicial = System.nanoTime();
        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (Exception ex) {

        }
        double tiempo_total = System.nanoTime() - tiempo_inicial;

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // System.out.println(matrix[i][j]);
        // }
        // }
        System.out.println("tiempo requerido: " + tiempo_total / 1000000 + "/ms");

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
