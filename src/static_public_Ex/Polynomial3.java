package static_public_Ex;

/*
 * 하나의 다항식을 표현하기 위한 클래스.
 */
public class Polynomial3 {
    public char name; // 다항식 이름
    public int nTerms; //다항식을 구성하는 항의 개수.
    public Term3[] term3s; //다항식을 구성하는 항들을 저장할 배열.

    public Polynomial3() {
        this.nTerms = 0;
        this.term3s = new Term3[100];
    }

    public Polynomial3(char name) {
        this.name = name;
        this.nTerms = 0;
        this.term3s = new Term3[100];
    }

    public int calcPolynomial(int x) {
        int result = 0;
        for(int i=0; i<nTerms;i++){
            result += term3s[i].calcTerm(x);
        }
        return result;
    }

    public void printPolymial(){
        for(int i=0; i<nTerms; i++){
           term3s[i].printTerm();
        }
    }

    public void addTerm(int ncoef, int nexpo){
        int index = findTerm(nexpo);
        if(index != -1){
            term3s[index].coef += ncoef;
            if(term3s[index].coef == 0){
                int i=index;
                for(;i<=nTerms;i++){
                    term3s[i] = term3s[i+1];
                }
            }
        }else {
            int i=nTerms-1;
            while(i>=0 && term3s[i].expo < nexpo){
                term3s[i+1] = term3s[i];
                i--;
            }
            term3s[i+1] = new Term3(ncoef,nexpo);
            nTerms++;
        }
    }

    public int findTerm(int e){
        for(int i = 0; i< nTerms && term3s[i].expo >= e; i++){
            if(term3s[i].expo == e)
                return i;
        }
        return -1;
    }
}
