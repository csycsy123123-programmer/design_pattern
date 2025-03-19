package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private final List<Observer> observers;
    private float temperature = 0f;

    public WeatherStation() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void removeAll() {
        observers.clear();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        System.out.println("气象台监测" + temperature);
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public float getTemperature() {
        return temperature;
    }
}
