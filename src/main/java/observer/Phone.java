package observer;

public class Phone implements Observer{
    @Override
    public void update(float temperature) {
        System.out.println("手机收到"+temperature);
    }
}
