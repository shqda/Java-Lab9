package randomList;

import java.util.random.RandomGenerator;

public class MyWriteThread implements Runnable {
    MyRandomList list;
    RandomGenerator generator = RandomGenerator.getDefault();

    public MyWriteThread(MyRandomList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            if (generator.nextBoolean()) {
                list.removeNumber();
            } else {
                list.addNumber();
            }
        }
    }
}
