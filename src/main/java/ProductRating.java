import java.io.Serializable;

public final class ProductRating implements Serializable {

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 5;
    private short score;

    public void setScore(final int score) {
        if (score < MIN_SCORE || score > MAX_SCORE) {
            throw new IllegalArgumentException("Invalid score");
        }
        this.score = (short) score;
    }

    public int getScore() {
        return score;
    }
}
