package 메서드와생성자;
/*
 * 다항식을 구성하는 하나의 항의 표현하기 위한 클래스이다.
 * 계수(coef)와 차수(expo)를 가진다.
 */
public class Term2 {
    public int coef;
    public int expo;

    public int calcTerm(int x) {
        return (int)(coef * Math.pow(x, expo)); //pow리턴값은 double이기 때문에 int로 캐스팅함
    }

    public void printTerm() {
        System.out.print(coef +"x^"+ expo +"+");
    }
}

