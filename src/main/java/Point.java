public enum Point {
    ZERO("Love"),
    ONE("Fifteen"),
    TWO("Thirty"),
    THREE("Forty");

    public String value;

    Point(String value) {
        this.value = value;
    }

    public static Point CreateByScore(int score) {
        if (score == 0) {
            return Point.ZERO;
        }
        if (score == 1) {
            return Point.ONE;
        }
        if (score == 2) {
            return Point.TWO;
        }
        return Point.THREE;
    }
}
