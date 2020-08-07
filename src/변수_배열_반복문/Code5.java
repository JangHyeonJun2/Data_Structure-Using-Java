package 변수_배열_반복문;

public class Code5 {
    public static void main(String[] args) {
        int[] grades;

        grades = new int[5];

        for(int i=0; i < grades.length;i++){
            grades[i] = (int)(Math.random()*70)+1;
        }
        for(int i=0; i < grades.length; i++)
            System.out.println("값: "+grades[i]);
    }
}
