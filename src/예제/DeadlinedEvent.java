package 예제;

public class DeadlinedEvent {
    public String title;
    public MyDate deadline;

    public DeadlinedEvent(String title, MyDate deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return title +", "+ deadline.toString();
    }
}
