package 연결리스트다항식;

import 연결리스트.MySingleLinkedList;
import 연결리스트.Node;

public class Polynomial {
    public char name;
    public MySingleLinkedList<Term> terms;

    public Polynomial(char name) {
        this.name = name;
        this.terms = new MySingleLinkedList<>();
    }

    public char getName() {
        return name;
    }

    public void addTerm(int coef, int expo){
        if (coef == 0)
            return;

        Node<Term> p = terms.head;
        Node<Term> q = null;

        while (p!=null && p.data.expo > expo){
            q = p;
            p = p.next;
        }

        if (p!=null && p.data.expo == expo){
            p.data.coef += coef;
            if (p.data.coef == 0){
                if (q == null) //ㄷㅔ이터가 하나밖에 없을 때, 즉 데이터가 하나밖에 없으면 하나의 데이터 next는 null을 가리키고 있다.
                    terms.removeFirst();
                else
                    terms.removeAfter(q);
            }

        }else {
            Term t = new Term(coef,expo);
            if(q == null)
                terms.addFirst(t);
            else
                terms.addAfter(q,t);
        }
    }

    public int calc(int x){
        int result = 0;

        Node<Term> p = terms.head;
        while (p!=null){
            result += p.data.calc(x);
            p = p.next;
        }
        return result;
    }



    public String toString(){
//        String str = "";
//        Node<Term> p = terms.head;
//        while (p!=null){
//            str += ("+"+p.data.toString());
//            p = p.next;
//        }
//        return str;

        StringBuilder sb = new StringBuilder();
        sb.append(name +"(x)=");
        Node<Term> p = terms.head;
        while(p!=null){
            sb.append("+"+p.data.toString());
            p = p.next;
        }
        return sb.toString();
    }
}
