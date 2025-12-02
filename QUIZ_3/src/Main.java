import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayQueue queue = new ArrayQueue(10);

        int gamesCreated = 0;
        int turn = 1;
        int playerIdCounter = 1;

        while (gamesCreated < 10)
        {
            System.out.println("\n--- Turn " + turn + " (Games created: " + gamesCreated + "/10) ---");
            System.out.println("Press Enter to simulate new players joining...");
            scanner.nextLine();
            turn++;

            int playersToQueue = random.nextInt(7) + 1;
            System.out.println(playersToQueue + " players joined the queue.");

            for (int i = 0; i < playersToQueue; i++)
            {
                Player p = new Player(playerIdCounter,
                        "Player" + playerIdCounter,
                        random.nextInt(100) + 1);
                queue.add(p);

                System.out.println("  - " + p.getUserName() + " (Level " + p.getLevel() + ") entered matchmaking.");

                playerIdCounter++;
            }

            System.out.println("\nCurrent queue size: " + queue.size());
            queue.printQueue();

            if (queue.size() >= 5)
            {
                gamesCreated++;
                System.out.println("\n=== GAME " + gamesCreated + " STARTING ===");
                System.out.println("Players joining the match:");

                for (int i = 0; i < 5; i++)
                {
                    Player removed = queue.remove();
                    System.out.println("  - " + removed.getUserName() + " (Lvl " + removed.getLevel() + ")");
                }

                System.out.println("=== GAME " + gamesCreated + " IN PROGRESS ===\n");

            }
            else
            {
                System.out.println("\nNot enough players. Waiting for the next turn...\n");
            }

            System.out.println("--------------------------------------------");
        }

        System.out.println("\n10 games have been successfully created. Program terminating.");
        scanner.close();
    }
}