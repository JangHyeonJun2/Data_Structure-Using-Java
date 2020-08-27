package 예제;

public abstract class Event implements Comparable{
    public String title;

    public Event(String title) {
        this.title = title;
    }

    public void print(){
        System.out.println("title = " + title);
    }

    public abstract MyDate getRepresentativeDate();

    @Override
    public int compareTo(Object o) {
        MyDate mine = getRepresentativeDate();
        MyDate yours = ((Event)o).getRepresentativeDate();
        int result = MyDate.comp(mine,yours);
        return result;
    }
}
