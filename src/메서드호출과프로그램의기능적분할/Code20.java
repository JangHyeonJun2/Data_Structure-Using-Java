package 메서드호출과프로그램의기능적분할;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
    static String[] name = new String[100];
    static String[] number = new String[100];
    static int n = 0;


    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(new File("input.txt"));

        while (sc.hasNext()){
            name[n] = sc.next();
            number[n] = sc.next();
            n++;
        }
        bubblesort();


        for(int i=0; i<n; i++){
            System.out.println("이름 : " + name[i] + ",  " + "전화번호: " + number[i]);
        }
        sc.close();
    }
    static void bubblesort(){
        for(int i = 0; i<n; i++){
            for(int j=0; j<i; j++){
                if(name[j].compareTo(name[j+1]) > 0){
                    String tmp = name[j+1];
                    name[j+1] = name[j];
                    name[j] = name[j+1];

                    String tmp1 = number[j+1];
                    number[j+1] = number[j];
                    number[j] = number[j+1];
                }
            }
        }
    }
}
