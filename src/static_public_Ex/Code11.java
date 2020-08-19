package static_public_Ex;

import 클래스_객체_참조변수.Menual;

import java.util.Scanner;

public class Code11 {
    static Polynomial3[] polys = new Polynomial3[100];
    static int n = 0;

    public static void main(String[] args) {
        Code11 app = new Code11();
        app.processCommand();
    }
    public static void processCommand(){
        Scanner kb = new Scanner(System.in);
        while(true){
            Menual menual = new Menual();
            System.out.print("$ ");
            String command = kb.next();

            if(command.equals("create")){
                char name = kb.next().charAt(0);

                if(compaName(name)){
                    System.out.println("이 이름은 사용중입니다.");
                    continue;
                }
                polys[n] = new Polynomial3(name);//중요!!!
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
                    polys[index].addTerm(c,e);
                }
//                System.out.println(polys[index].nTerms);


            }else if(command.equals("calc")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists.");
                }else {
                    int x = kb.nextInt();
                    int result = polys[index].calcPolynomial(x);
                    System.out.println(result);
                }


            }else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists.");
                }
                else{
                    polys[index].printPolymial();
                }
                System.out.println();


            }else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }
    private static boolean compaName(char name){
        for (int i=0;i<n;i++){
            if(polys[i].getName() == name)
                return true;
        }
        return false;
    }
    private static int find(char name){
        for (int i=0; i<n; i++){
            if(polys[i].getName() == name)
                return i;
        }
        return -1;
    }





}
