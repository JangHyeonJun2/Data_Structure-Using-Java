package 예제;

public class DeadlinedEvent extends Event{
    public MyDate deadline;

    public DeadlinedEvent(String title, MyDate deadline) {
        super(title);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "DeadlineEvent{"+title +", "+ deadline.toString()+"}";
    }

    @Override
    public void print() {
        System.out.println("---deadline---");
        super.print();
        System.out.println("Date = "+ deadline.year +"/"+ deadline.month+"/"+ deadline.day);
    }
}
