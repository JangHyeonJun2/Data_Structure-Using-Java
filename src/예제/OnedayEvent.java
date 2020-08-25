package 예제;

public class OnedayEvent {
    public String title;
    public MyDate myDate;

    public OnedayEvent(String title, MyDate myDate) {
        this.title = title;
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "OnedayEvent{" +
                "title='" + title + '\'' + myDate +
                '}';
    }
}
