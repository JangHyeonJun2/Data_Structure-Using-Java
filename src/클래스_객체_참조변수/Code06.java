package 클래스_객체_참조변수;

import java.util.Scanner;

public class Code06 {
    static Polynomial[] polys = new Polynomial[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String command = kb.next();

            if(command.equals("create")){
                char name = kb.next().charAt(0);
//
//                if(find(name) == i){
//                    System.out.println("이 이름은 사용중입니다.");
//                    continue;
//                }
                polys[n] = new Polynomial();//중요!!!
                polys[n].terms = new Term[100];
                polys[n].name = name;
                polys[n].nTerms = 0;
                n++;

            }else if(command.equals("add")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    addTerm(polys[index],c,e);
                }
                System.out.println(polys[index].nTerms);


            }else if(command.equals("calc")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists.");
                }else {
                    int x = kb.nextInt();
                    int result = calcPolynomial(polys[index],x);
                    System.out.println(result);
                }


            }else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists.");
                }
                else{
                    printPolymial(polys[index]);
                }
                System.out.println();


            }else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }

    private static int calcPolynomial(Polynomial poly, int x) {
        int result = 0;
        for(int i=0; i<poly.nTerms;i++){
            result += calcTerm(poly.terms[i],x);
        }
        return result;
    }

    private static int calcTerm(Term term, int x) {
        return (int)(term.expo * Math.pow(x,term.expo)); //pow리턴값은 double이기 때문에 int로 캐스팅함
    }

    private static int find(char name){
        for (int i=0; i<n; i++){
            if(polys[i].name == name)
                return i;
        }
        return -1;
    }
    private static void addTerm(Polynomial p,int c,int e){
        int index = findTerm(p,e);
        if(index != -1){
            p.terms[index].coef += c;
            if(p.terms[index].coef == 0){
                int i=index;
                for(;i<=p.nTerms;i++){
                    p.terms[i] = p.terms[i+1];
                }
            }
        }else {
            int i=p.nTerms-1;
            while(i>=0 && p.terms[i].expo < e){
                p.terms[i+1] = p.terms[i];
                i--;
            }
            p.terms[i+1] = new Term();
            p.terms[i+1].coef = c;
            p.terms[i+1].expo = e;
            p.nTerms++;
        }
    }
    private static int findTerm(Polynomial p ,int e){
        for(int i=0;i<p.nTerms && p.terms[i].expo >= e; i++){
            if(p.terms[i].expo == e)
                return i;
        }
        return -1;
    }
    private static void printPolymial(Polynomial p){
        for(int i=0; i<p.nTerms; i++){
            printTerm(p.terms[i]);
        }
    }

    private static void printTerm(Term term) {
        System.out.print(term.coef +"x^"+ term.expo +"+");
    }
}
