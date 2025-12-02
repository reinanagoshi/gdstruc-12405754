import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        CardStack playerDeck = new CardStack();
        CardStack discardPile = new CardStack();
        List<Cards> playerHand = new ArrayList<>();

        List<Cards> cardsToShuffle = new ArrayList<>();

        for (int i = 0; i < 30; i++)
        {
            Cards.Suit suit = Cards.Suit.values()[i % 4];
            Cards.Rank rank = Cards.Rank.values()[i % 13];
            cardsToShuffle.add(new Cards(suit, rank));
        }

        Collections.shuffle(cardsToShuffle);

        for (Cards cards : cardsToShuffle)
        {
            playerDeck.push(cards);
        }

        System.out.println("\n30-card deck initialized and shuffled.");
        System.out.println("\n-------------------------------------------\n");

        Random rand = new Random();
        int turn = 1;

        while (!playerDeck.isEmpty())
        {
            System.out.println("TURN " + (turn++));

            System.out.println("\nPlayer Hand: " + playerHand);
            System.out.println("Cards in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard: " + discardPile.size());

            int command = rand.nextInt(3) + 1;
            int x = rand.nextInt(5) + 1;

            System.out.println("\nRandom Command: " + command + " (x = " + x + ")");

            switch (command)
            {
                case 1: // Draw
                    System.out.println("Command: Draw " + x + " cards.\n");
                    for (int i = 0; i < x; i++)
                    {
                        if (playerDeck.isEmpty())
                        {
                            System.out.println("\n...but the deck is empty!");
                            break;
                        }

                        Cards drawnCard = playerDeck.pop();
                        playerHand.add(drawnCard);
                        System.out.println("Drew: " + drawnCard);
                    }
                    break;

                case 2: // Discard
                    System.out.println("Command: Discard " + x + " cards.\n");
                    for (int i = 0; i < x; i++)
                    {
                        if (playerHand.isEmpty())
                        {
                            System.out.println("\n...but your hand is empty!");
                            break;
                        }

                        Cards discardedCard = playerHand.remove(0);
                        discardPile.push(discardedCard);
                        System.out.println("Discarded: " + discardedCard);
                    }
                    break;

                case 3: // Get from discard
                    System.out.println("Command: Get " + x + " cards from discard.\n");
                    for (int i = 0; i < x; i++)
                    {
                        if (discardPile.isEmpty())
                        {
                            System.out.println("\n...but the discard pile is empty!");
                            break;
                        }

                        Cards retrievedCard = discardPile.pop();
                        playerHand.add(retrievedCard);
                        System.out.println("Retrieved: " + retrievedCard);
                    }
                    break;
            }

            System.out.println("\n-------------------------------------------\n");
        }

        System.out.println("GAME OVER: The player deck is empty.\n");
        System.out.println("Final Hand: " + playerHand);
        System.out.println("Final Discard Pile: " + discardPile.size() + " cards.");
    }
}