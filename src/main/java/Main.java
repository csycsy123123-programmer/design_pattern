import builder.Computer;
import factory.Factory;
import factory.Shape;
import observer.Phone;
import observer.TV;
import observer.WeatherStation;

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

        Factory factory = new Factory();
        Shape shape = factory.buildShape("Circle");
        shape.draw();
        Computer computer = new Computer.Builder().withCpu("i7").build();
    }
}