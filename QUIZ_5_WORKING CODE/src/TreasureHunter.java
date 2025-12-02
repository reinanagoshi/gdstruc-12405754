import java.util.Random;

public class TreasureHunter
{
    private int[] data;
    private String[] treasures;

    public TreasureHunter(int[] data, String[] treasures)
    {
        this.data = data;
        this.treasures = treasures;
    }

    public int treasureHunt(int target)
    {
        boolean[] visited = new boolean[data.length];
        int visitedCount = 0;

        Random rand = new Random();
        int index = rand.nextInt(data.length);

        while (visitedCount < data.length)
        {
            if (data[index] == target)
            {
                return index; // Found!
            }

            visited[index] = true;
            visitedCount++;

            int next = (index + 1) % data.length;

            while (visited[next])
            {
                next = (next + 1) % data.length;
            }

            index = next;
        }

        return -1;
    }

    public void printData()
    {
        for (int i = 0; i < data.length; i++)
        {
            System.out.println("Mysterious Number " + data[i] + " hides a treasure...");
        }
    }
}