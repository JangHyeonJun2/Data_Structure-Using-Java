package 예제;

public class OnedayEvent extends Event {
    public MyDate myDate;

    public OnedayEvent(String title, MyDate myDate) {
        super(title);
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "OnedayEvent{" +
                "title='" + title + '\'' + myDate +
                '}';
    }
}
