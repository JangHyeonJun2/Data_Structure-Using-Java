package 메서드호출과프로그램의기능적분할;

import java.util.Scanner;

public class Code18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];

        for(int i=0; i<data.length; i++){
            data[i] = sc.nextInt();
        }
        bubblesort(data);
    }
    static void bubblesort(int[] data){
        int tmp;
        for(int i=data.length-1; i>=0; i--){
            for(int j=0; j<data.length-1; j++){
                tmp = data[j+1];
                if(data[j] > data[j+1]){
                    data[j+1] = data[j];
                    data[j] = tmp;
                }
            }
        }
        for(int i = 0; i<data.length; i++){
            System.out.print(data[i]+"  ");
        }
    }
//    static void swap(int a, int b){
//
//    }
}
