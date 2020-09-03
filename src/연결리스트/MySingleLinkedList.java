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

    public int indexOf(T item){
        Node<T> p = head;
        int index = 0;
        while(p != null){
            if(p.data.equals(item))
                return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    public Node<T> getNode(int index){
        if(index < 0 || index >= size)
            return null;
        Node<T> p = head;
        for (int i=0; i<index; i++){
            p = p.next;
        }
        return p;
    }
    public void add(int index, T item){
        if(index < 0 || index > size)
            return;
        if (index == 0)
            addFirst(item);
        else {
            Node<T> searchNode = getNode(index-1); //여기서 왜 index - 1이 나면 3번째에 추가하고 싶으면 2번째의 노드의 주소를 참조하고 있는 1번째의 next값을 알아야 하기 때문이다.
            addAfter(searchNode,item);
        }

    }

    public T remove(int index){
        if(index < 0 || index >= size)
            return null;

        if (index == 0){
            return removeFirst();
        }else {
            Node<T> preNode = getNode(index-1); //여기서도 index - 1은 삭제하고 싶은 노드가 3번째 노드이면 그 전 노드를 알아야하기 때문에 index - 1  이다.
            T removedItem = removeAfter(preNode);
            return removedItem;
        }
    }

    public T remove(T item){
        Node<T> p = head;
        Node<T> q = null;

        while(p != null && !p.data.equals(item)){
            q = p;
            p = p.next;
        }
        if(p == null)
            return null;
        else if(q == null)
            removeFirst();

        return removeAfter(q);
    }

    public T get(int index){
        if (index < 0 || index >= size)
            return null;
//        Node<T> p = head; //getNode와 중복된 코드이기 때문에 생략!
//        for(int i=0; i<index; i++){
//            p = p.next;
//        }
//        return p.data;
        return getNode(index).data;
    }
    public static void main(String[] args) {
        MySingleLinkedList<String> list = new MySingleLinkedList<>();
        list.add(0,"Monday");
        list.add(2,"Tuesday");
        list.add(0, "Saturday");
        list.add(1, "Friday");
        list.add(2, "Sunday");
        // Sa - F - Su - M - T
        String str = list.get(4);
        System.out.println("index(4) = "+str);
        String str2 = list.remove(4);
        System.out.println("index(4) = "+str2);
    }
}
