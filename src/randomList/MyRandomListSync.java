package randomList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.random.RandomGenerator;

public class MyRandomListSync extends MyRandomList {

    synchronized public void addNumber() {
        var generator = RandomGenerator.getDefault();
        getData().add(generator.nextInt(3));
    }

    synchronized public void removeNumber() {
        if (getData().isEmpty()) return;
        var generator = RandomGenerator.getDefault();
        getData().remove(generator.nextInt(getData().size()));
    }

    synchronized public int calcZero() {
        return Collections.frequency(getData(), 0);
    }
}
