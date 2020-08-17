package 메서드와생성자;

/*
 * 하나의 다항식을 표현하기 위한 클래스.
 */
public class Polynomial2 {
    public char name; // 다항식 이름
    public int nTerms; //다항식을 구성하는 항의 개수.
    public Term2[] term2s; //다항식을 구성하는 항들을 저장할 배열.

    public Polynomial2() {
        this.nTerms = 0;
        this.term2s = new Term2[100];
    }

    public Polynomial2(char name) {
        this.name = name;
        this.nTerms = 0;
        this.term2s = new Term2[100];
    }

    public int calcPolynomial(int x) {
        int result = 0;
        for(int i=0; i<nTerms;i++){
            result += term2s[i].calcTerm(x);
        }
        return result;
    }

    public void printPolymial(){
        for(int i=0; i<nTerms; i++){
           term2s[i].printTerm();
        }
    }

    public void addTerm(int ncoef, int nexpo){
        int index = findTerm(nexpo);
        if(index != -1){
            term2s[index].coef += ncoef;
            if(term2s[index].coef == 0){
                int i=index;
                for(;i<=nTerms;i++){
                    term2s[i] = term2s[i+1];
                }
            }
        }else {
            int i=nTerms-1;
            while(i>=0 && term2s[i].expo < nexpo){
                term2s[i+1] = term2s[i];
                i--;
            }
            term2s[i+1] = new Term2(ncoef,nexpo);
            nTerms++;
        }
    }

    public int findTerm(int e){
        for(int i = 0; i< nTerms && term2s[i].expo >= e; i++){
            if(term2s[i].expo == e)
                return i;
        }
        return -1;
    }
}
