public class SimpleHashtable
{
    private StoredPlayer[] hashtable;

    public SimpleHashtable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey))
        {
            int stoppingIndex = hashedKey;

            hashedKey = (hashedKey + 1) % hashtable.length;

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey))
        {
            System.out.println("Table full! Cannot insert " + key);
        }
        else
        {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;
        hashedKey = (hashedKey + 1) % hashtable.length;

        while (hashedKey != stoppingIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key))
        {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
        {
            return hashedKey;
        }

        return -1;
    }

    public Player get(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }

        return hashtable[hashedKey].value;
    }

    public Player remove(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            System.out.println(key + " not found!");
            return null;
        }

        Player removedPlayer = hashtable[hashedKey].value;

        hashtable[hashedKey] = null;
        StoredPlayer[] oldHashtable = hashtable;
        hashtable = new StoredPlayer[oldHashtable.length];

        for (StoredPlayer sp : oldHashtable)
        {
            if (sp != null)
            {
                put(sp.key, sp.value);
            }
        }

        return removedPlayer;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            System.out.println("Element " + i + ": " + hashtable[i]);
        }
    }
}