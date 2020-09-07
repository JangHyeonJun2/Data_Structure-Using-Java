package 이중연결리스트;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T>{
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T item){
            this.data = item;
            this.next = null;
            this.prev = null;
        }
    }

    public Iterator<T> iterator(){
        return new KWListIterator(0);
    }

    public ListIterator<T> listIterator(){
        return new KWListIterator(0);
    }

    public ListIterator<T> listIterator(int index){
        return new KWListIterator(index);
    }

    private class KWListIterator implements ListIterator<T>{

        private Node<T> nextItem;
        private Node<T> lastItemReturned;
        private int index;

        public KWListIterator(int index) {
            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException("Invalid index" + index);
            }

            lastItemReturned = null;
            if(index == size){
                this.index = size;
                nextItem = null;
            }else {
                nextItem = head;
                for (this.index = 0;this.index < index; this.index++){
                    nextItem = nextItem.next;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0) || (nextItem.prev != null);
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            if (nextItem == null){
                nextItem = tail;
            }else {
                nextItem = nextItem.prev;
                lastItemReturned = nextItem;// 여기서 nextItem이랑 lastItemReturned가 같은 곳을 가리키지만 아무 상관없다.
                index--;
                return lastItemReturned.data;
            }
            return null;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {
            if(head == null){
                head = new Node<>(t);
                tail = head;
            }else if(nextItem == head){
                Node<T> newNode = new Node<>(t);
                newNode.next = nextItem;
                nextItem.prev = newNode;
                head = newNode;
            }else if (nextItem == null){
                Node<T> newNode = new Node<>(t);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }else {
                Node<T> newNode = new Node<>(t);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
        }
    }

    public int indexOf(T item){

    }

    public T get(int index){

    }

    public boolean remove(int index){

    }

    public void remove(T obj){

    }

    public int size(){
        return size;
    }
}
