package 예제;

public class OnedayEvent extends Event {
    public MyDate myDate;

    public OnedayEvent(String title, MyDate myDate) {
        super(title);
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "OnedayEvent{" + "title='" + title + '\'' + myDate + "}";
    }

    @Override
    public void print() {
        System.out.println("---oneDay---");
        super.print();
        System.out.println("Date = "+ myDate.year +"/"+ myDate.month+"/"+ myDate.day);
    }
}
