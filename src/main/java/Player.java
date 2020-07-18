public class Player {
    private String name;
    private Point point;
    public int score;
    private String result;

    public static Player CreatePlayerByName(String name){
        return new Player(name , Point.ZERO);
    }

    private Player(String name, Point point) {
        this.name = name;
        this.point = point;
        this.score = 0;
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
        this.score++;
        this.point = Point.CreateByScore(this.score);
    }

    public boolean scoreEquals(Player other){
        return this.score == other.score;
    }
}
