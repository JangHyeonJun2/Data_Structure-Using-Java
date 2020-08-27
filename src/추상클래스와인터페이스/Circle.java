package 추상클래스와인터페이스;

public class Circle  extends Shape{
    public int radius;

    public Circle(int radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double computerArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double computerPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public String toString(){
        return "Circle: radius is " + radius;
    }
}
