package 연결리스트다항식;

import java.util.Scanner;

public class MyPolynomialApp {
    private int count = 0;
    private int capacity = 10;
    private Polynomial[] polynomials = new Polynomial[capacity];
    private Scanner sc = new Scanner(System.in);

    public void processCommand(){
        while(true){
            System.out.print("$ ");
            String command = sc.next();
            if (command.equalsIgnoreCase("create")){
                handleCreate();
            }else if(command.equalsIgnoreCase("add")){
                handleAdd();
            }else if(command.equalsIgnoreCase("calc")){
                handleCalc();
            }else if(command.equalsIgnoreCase("print")){
                handleprint();
            }else if(command.equalsIgnoreCase("exit")){
                break;
            }
        }
    }

    private void handleCreate() {
        System.out.println("추가하고 싶은 함수를 입력하세요");
        System.out.print("->");
        char name = sc.next().charAt(0);
        Polynomial polynomial = new Polynomial(name);
        insert_polys(polynomial);
    }
    public void insert_polys(Polynomial p){
        int index = find(p.getName());
        if (index > -1){
            polynomials[index] = p;//아예 새로 다시 작성하게 해주는거 같다.
        }else {
            if (polynomials.length <= count)
                reallocate();
            polynomials[count++] = p;
        }
    }

    private int find(char name){
        for (int i=0; i<count; i++){
            if(polynomials[i].getName() == name)
                return i;
        }
        return -1;
    }

    private void reallocate() {
        System.out.println("events.length: " + polynomials.length);
        Polynomial[] tmp = new Polynomial[capacity*2];
        for(int i=0; i<count; i++){
            tmp[i] = polynomials[i];
        }
        polynomials = tmp;
        capacity *= 2;
        System.out.println("events.length: " + polynomials.length);
    }
    private void handleAdd() {
        System.out.println("어떤 함수의 이름에 인수와 차수를 추가하시겠어요?");
        System.out.print("->");
        char name = sc.next().charAt(0);
        System.out.print("인수를 입력하세요 : ");
        int coef = sc.nextInt();
        System.out.print("차수를 입력하세요 : ");
        int expo = sc.nextInt();


        int index = find(name);
        if (index < 0) {
            System.out.println("No search poly");
            return;
        }else {
            polynomials[index].addTerm(coef,expo);
        }
    }
    private void handleCalc() {
        System.out.println("어떤 함수에 x값을 추가하시겠어요?");
        System.out.print("->");
        char name = sc.next().charAt(0);
        int index = find(name);

        System.out.print("x값을 입력하세요 : ");
        int x = sc.nextInt();

        if (index < 0) {
            System.out.println("No search poly");
            return;
        }else {
            System.out.println(polynomials[index].calc(x));
        }

    }
    private void handleprint() {
        System.out.println("어떤 함수 출력하시겠어요?");
        System.out.print("->");
        char name = sc.next().charAt(0);
        int index = find(name);


        if (index < 0) {
            System.out.println("No search poly");
            return;
        }else {
            System.out.println(polynomials[index].toString());
        }
    }

    public static void main(String[] args) {
        MyPolynomialApp app = new MyPolynomialApp();
        app.processCommand();

    }
}
