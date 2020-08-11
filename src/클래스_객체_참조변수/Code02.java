package 클래스_객체_참조변수;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code02 {
    static Person1[] members = new Person1[10];
    static int n = 0;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));

            while(sc.hasNext()){
                String name = sc.next();
                String number = sc.next();

                members[n] = new Person1();
                members[n].name = name;
                members[n].p_number = number;
                n++;
            }




            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File");
        }
        bubbleSort();
        for(int i=0; i<n; i++){
            System.out.println(members[i].name + " , " + members[i].p_number);
        }
    }
    static void bubbleSort(){

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(members[j].name.compareToIgnoreCase(members[j+1].name) > 0){
                    Person1 tmp = members[j+1];
                    members[j+1] = members[j];
                    members[j] = tmp;
                }
            }
        }
    }
}
