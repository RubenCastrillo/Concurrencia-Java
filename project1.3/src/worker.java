public class worker implements Runnable {
    private double pi = 0.0;
    private boolean negative = false;
    private int i = 1;

    public void run() {

        while (i < 100000) {

            System.out.println("Iteracion num: " + i + " del " + Thread.currentThread().getName() + " // pi: " + pi
                    * 4);

            if (negative) {
                pi -= 1.0 / i;
            } else {
                pi += 1.0 / i;
            }
            negative = !negative;
            i += 2;

            try {
                Thread.sleep((int) Math.rint(Math.random() * 5));
            } catch (InterruptedException ex) {
                System.out.println("\n\n\n\nSe ha parado el th " + Thread.currentThread().getName());
                System.out.println("pi vale en este momento:" + pi * 4 + "\n\n\n");
                break;
            }

        }

    }
}
