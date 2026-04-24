package randomList;

public class MyReadThread implements Runnable {
    MyRandomList list;

    public MyReadThread(MyRandomList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(list.calcZero());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
