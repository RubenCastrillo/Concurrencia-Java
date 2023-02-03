

import java.util.Random;

public class App extends Thread {
    private int id;
    private static int tom = 40;
    private static int[] vec = new int[tom];

    private int ini, fin;

    public App(int ini, int fin, int id) {
        this.ini = ini;
        this.fin = fin;
        this.id = id;
    }

    public void run() {
        for (int i = ini; i < fin; i++) {
            vec[i] *= 10;
        }
    }

    public static void main(String[] args) throws Exception {

        Random rand = new Random(System.nanoTime());

        for (int i = 0; i < vec.length; i++) {
            vec[i] = rand.nextInt(10);
        }

        App h1 = new App(0, 11, 1);
        App h2 = new App(11, 21, 2);
        App h3 = new App(21, 31, 3);
        App h4 = new App(31, 40, 4);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (Exception ex) {
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i] + " ");
        }

    }
}
