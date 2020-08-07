package 변수_배열_반복문;

import java.util.Scanner;

/*
 *n개의 음이 아닌 한 자리 정수를 입력받아 배열에 저장한다. 라
 * 이들 중에서 1개의 이상의 연속된 정수들을 합하여(?)
 * 얻을 수 있는 소수들 중에서 최대값을 구하여 출력하는 프로그램을 만들어
 */
public class Code13 {
    public static void main(String[] args) {
        //음이 아닌 정수를 받는 과정
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] data = new int[num];

        for(int i=0; i<data.length; i++){
            data[i] = sc.nextInt();
        }
        int max = 0;
        for(int i=0; i<data.length; i++){
            for(int j=i; j<data.length; j++){
                //convert data[i] ... data[j] into an integer
                int val = 0;
                for (int k=i; k<=j; k++){
                    val = (val*10)+data[k];
                }
                //test if it is a prime
                boolean isPrime = true;
                for(int k = 2; k*k <= val; k++){
                    if(isPrime && val % k == 0)//소수이면
                        isPrime = false;
                }
                if(isPrime && val > 1 && val > max){
                    max = val;
                }
            }
        }
        if(max > 0)
            System.out.println(max);
        else
            System.out.println("No prime number");
    }
}
