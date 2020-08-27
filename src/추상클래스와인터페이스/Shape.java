package 추상클래스와인터페이스;

public abstract class Shape implements MyComparable{
    public String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public abstract double computerArea();
    public abstract double computerPerimeter();

    @Override
    public int compareTo(Object o) {
        double MyArea = computerArea();
        double yourArea = ((Shape)o).computerArea();

        if(MyArea < yourArea)
            return -1;
        else if(MyArea == yourArea)
            return 0;
        else
            return 1;
    }
}
