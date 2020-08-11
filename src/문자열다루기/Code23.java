package 문자열다루기;

import java.io.*;
import java.util.Scanner;

public class Code23 {

    static String[] words = new String[1000000];
    static int[] count = new int[100000];
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
                    System.out.println("The word "+words[index]+" appears " + count[index] + " times.");
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
            System.out.println(words[i] + " " + count[i]);
        }
    }
    public static void saveAs(String fileName){
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));

            for (int i=0; i<n; i++){
                out.println(words[i] + " " + count[i]);
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
            count[index]++;
        }else { //not found

            int i = n-1; //단어가 n개 있으면 index는 0부터 시작이니깐 n-1이다.
            while(i>=0 && words[i].compareToIgnoreCase(str)>0){
                words[i+1] = words[i];
                count[i+1] = count[i];
                i--;
            }
            words[i+1] = str;
            count[i+1] = 1;
            n++;
        }
    }
    public static int findWord(String str){
        for(int i=0;i<n;i++){
            if(words[i].equals(str))
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
