import randomList.MyRandomList;
import randomList.MyRandomListSync;
import randomList.MyReadThread;
import randomList.MyWriteThread;

import java.util.ArrayList;
import java.util.LinkedList;

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

        th1.join(100);
        th2.join(100);

        if (th1.isAlive() && th2.isAlive()) {
            System.out.println("deadlock!");
        } else {
            System.out.println("no deadlock");
        }

        LinkedList<Integer> list = new LinkedList<>();

        var myList = new MyRandomList();
//        var myList = new MyRandomListSync();
        myList.setData(list);

        var readThread = new Thread(new MyReadThread(myList));
        readThread.start();

        var writeThreadsList = new ArrayList<Thread>();
        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(new MyWriteThread(myList));
            writeThreadsList.add(thread);
            thread.start();
        }
    }
}