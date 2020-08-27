package 추상클래스와인터페이스;

public abstract class Shape {
    public String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public abstract double computerArea();
    public abstract double computerPerimeter();
}
