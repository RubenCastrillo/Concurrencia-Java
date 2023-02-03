
// programa que entre en un bucle de 1000 iteracions con exclusion mutua
public class App implements Runnable {

    @Override
    public void run() {

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
        System.out.println("Soy el hilo principal");
    }
}