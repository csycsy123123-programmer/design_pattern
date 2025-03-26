package consume_produce_solution;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumeAndProduceWithBlockingQueue {
    private final BlockingQueue<Integer> cache;

    public ConsumeAndProduceWithBlockingQueue(int size) {
        cache = new ArrayBlockingQueue<>(size);
    }

    public void produce() {
        Random random = new Random();
        int data = 0;
        while (true) {
            try {
                Thread.sleep(random.nextInt(100));
                data++;
                cache.put(data);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }

    public void consume() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(100));
                int a = cache.take();
                System.out.println(a);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
