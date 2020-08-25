package 예제;

public class DurationEvent {
    public String title;
    public MyDate begin;
    public MyDate end;

    public DurationEvent(String title, MyDate begin, MyDate end) {
        this.title = title;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return title+", "+begin.toString()+" ~ "+end.toString();
    }
}
