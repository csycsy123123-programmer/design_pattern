package design_pattern.observer;

public class TV implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("TV收到" + temperature);
    }
}
