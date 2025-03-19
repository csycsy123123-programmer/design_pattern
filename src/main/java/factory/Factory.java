package factory;

public class Factory {
    public Factory() {

    }

    public Shape buildShape(String string) {
        if (string.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (string.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("不合法输入");
        }
    }
}
