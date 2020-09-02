package 제네릭스;

import org.omg.CORBA.Object;

public class MyArrayList<T> {

    private static final int INIT_CAPACITY = 10;
    private T[] theData;
    private int size;
    private int capacity = INIT_CAPACITY;

    public MyArrayList() {
        theData = (T [])new Object [INIT_CAPACITY];
        size = 0;

    }
    private void rellocate() {
        capacity *= 2;
        T[] tmp = (T[])new Object[capacity*2];
        System.arraycopy(theData,0,tmp,0,theData.length);//shapes배열의 0번째부터의 값을 tmp배열 0번째부터 shapes.length까지 복사하여라
        theData = tmp;
    }

    public void add(int index, T data){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if(size >= capacity)
            rellocate();
        for (int i=size-1; i>=index; i--){
            theData[i+1] = theData[i];
        }
        theData[index] = data;
        size++;
    }

    public void add(T data){
        add(size,data);
    }

    public int size(){
        return size;
    }

    public int indexOf(T data){
        for (int i=0; i<size; i++){
            if(theData[i].equals(data)) //여기서 == 는 안된다 == 연산자는 프로미티어타입만 가능한데 T의 타입이 프리미티어 타입이라는 보장이 없기 때문에 안됨!
                return i;
        }
        return -1;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public T set(int index, T newValue){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public T remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T returnValue = theData[index];
        for (int i=index +1 ; i<size; i++){
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }
}
