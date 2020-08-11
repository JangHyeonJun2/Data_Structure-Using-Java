package 클래스_객체_참조변수;

import java.io.*;
import java.util.Scanner;

public class IndexMaker {

//    static String[] words = new String[1000000];
//    static int[] count = new int[100000];

    static Item[] items = new Item[100000];
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("$ ");
            String command = sc.next();

            if(command.equals("read")){

                String fileName = sc.next();
                makeIndex(fileName);

            }else if(command.equals("find")){

                String str = sc.next();
                int index = findWord(str);
                if(index > -1)
                    System.out.println("The word "+ items[index].word+" appears " + items[index].count + " times.");
                else
                    System.out.println("The word " + str + "does not appear.");

            }else if (command.equals("saveas")){
                String fileName = sc.next();
                saveAs(fileName);
            }else if(command.equals("exit"))
                break;

        }
        sc.close();
        for(int i=0; i<n; i++){
            System.out.println(items[i].word + " " + items[i].count);
        }
    }
    public static void saveAs(String fileName){
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));

            for (int i=0; i<n; i++){
                out.println(items[i].word + " " + items[i].count);
            }

            out.close();
        } catch (IOException e) {
            System.out.println("Fail Save!!!");
        }
    }
    public static void makeIndex(String fileName){
        try {
            Scanner inFile = new Scanner(new File(fileName));
            while (inFile.hasNext()){
                String str = inFile.next();
                String trimmed = trimming(str);
                if(trimmed != null)
                    addWord(trimmed);
            }
        } catch (FileNotFoundException e) {
            System.out.println("no File");
            return;
        }
    }
    public static void addWord(String str){
        int index = findWord(str); //returns -1 if not found
        if(index != -1){//found
            items[index].count++;
        }else { //not found

            int i = n-1; //단어가 n개 있으면 index는 0부터 시작이니깐 n-1이다.
            while(i>=0 && items[i].word.compareToIgnoreCase(str)>0){
                items[i+1] = items[i];
//                items[i+1].word = items[i].word;
//                items[i+1].count = items[i].count;
                i--;
            }
            items[i+1] = new Item(); //만약 이게 없으면 NullPointerException이 발생한다. **중요**
            items[i+1].word = str;
            items[i+1].count = 1;
            n++;
        }
    }
    public static int findWord(String str){
        for(int i=0;i<n;i++){
            if(items[i].word.equals(str))
                return i;
        }
        return -1;
    }
    public static String trimming(String str){

        int i=0 , j=str.length()-1;
        while(i < str.length() && !Character.isLetter(str.charAt(i)))
            i++;

        while (j >= 0 && !Character.isLetter(str.charAt(j)))
            j--;


        if(i > j)
            return null;

        String trimmed = str.substring(i,j+1);
        return trimmed;
    }
}
