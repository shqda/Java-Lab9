package randomList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.random.RandomGenerator;

public class MyRandomList  {

    protected LinkedList<Integer> data = new LinkedList<>();

    public void addNumber() {
        var generator = RandomGenerator.getDefault();
        getData().add(generator.nextInt());
    }

    public void removeNumber() {
        if (getData().isEmpty()) return;
        var generator = RandomGenerator.getDefault();
        getData().remove(generator.nextInt(getData().size()));
    }

    public int calcZero() {
        return Collections.frequency(getData(), 0);
    }

    public LinkedList<Integer> getData() {
        return data;
    }

    public void setData(LinkedList<Integer> data) {
        this.data = data;
    }
}
