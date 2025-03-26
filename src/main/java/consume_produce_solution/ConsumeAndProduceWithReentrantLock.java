package consume_produce_solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumeAndProduceWithReentrantLock {
    private ReentrantLock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();
    private Queue<Integer> cache = new LinkedList<>();
    private final int CACHE_LIMIT;

    public ConsumeAndProduceWithReentrantLock(int size) {
        CACHE_LIMIT = size;
    }

    private void produce() {
        Random random = new Random();
        int data = 0;
        while (true) {
            try {
                Thread.sleep(random.nextInt(100));
                data++;
                lock.lock();
                while (cache.size() == CACHE_LIMIT) {
                    isFull.await();
                }
                cache.add(data);
                isEmpty.signal();
            } catch (Exception e) {
                throw new RuntimeException();
            } finally {
                lock.unlock();
            }
        }
    }

    private void consume() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(50));
                lock.lock();
                while (cache.isEmpty()) {
                    isEmpty.await();
                }
                int a = cache.poll();
                System.out.println(a);
                isFull.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void start() {
        new Thread(this::produce).start();
        new Thread(this::consume).start();
    }
}
