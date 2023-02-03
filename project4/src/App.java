// problema del indeterminismo, EXCLUSION MUTUA(Solo se puede acceder con un hilo a la vez)
// seccion critica, lugar donde se puede producir indeterministo
public class App extends Thread {
    private static int count;

    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) throws Exception {

        App[] listHilos = new App[1000];

        for (int i = 0; i < listHilos.length; i++) {
            listHilos[i] = new App();
            listHilos[i].start();
        }

        try {
            for (int i = 0; i < listHilos.length; i++) {
                listHilos[i].join();
            }
        } catch (Exception es) {

        }
        System.out.println(count);
    }
}
