package 메서드호출과프로그램의기능적분할;

public class Code17 {
    public static void main(String[] args) {
        for(int i=1; i<100000; i++){
            if(isPrime(i))
                System.out.println("소수 값: "+ i);
        }
    }
    static boolean isPrime(int num){
        if(num < 2)
            return false;
        for(int i=2; i<Math.sqrt(num); i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
