public class Main
{
    public static void main(String[] args)
    {
        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player(2, "LethalBacon", 205);
        Player hpDeskjet = new Player(3, "HPDeskjet", 34);
        Player heathcliff = new Player(4, "Heathcliff", 95);
        Player mimi = new Player(5, "Mimi", 50);
        Player aerin = new Player(6, "Aerin", 75);
        Player lyra = new Player(7, "Lyra", 88);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        // Add players
        System.out.println("\n");
        System.out.println("Adding players...");
        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskjet);
        playerLinkedList.printList();
        System.out.println("\n");

        // Add more
        System.out.println("Adding Lyra, Aerin, and Mimi...");
        playerLinkedList.addToFront(mimi);
        playerLinkedList.addToFront(aerin);
        playerLinkedList.addToFront(lyra);
        playerLinkedList.printList();
        System.out.println("\n");

        // Test contains()
        System.out.println("Checking contains...");
        System.out.println("Contains Asuna? " + playerLinkedList.contains(asuna));
        System.out.println("Contains Lyra? " + playerLinkedList.contains(lyra));
        System.out.println("Contains Heathcliff? " + playerLinkedList.contains(heathcliff));
        System.out.println("\n");

        // Test indexOf()
        System.out.println("Checking indexOf...");
        System.out.println("Index of Lyra: " + playerLinkedList.indexOf(lyra));
        System.out.println("Index of HPDeskjet: " + playerLinkedList.indexOf(hpDeskjet));
        System.out.println("Index of Asuna: " + playerLinkedList.indexOf(asuna));
        System.out.println("Index of Heathcliff: " + playerLinkedList.indexOf(heathcliff));
        System.out.println("\n");

        // Remove from front
        System.out.println("Removing from front (Lyra)...");
        PlayerNode removed = playerLinkedList.removeFromFront();
        System.out.println("Removed: " + removed);
        playerLinkedList.printList();
    }
}