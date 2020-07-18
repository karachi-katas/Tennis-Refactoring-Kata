public class Player {
    private String name;
    private Point point;
    private String result;

    public static Player CreatePlayerByName(String name){
        return new Player(name , Point.ZERO);
    }

    private Player(String name, Point point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void increment(){
        this.point.score++;
        this.point = Point.CreateByScore(this.point.score);
    }
}
