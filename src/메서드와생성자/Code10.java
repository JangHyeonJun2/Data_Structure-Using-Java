package 메서드와생성자;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * 이 예제는 다각형이 무조건 무조건 정사각형 또는 직사각형만 가능한 예제이다.
 */
public class Code10  {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data3.txt"));
        int n = sc.nextInt();
        OrthoPolygon orthoPolygon = new OrthoPolygon(n); //꼭지점의 개수를 먼저 입력받아 다각형을 생성한다.
        for(int i=0;i<n;i++){
            orthoPolygon.addVertex(sc.nextInt(),sc.nextInt());
        }

        Point testPoint = new Point(sc.nextInt(),sc.nextInt());
        sc.close();

        if(orthoPolygon.contains(testPoint))
            System.out.println("testpoint가 내부에 있습니다.");
        else
            System.out.println("testPoint가 외부에 있습니다.");
    }

}
