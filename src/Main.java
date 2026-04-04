


public class Main {
    static void main() throws InterruptedException {
        Object A = new Object();
        Object B = new Object();

        Thread th1 = new Thread(() -> {
            synchronized (A) {
            System.out.println("th1 blocked A; ");
                synchronized (B) {
                    System.out.println("th1 blocked B; ");
                }
            }
        });

        Thread th2 = new Thread(() -> {
            synchronized (B) {
            System.out.println("th2 blocked B; ");
                synchronized (A) {
                    System.out.println("th2 blocked A; ");
                }
            }
        });
        th1.start();
        th2.start();

        th1.join(1000);
        th2.join(1000);

        if (th1.isAlive() && th2.isAlive()) {
            System.out.println("deadlock!");
        } else {
            System.out.println("no deadlock");
        }
    }
}