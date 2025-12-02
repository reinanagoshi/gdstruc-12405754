import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] numbers = {
                5,
                12,
                7,
                9,
                3,
                15,
                8,
                1
        };

        String[] treasures = {
                "Rusty Old Sword",
                "Golden Chalice",
                "Bag of Strange Coins",
                "Potion of Healing",
                "Ancient Scroll",
                "Enchanted Ruby",
                "Dragon Egg",
                "Mysterious Key"
        };

        TreasureHunter hunter = new TreasureHunter(numbers, treasures);

        System.out.println("'There is treasure to be found...'\n");
        hunter.printData();

        Scanner input = new Scanner(System.in);
        System.out.print("\n'I choose...'\nNumber: ");

        int target = input.nextInt();
        int result = hunter.treasureHunt(target);

        if (result == -1)
        {
            System.out.println("\nTreasure NOT found.");
        }
        else
        {
            System.out.println("\nTreasure Found!");
            System.out.println("Your treasure is: " + treasures[result]);
        }
    }
}