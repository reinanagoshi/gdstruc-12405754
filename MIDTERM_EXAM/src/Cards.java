public class Cards {

    public enum Suit
    {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank
    {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final Suit suit;
    private final Rank rank;

    public Cards(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    @Override

    public String toString()
    {
        return rank + " of " + suit;
    }
}