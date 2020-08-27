package 추상클래스와인터페이스;

import java.util.Scanner;

public class ShapeApplication {
    private int capacity = 10;
    private Shape[] shapes = new Shape[capacity];
    private int count = 0;
    private Scanner sc = new Scanner(System.in);


    public void processCommand(){
        while (true){
            System.out.print("$ ");
            String command = sc.next();
            if(command.equalsIgnoreCase("add")){
                handleAdd();
            }else if(command.equalsIgnoreCase("show") || command.equalsIgnoreCase("showdetail")){
                handleShow(command.equalsIgnoreCase("showdetail"));
            }else if (command.equalsIgnoreCase("sort")){
                handleSort();
            }else if (command.equalsIgnoreCase("exit")){
                break;
            }
        }
        sc.close();
    }

    private void reallocate(){
        capacity *= 2;
        Shape[] tmp = new Shape[capacity];
        System.arraycopy(shapes,0,tmp,0,shapes.length);//shapes배열의 0번째부터의 값을 tmp배열 0번째부터 shapes.length까지 복사하여라
        shapes = tmp;
    }

    private void handleAdd() {
        String type = sc.next();
        switch (type){
            case "R":
                int w = sc.nextInt();
                int h = sc.nextInt();
                Rectangle r = new Rectangle(w, h);
                addShpe(r);
                break;
            case "C":
                int ra = sc.nextInt();
                Circle circle = new Circle(ra);
                addShpe(circle);
                break;
            case "T":
                //추가하기

        }

    }

    private void addShpe(Shape shape) {
        if(count > capacity){
            reallocate();
        }
        shapes[count++] = shape;
    }

    private void handleShow(boolean deatailed) {
        for (int i=0; i<count; i++){
            System.out.println( (i+1) + ", " + shapes[i].toString());
            if(deatailed){
                System.out.println("    The area is " + shapes[i].computerArea());
                System.out.println("    The Permeter is " + shapes[i].computerPerimeter());
            }
        }

    }

    private void handleSort() {


    }
    public static void main(String[] args) {
        ShapeApplication app = new ShapeApplication();
        app.processCommand();
    }
}
