
// programa que entre en un bucle de 1000 iteracions con exclusion mutua
public class App implements Runnable {
    private static int count;
    private static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        int nNucleos = runtime.availableProcessors();

        Thread[] hilos = new Thread[nNucleos];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new App());
            hilos[i].start();
        }

        try {
            for (int i = 0; i < hilos.length; i++) {
                hilos[i].join();
            }
        } catch (Exception ex) {

        }
        System.out.println(count);
    }

}