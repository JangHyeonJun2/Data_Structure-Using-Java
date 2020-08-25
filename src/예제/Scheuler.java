package 예제;

import java.util.Scanner;

public class Scheuler {

    public Event[] events = new Event[100];
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

            }else if(command.equals("show")){

            }else if(command.equals("exit")){
                break;
            }
        }
        sc.close();
    }

    private void handelAddDeadlineEvent() {

    }

    private void handleAddDurationEvent(){

    }

    private void handleAddOneDayEvent(){
        System.out.print("  when:  ");
        String dateString = sc.next(); //2014/12/3
        System.out.print("  title: ");
        String datetitle = sc.next(); // mybirthday

        String[] dates = dateString.split("/"); // 구분자(/)로 새로운 배열 만듬

    }

    public static void main(String[] args) {
        Scheuler app = new Scheuler();
        app.processCommand();
    }
}
