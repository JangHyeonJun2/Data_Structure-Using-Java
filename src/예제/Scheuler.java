package 예제;

import java.util.Scanner;

public class Scheuler {
    private int capacity = 10;
    public Event[] events = new Event[capacity];
    public int eventsCount = 0;
    Scanner sc;


    public void processCommand(){
        sc = new Scanner(System.in);

        while (true){
            System.out.print("$ ");
            String command = sc.next();
            if(command.equals("addevent")){
                String type = sc.next();
                if(type.equalsIgnoreCase("oneday")){
                    handleAddOneDayEvent();
                }else if (type.equalsIgnoreCase("duration")){
                    handleAddDurationEvent();
                }else if (type.equalsIgnoreCase("deadline")){
                    handelAddDeadlineEvent();
                }else if(type.equalsIgnoreCase("exit")){

                }
            }else if(command.equals("list")){
                handlList();
            }else if(command.equals("show")){

            }else if(command.equals("exit")){
                break;
            }
        }
        sc.close();
    }

    private void handlList() {
        for (int i=0; i<eventsCount; i++){
            System.out.println("    " + events[i].toString());
        }
    }

    private void handelAddDeadlineEvent() {

    }

    private void handleAddDurationEvent(){

    }

    private void handleAddOneDayEvent(){
        System.out.print("  when:  ");
        String dateString = sc.next(); //2014/12/3
        sc.nextLine();//enter 값을 없애주기 위함
        System.out.print("  title: ");
        String datetitle = sc.nextLine(); // mybirthday

        MyDate strDate = parsDateString(dateString);
        OnedayEvent onedayEvent = new OnedayEvent(datetitle, strDate);
//        System.out.println(onedayEvent.toString());

        addEventCount(onedayEvent);
    }

    private void addEventCount(OnedayEvent onedayEvent) {
        if(eventsCount >= capacity){
            rellocation();
        }
        events[eventsCount++] = onedayEvent;
    }
    //배열 크기 재할당!
    private void rellocation() {
        System.out.println("events.length: " + events.length);
        Event[] tmp = new Event[capacity*2];
        for(int i=0; i<eventsCount; i++){
            tmp[i] = events[i];
        }
        events = tmp;
        capacity *= 2;
        System.out.println("events.length: " + events.length);
    }

    // 2014/10/2 날짜를 분리해주는 메서드
    private MyDate parsDateString(String dateString) {
        String[] dates = dateString.split("/"); // 구분자(/)로 새로운 배열 만듬

        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        MyDate myDate = new MyDate(year,month,day);
        return myDate;
    }

    public static void main(String[] args) {
        Scheuler app = new Scheuler();
        app.processCommand();
    }
}
