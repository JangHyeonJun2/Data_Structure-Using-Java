package 변수_배열_반복문;

import java.util.Scanner;

/*
 * 사용자로부터 n개의 정수를 입력받은 후 오름차순으로 정렬(sort)하여 출력하는 코드이다.
 * 즉, 버블정렬 알고리즘이다.
 */
public class Code14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = 0;
        int[] data = new int[n];

        for(int i=0; i<data.length; i++){
            data[i] = sc.nextInt();

        }
        sc.close();

        for(int i=n-1; i>=0; i--){
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
}
