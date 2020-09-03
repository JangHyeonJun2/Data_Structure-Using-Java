package 연결리스트;

public class MySingleLinkedList<T> {
    public Node<T> head;
    public int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    public void addAfter(Node<T> before, T item){
        Node<T> temp = new Node<>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }
    public void addFirst(T item){
        Node<T> newNode = new Node<T>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T removeFirst(){
        if(head == null)
            return null;
        else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    public T removeAfter(Node<T> before){
        if(before.next == null)
            return null;

        T temp = before.next.data;
        before.next = before.next.next;
        size--;
        return temp;
    }
    public void add(int index, T item){

    }

    public int remove(int index){

    }

    public int indexOf(T item){

    }

    public T get(int index){

    }
    public static void main(String[] args) {

    }
}
