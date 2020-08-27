package 예제;

public class DurationEvent extends Event {
    public MyDate begin;
    public MyDate end;

    public DurationEvent(String title, MyDate begin, MyDate end) {
        super(title);
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "DurationEvent{" +title+", "+begin.toString()+" ~ "+end.toString()+"}";
    }

    @Override
    public void print() {
        System.out.println("---duration---");
        super.print();
        System.out.println("Date = "+ begin.year +"/"+ begin.month+"/"+ begin.day+" ~ "+
                                       end.year +"/"+ end.month+"/"+ end.day);
    }

    @Override
    public MyDate getRepresentativeDate() {
        return begin;
    }
}
