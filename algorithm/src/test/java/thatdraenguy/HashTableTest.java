package thatdraenguy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    public void illegalBucketNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HashTable<String>(0);
        });
    }

    @Test
    public void insertion() {
        HashTable<String> table = new HashTable<>(5);
        assertNull(table.put(0, "Oleg Haha"));
        assertEquals("Oleg Haha", table.get(0));
    }

    @Test
    public void repeatedInsertion() {
        HashTable<String> table = new HashTable<>(5);
        assertNull(table.put(0, "Oleg Haha"));
        assertEquals("Oleg Haha", table.get(0));
        assertEquals("Oleg Haha", table.put(0, "dmitrik"));
        assertEquals("dmitrik", table.get(0));
    }

    @Test
    public void collisionsInsertion() {
        String[] names = new String[] { "Oleg Haha", "dmitrik", "shipu", "big L", "dmitri chef", "furik" };
        // Number of buckets = 5, inserting 6 elements will guarantee a collision
        HashTable<String> table = new HashTable<>(5);
        for (int i = 0; i < 6; i++) {
            assertNull(table.put(i, names[i]));
            for (int j = 0; j <= i; j++) {
                assertEquals(names[j], table.get(j));
            }
        }
    }

    @Test
    public void getNonExistentKey() {
        HashTable<String> table = new HashTable<>(5);
        assertNull(table.get(52));
    }

    @Test
    public void deleteKey() {
        HashTable<String> table = new HashTable<>(5);
        assertNull(table.put(0, "Oleg Haha"));
        assertEquals("Oleg Haha", table.get(0));
        assertEquals("Oleg Haha", table.delete(0));
        assertNull(table.get(0));
    }

    @Test
    public void deleteNonExistentKey() {
        HashTable<String> table = new HashTable<>(5);
        assertNull(table.delete(0));
    }
}
