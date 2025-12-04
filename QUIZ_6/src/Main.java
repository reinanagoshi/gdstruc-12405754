public class Main
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();

        System.out.println("\n========================================");
        System.out.println("BINARY SEARCH TREE DEMO");
        System.out.println("========================================");
        System.out.println("\nInserting values...");

        int[] values = {
                25,
                17,
                29,
                10,
                18,
                26,
                -5,
                60,
                55
        };

        for (int v : values)
        {
            System.out.println(" • Inserted: " + v);
            tree.insert(v);
        }

        System.out.println("\nAll values inserted successfully!");

        System.out.println("\n========================================");
        System.out.println("IN-ORDER TRAVERSAL (DESCENDING)");
        System.out.println("========================================");
        tree.traverseInOrderDescending();

        System.out.println("\n========================================");
        Node minNode = tree.getMin();
        Node maxNode = tree.getMax();

        System.out.println("Minimum Value: " + (minNode != null ? minNode.getData() : "N/A"));
        System.out.println("Maximum Value: " + (maxNode != null ? maxNode.getData() : "N/A"));
        System.out.println("========================================");

        System.out.println("\nProgram finished.");
    }
}