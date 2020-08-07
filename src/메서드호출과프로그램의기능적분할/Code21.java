package 메서드호출과프로그램의기능적분할;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21 {
    static int n;
    static int [][]grid;

    static int[] offsetX = {0,1,1,1,0,-1,-1,-1};
    static int[] offsetY = {-1,-1,0,1,1,1,0,-1};

    public static void main(String[] args) {
        try {
            Scanner inFile = new Scanner(new File("data.txt"));
            n = inFile.nextInt();
            grid = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    grid[i][j] = inFile.nextInt();
                }
            }
            inFile.close();

            for(int x=0; x<n; x++){
                for(int y=0; y<n; y++){
                    for (int dir=0; dir<8; dir++){
                        for(int len=1; len<=n; len++){
                            int val = computerValue(x,y,dir,len);// int computerValue(int x,int y,int dir,int len)위치(x,y)에서 dir 방향으로 연속된 len개의 digit로 만들어지는 정수를 반환, 그런 값이 없으면 -1을 반환한다.
                            if(val != -1 && isPrime(val))
                                System.out.println("값: "+val);
                        }

                    }
                    System.out.println("-------------------------");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No File");
        }
    }
    static int computerValue(int x,int y,int dir,int len){
        int value=0;
        for(int i=0; i<len; i++){
            int digit = getDigit(x,y,dir,i);//시작위치(x,y)에서 dir 방향으로 i칸 떨어진 자리에 있는 digit를 반환한다. 만약 그런 자리가 존재하지 않으면 -1을 반환하라.
            if(digit == -1)
                return -1;
            value = value*10+digit;
        }
        return value;
    }
    static boolean isPrime(int val){
        if(val < 2)
            return false;
        for (int i=2; i<Math.sqrt(val);i++){
            if(val % i == 0)
                return false;
        }
        return true;
    }
    static int getDigit(int x,int y,int dir,int len){
//        int newX = x, newY = y;
//        switch (dir){
//            case 0:
//                newY-=len;
//                break;
//            case 1:
//                newX+=len;
//                newY-=len;
//                break;
//            case 2:
//                newX+=len;
//                break;
//            case 3:
//                newX+=len;
//                newY+=len;
//                break;
//            case 4:
//                newY+=len;
//                break;
//            case 5:
//                newX-=len;
//                newY+=len;
//                break;
//            case 6:
//                newX-=len;
//                break;
//            case 7:
//                newX-=len;
//                newY-=len;
//                break;
//        }

        int newX = x+len*offsetX[dir];
        int newY = y+len*offsetY[dir];
        if(newX < 0 || newX >= n || newY < 0 || newY >=n)
            return -1;
        else
            return grid[newX][newY];
    }
}
