package static_public_Ex;
/*
 * 다항식을 구성하는 하나의 항의 표현하기 위한 클래스이다.
 * 계수(coef)와 차수(expo)를 가진다.
 */
public class Term3 {
    private int coef;
    private int expo;

    public Term3(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExpo() {
        return expo;
    }

    public void setExpo(int expo) {
        this.expo = expo;
    }

    public int calcTerm(int x) {
        return (int)(coef * Math.pow(x, expo)); //pow리턴값은 double이기 때문에 int로 캐스팅함
    }

    public void printTerm() {
        System.out.print(coef +"x^"+ expo +"+");
    }
}

