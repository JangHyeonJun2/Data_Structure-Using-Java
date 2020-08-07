package 메서드호출과프로그램의기능적분할;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code19 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] name = new String[100];
        String[] number = new String[100];

        int n = 0;

        Scanner sc = new Scanner(new File("input.txt"));

        while (sc.hasNext()){
            name[n] = sc.next();
            number[n] = sc.next();
            n++;
        }
        for(int i=0; i<n; i++){
            System.out.println("이름 : " + name[i] + ",  " + "전화번호: " + number[i]);
        }
        sc.close();
    }
}
