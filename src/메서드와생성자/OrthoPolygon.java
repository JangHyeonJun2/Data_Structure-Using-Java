package 메서드와생성자;

public class OrthoPolygon {
    public int n;
    public Point[] vertices; // 꼭지점 담

    public OrthoPolygon(int k) {
        n = 0;
        vertices = new Point[k];//다각형을 생성할 때 예를들면 삼각형이 생성한다고 가정할 때, 꼭지점이 3개가 되어야하니깐 k=3이 되고 vertices에는 3개의 꼭지점이 들어가야한다.
    }

    public void addVertex(int x,int y){
        vertices[n++] = new Point(x,y);
    }

    public int maxX(){
        int max = vertices[0].x;
        for (int i=0; i<n; i++){
            if(vertices[i].x > max)
                max = vertices[i].x;
        }
        return max;
    }

    public boolean contains(Point p){
        //점 p에서 왼쪽 방향으로 다각형 외부까지 뻗어가는 하나의 성분 arrow를 만든다.
        // p의 반대쪽 점의 x좌표가 꼭지점들의 x좌표의 최대값보다 1이 크므로 이 점은 반드시 다각형의 외부에 있다.
        OrthoLine arrow = new OrthoLine(p,new Point(maxX()+1,p.y));
        int count = 0;
        for(int i=0; i<n; i++){
            OrthoLine edge = new OrthoLine(vertices[i],vertices[ (i+1)%n ]); //마지막 꼭지점이될 때는 마지막 꼭지점과 첫번째 꼭지점 즉,vertices[0]의 꼭지점과 비교를 해야하기 떄문에 (i+1)%n 이러한 계산이 나온다.
            if (arrow.intersects(edge))
                count++;
        }
        if(count == 0)
            return false;
        else
            return (count != 0 && count % 2 == 1);
    }
}
