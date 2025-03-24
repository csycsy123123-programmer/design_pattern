import design_pattern.builder.Computer;
import design_pattern.factory.Factory;
import design_pattern.factory.Shape;
import priority_thread.PriorityThreadPool;
import volatile_exmaple.VolatileExample;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
//        WeatherStation weatherStation = new WeatherStation();
//        TV tv = new TV();
//        Phone phone = new Phone();
//        weatherStation.registerObserver(tv);
//        weatherStation.registerObserver(phone);
//        weatherStation.setTemperature(0.85f);
//        weatherStation.removeObserver(tv);
//        weatherStation.setTemperature(0.95f);
//        weatherStation.removeAll();
//        weatherStation.setTemperature(20f);
//
//        Factory factory = new Factory();
//        Shape shape = factory.buildShape("Circle");
//        shape.draw();
//        Computer computer = new Computer.Builder().withCpu("i7").build();
//        PriorityThreadPool priorityThreadPool = new PriorityThreadPool();
//        priorityThreadPool.execute(1, () -> {
//            System.out.println("低优先级任务开始");
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("低优先级任务结束");
//        });
//        priorityThreadPool.execute(3, () -> {
//            System.out.println("高1优先级任务开始");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("高2优先级任务结束");
//        });
//        priorityThreadPool.execute(1, () -> {
//            System.out.println("低优先级任务开始");
//            try {
//                Thread.sleep(20000);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("低优先级任务结束");
//        });
//        priorityThreadPool.execute(2, () -> System.out.println("中优先级任务"));
//        priorityThreadPool.execute(4, () -> {
//            System.out.println("高2优先级任务开始");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("高2优先级任务结束");
//        });
//        priorityThreadPool.shutdown();


        try {
            VolatileExample.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}