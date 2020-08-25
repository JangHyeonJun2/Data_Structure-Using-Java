package 예제;

import java.util.Scanner;

public class Scheuler {
    public void processCommand(){
        Scanner sc = new Scanner(System.in);

        while (true){
            String command = sc.next();
            if(command.equals("addevent")){

            }else if(command.equals("list")){

            }else if(command.equals("show")){

            }else if(command.equals("exit")){
                break;
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        Scheuler app = new Scheuler();
        app.processCommand();
    }
}
