package Model;

public class Coordinates {
    private int x,y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    } 

    public boolean isPointValid(){
        return (x>=0 && y>=0 && x<9 && y<9);
    }

    public static Coordinates getMidPoint(Coordinates from, Coordinates to) {
        return new Coordinates((from.getX()+to.getX())/2,(from.getY()+to.getY())/2);
    }
    
}
