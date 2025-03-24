package volatile_exmaple;

public class VolatileExample {
    public VolatileExample() {

    }

    public static void run() throws InterruptedException {
        Machine machine = new Machine();
        machine.run();
        Thread.sleep(1000);
        machine.setShutDown();
    }

    private static class Machine {
        private volatile boolean isShutDown = false;
        //这个volatile是完全必要的

        Machine() {

        }

        private void run() {
            new Thread(() -> {
                while (!isShutDown) {

                }
                System.out.println("机器1被shutdown了");
            }).start();
            new Thread(() -> {
                while (!isShutDown) {

                }
                System.out.println("机器2被shutdown了");
            }).start();
        }

        private void setShutDown() {
            isShutDown = true;
            System.out.println("下发shutdown指令");
        }
    }
}
