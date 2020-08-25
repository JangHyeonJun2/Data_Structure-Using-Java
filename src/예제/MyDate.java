package 예제;

public class MyDate {
    public int year;
    public int month;
    public int day;

    public MyDate(int y, int m, int d){
        this.year = y;
        this.month = m;
        this.day = d;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
