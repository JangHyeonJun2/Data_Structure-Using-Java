package 메서드와생성자;

public class OrthoLine {
    public Point u;
    public Point v;

    public OrthoLine(Point p, Point q) {
        this.u = p;
        this.v = q;

        if(p.x > q.x || p.x == q.x && p.y < q.y){
            swap();
        }
    }

    public void swap(){
        Point tmp = u;
        u = v;
        v = tmp;
    }

    public OrthoLine(int x1,int y1, int x2, int y2){
        u = new Point(x1,y1);
        v = new Point(x2,y2);

    }
    public boolean isVertical(){
        return u.x == v.x; //x점이 같으면 수직선! Not이면 수평선!
    }
    //두 개의 선이 겹칠때 메서드
    public boolean intersects(OrthoLine other){
        if(isVertical() && !other.isVertical()){
            return (other.u.x < u.x && other.v.x > u.x && other.u.y < u.y && v.y < other.u.y);
        }else if(!isVertical() && other.isVertical()){
            return (other.u.x > u.x && other.u.x < v.x && u.y < other.u.y && u.y > other.v.y);
        }else
            return false;
    }
}
