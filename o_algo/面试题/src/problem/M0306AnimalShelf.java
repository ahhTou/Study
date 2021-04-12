package problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 03.06. 动物收容所
 */
public class M0306AnimalShelf {
    Queue<int[]> animals;
    Queue<int[]> jump_animals;

    public M0306AnimalShelf() {
        animals = new LinkedList<>();
        jump_animals = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        animals.add(animal);
    }

    public int[] dequeueAny() {
        if (animals.isEmpty() && jump_animals.isEmpty()) return new int[]{-1, -1};
        if (!jump_animals.isEmpty()) return jump_animals.remove();
        return animals.remove();
    }

    public int[] dequeueDog() {
        return dequeueType(1);
    }

    public int[] dequeueCat() {
        return dequeueType(0);
    }

    public int[] dequeueType(int type) {
        if (animals.isEmpty() && jump_animals.isEmpty())
            return new int[]{-1, -1};

        if (!jump_animals.isEmpty() && jump_animals.peek()[1] == type)
            return jump_animals.poll();

        while (!animals.isEmpty() && animals.peek()[1] != type)
            jump_animals.add(animals.poll());

        return animals.isEmpty() ? new int[]{-1, -1} : animals.poll();
    }
}
