public class Main {
    public static void main(String[] args) {
        final ProductRating rating = new ProductRating();
        System.out.println("Ocena przed zmianą: " + rating.getScore());
        rating.setScore(5);
        System.out.println("Ocena po zmianie: " + rating.getScore());
    }
}
