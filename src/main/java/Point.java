public enum Point {
    ZERO("Love", 0),
    ONE("Fifteen", 1),
    TWO("Thirty", 2),
    THREE("Forty", 3);

    public String value;
    public int score;

    Point(String value, int score) {
        this.value = value;
        this.score = score;
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

    public boolean inRangeZeroToTwo() {
        return this.score >= ZERO.score && this.score <= TWO.score;
    }

    public boolean equals(Point point) {
        return this.score == point.score;
    }
}
