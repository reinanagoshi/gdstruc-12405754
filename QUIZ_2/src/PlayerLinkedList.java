public class PlayerLinkedList
{
    private PlayerNode head;
    private int size;

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);

        head = playerNode;
        size++;
    }

    public PlayerNode removeFromFront()
    {
        if (isEmpty())
        {
            return null;
        }

        PlayerNode removedNode = head;
        head = head.getNextPlayer();
        size--;

        removedNode.setNextPlayer(null);
        return removedNode;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int getSize()
    {
        return size;
    }

    public boolean contains(Player player)
    {
        PlayerNode current = head;

        while (current != null)
        {
            if (current.getPlayer().equals(player))
            {
                return true;
            }

            current = current.getNextPlayer();
        }

        return false;
    }

    public int indexOf(Player player)
    {
        PlayerNode current = head;
        int index = 0;

        while (current != null)
        {
            if (current.getPlayer().equals(player))
            {
                return index;
            }

            current = current.getNextPlayer();
            index++;
        }

        return -1;
    }

    public void printList()
    {
        PlayerNode current = head;
        System.out.print("HEAD -> ");

        while (current != null)
        {
            System.out.print(current.getPlayer());
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }

        System.out.println("null (Size: " + size + ")");
    }
}