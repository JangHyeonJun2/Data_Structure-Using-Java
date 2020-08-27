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
    public static int comp(MyDate d1, MyDate d2){
        if(d1.year < d2.year || d1.year == d2.year && d1.month < d2.month
                || d1.year == d2.year && d1.month == d2.month && d1.day < d2.day)
            return -1;
        else if(d1.year > d2.year || d1.year == d2.year && d1.month > d2.month
                || d1.year == d2.year && d1.month == d2.month && d1.day > d2.day)
            return 1;
        else
            return 0;
    }
}
