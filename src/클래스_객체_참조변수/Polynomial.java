package 클래스_객체_참조변수;
/*
 * 하나의 다항식을 표현하기 위한 클래스.
 */
public class Polynomial {
    public char name; // 다항식 이름
    public int nTerms = 0; //다항식을 구성하는 항의 개수.
    public Term[] terms; //다항식을 구성하는 항들을 저장할 배열.
}
