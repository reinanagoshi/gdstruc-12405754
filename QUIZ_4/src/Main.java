public class Main
{
    public static void main(String[] args)
    {
        Player ploo = new Player(134, "Ploof", 135);
        Player wardell = new Player(530, "TSN Mardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(4931, "Subroza", 604);
        Player annieDro = new Player(6919, "C9 Annie", 593);

        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(annieDro.getUserName(), annieDro);

        System.out.println("Hashtable After Inserts:");
        hashtable.printHashtable();

        System.out.println("\nRemoving 'Ploof'...");
        hashtable.remove("Ploof");

        System.out.println("\nHashtable After Removal:");
        hashtable.printHashtable();

        System.out.println("\nTesting GET for 'Subroza' after removal:");
        System.out.println(hashtable.get("Subroza"));

        System.out.println("\nRemoving 'C9 Annie'...");
        hashtable.remove("C9 Annie");

        System.out.println("\nHashtable After Removing C9 Annie:");
        hashtable.printHashtable();
    }
}