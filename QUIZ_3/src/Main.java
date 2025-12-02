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
            System.out.println("\n╔══════════════════════════════════════════════════════════╗");
            System.out.println("║  TURN " + turn + "  │ Games created: " + gamesCreated + "/10");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println("Press Enter to simulate new players joining...");

            scanner.nextLine();
            turn++;

            int playersToQueue = random.nextInt(7) + 1;
            System.out.println("\n▶ " + playersToQueue + " players have joined matchmaking!");

            for (int i = 0; i < playersToQueue; i++)
            {
                Player p = new Player(playerIdCounter,
                        "Player" + playerIdCounter,
                        random.nextInt(100) + 1);
                queue.add(p);

                System.out.printf("    + %-12s | Level %2d joined the queue%n",
                        p.getUserName(), p.getLevel());

                playerIdCounter++;
            }

            System.out.println("\nQueue size: " + queue.size());
            System.out.println("────────── CURRENT QUEUE ──────────");
            queue.printQueue();
            System.out.println("────────────────────────────────────");

            if (queue.size() >= 5)
            {
                gamesCreated++;
                System.out.println("\n╔══════════════════════════════════╗");
                System.out.println("║       MATCH " + gamesCreated + " STARTING        ");
                System.out.println("╚══════════════════════════════════╝");
                System.out.println("Players in this match:\n");

                for (int i = 0; i < 5; i++)
                {
                    Player removed = queue.remove();
                    System.out.printf("   • %-12s | Lvl %2d%n",
                            removed.getUserName(), removed.getLevel());
                }

                System.out.println("\n▶ MATCH " + gamesCreated + " IN PROGRESS...\n");

            }
            else
            {
                System.out.println("\n⚠ Not enough players to start a match.");
                System.out.println("⌛ Waiting for more players...\n");
            }

            System.out.println("--------------------------------------------------------");
        }

        System.out.println("\n🎉 10 matches successfully created. Program terminating. 🎉");
        scanner.close();
    }
}