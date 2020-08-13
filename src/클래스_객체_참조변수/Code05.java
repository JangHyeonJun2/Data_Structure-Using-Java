package 클래스_객체_참조변수;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {
    static MyRectangle1[] rects = new MyRectangle1[100];
    static int n=0;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("data2.txt"));

            while(sc.hasNext()){
                rects[n] = new MyRectangle1();
                rects[n].lu = new MyPoint1();



                rects[n].lu.x = sc.nextInt();
                rects[n].lu.y = sc.nextInt();
                rects[n].width = sc.nextInt();
                rects[n].height = sc.nextInt();
                n++;
            }
            sc.close();


        } catch (FileNotFoundException e) {
            System.out.println("NO DATA FILE!!!");
            System.exit(1);
        }

        bubbleSort();

        for(int i=0;i<n;i++){
            System.out.println(rects[i].lu.x +" "+ rects[i].lu.y +" "+ rects[i].width +" "+ rects[i].height);
        }
    }
    private static void bubbleSort(){
        for(int i=n-1;i>0;i--){
            for (int j=0;j<i;j++){
                if(calcArea(rects[j]) > calcArea(rects[j+1])){
                    MyRectangle1 tmp = rects[j+1];
                    rects[j+1] = rects[j];
                    rects[j] = tmp;
                }
            }
        }
    }
    private static int calcArea(MyRectangle1 r){
        return r.width * r.height;
    }
}
