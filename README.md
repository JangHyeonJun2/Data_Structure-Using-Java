# 자바를 사용한 자료구조 연습
### 8/1 ~ 8/31
- 변수,배열,반복문 (clear)
- 메서드 호출과 프로그램의 기능적 분할 (clear)
- 문자열 다루기 (clear)
- 클래스,객체, 참조변수 (clear)
- 메서드와 생성자 (clear)
- static 그리고 public  (clear)
- 상속(Inheritance) (clear)
- 예제(Scheduler Program) (clear)
- 클래스 Object와 Wrapper 클래스 (clear)
- 추상클래스와 인터페이스 (clear)
- Generic 프로그래밍과 Generics (clear)
- 연결리스트의 개념과 기본연산
- 연결리스트 응용예
- 연결리스트와 Iterator
- 이중연결리스트와 listIterator


# Comparable과 Comparator의 차이와 사용법

### 객체의 정렬 기준을 명시하는 두 가지 방법

1. Interface Comparable

   - 정의 

     - 정렬 수행 시 **기본적으로 적용되는** 정렬 기준이 되는 메서드를 정의하는 인터페이스

     - Package: java.lang.Comparable

       - Java에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있으며, 정렬 시에 이에 맞게 정렬이 수행된다. 

         ```java
         // Integer class
         public final class Integer extends Number implements Comparable<Integer> { ... }
         // String class
         public final class String implements java.io.Serializable, Comparable<String>, CharSequence { ... }
         ```

       - Integer, Double 클래스: 오름차순 정렬

       - String 클래스: 사전순 정렬

   - 구현 방법

     - 정렬할 객체에 Comparable interface를 implements 후, compareTo() 메서드를 오버라이드 하여 구현한다.
     - compareTo() 메서드 작성법
       - 현재객체 < 파라미터로 넘어온 객체: 음수리턴
       - 현재 객체 == 파라미터로 넘어온 객체: 0 리턴
       - 현재 객체 > 파라미터로 넘어온 객체: 양수 리턴

   - 사용 방법

     - Arrays.sort(array)
     - Collections.sort(list)

2. Arrays.sort()와 Collection.sort()의 차이

   - Arrays.sort()
     - **배열** 정렬의 경우
     - Ex)byte[], char[], double[], int[], Object[], T[]등 Object Array에서는 TimSort(Merge Sort + Insertion Sort)를 사용
     - Object Array: 새로 정의한 클래스에 대한 배열 *Primitive Array에서는 Dual Pivot QuickSort(Quick Sort + Insertion Sort)를 사용
     - Primitive Array: 기본 자료형에 대한 배열
   - Collections.sort()
     - **List Collection** 정렬의 경우
     - Ex) ArrayList, LinkedList, Vector등 * 내부적으로 Arrays.sort()를 사용

3. Comparable interface를 이용한 Java 객체를 정렬

   ```java
   // x좌표가 증가하는 순, x좌표가 같으면 y좌표가 감소하는 순으로 정렬하라.
   class Point implements Comparable<Point> {
       int x, y;
   
       @Override
       public int compareTo(Point p) {
           if(this.x > p.x) {
               return 1; // x에 대해서는 오름차순
           }
           else if(this.x == p.x) {
               if(this.y < p.y) { // y에 대해서는 내림차순
                   return 1;
               }
           }
           return -1;
       }
   }
   
   // main에서 사용법
   List<Point> pointList = new ArrayList<>();
   pointList.add(new Point(x, y));
   Collections.sort(pointList);
   ```

   

1. Interface Comparator

   - 정의
     - 정렬 가능한 클래스(Comparable 인터페이스를 구현한 클래스)들의 **기본 정렬 기준과 다르게 정렬**하고 싶을 때 사용하는 인터페이스
     - package: java.util.Comparator
       - 주로 익명 클래스로 사용된다.
       - 기본적인 정렬방법인 오름차순 정렬을 **내림차순으로 정렬할 때** 많이 사용한다.
   - 구현 방법
     - Comparator interface를 implements 후 compare() 메서드를 오버라이드한 myComparator class를 작성한다.
     - compare() 메서드 작성법
       - 첫 번째 파라미터로 넘어온 객체 < 두 번째 파라미터로 넘어온 객체: 음수 리턴
       - 첫 번째 파라미터로 넘어온 객체 == 두 번째 파라미터로 넘어온 객체: 0 리턴
       - 첫 번째 파라미터로 넘어온 객체 > 두 번째 파라미터로 넘어온 객체: 양수 리턴
     - 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경
       - 즉 Integer.compare(x,y)(오름차순 정렬)와 동일한 개념이다.
         - return(x < y) ? -1 : ((x==y)) ? 0 : 1);
       - 내림차순 정렬의 경우 두 파라미터의 위치를 바꿔준다.
         - Integer.compare(y,x)(내림차순 정렬)
   - 사용 방법
     - Arrays.sort(array, myComparator)
     - Collections.sort(list, myComparator)
     - Arrays.sort(), Collections.sort()메서드는 두 번째 인자로 Comparator interface를 받을 수 있다.

2. Comparator interface를 이용한 Java 객체를 정렬

   ```java
   // x좌표가 증가하는 순, x좌표가 같으면 y좌표가 감소하는 순으로 정렬하라.
   class MyComparator implements Comparator<Point> {
     @Override
     public int compare(Point p1, Point p2) {
       if (p1.x > p2.x) {
         return 1; // x에 대해서는 오름차순
       }
       else if (p1.x == p2.x) {
         if (p1.y < p2.y) { // y에 대해서는 내림차순
           return 1;
         }
       }
       return -1;
     }
   }
   
   // main에서 사용법
   List<Point> pointList = new ArrayList<>();
   pointList.add(new Point(x, y));
   MyComparator myComparator = new MyComparator();
   Collections.sort(pointList, myComparator);
   ```

3. Comparator 익명 클래스 이용

   ```java
   Comparator<Point> myComparator = new Comparator<Point>() {
     @Override
     public int compare(Point p1, Point p2) { 위와 동일 }
   };
   
   List<Point> pointList = new ArrayList<>();
   pointList.add(new Point(x, y));
   Collections.sort(pointList, myComparator);
   ```

### Reference

- https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
