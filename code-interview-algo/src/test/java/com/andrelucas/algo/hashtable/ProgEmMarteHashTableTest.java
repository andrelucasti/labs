package com.andrelucas.algo.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgEmMarteHashTableTest {

    @Test
    void shouldSaveData() {
        HashTable<String, String> hashTable = new ProgEmMarteHashTable<>();
        hashTable.put("key", "value");
        assertEquals("value", hashTable.get("key"));
    }

    @Test
    void shouldSaveALotOfIntegerData() {
        HashTable<Integer, String> hashTable = new ProgEmMarteHashTable<>();
        hashTable.put(0, "Andre");
        hashTable.put(4, "Lucas");
        hashTable.put(1, "Santos");
        hashTable.put(2, "Silva");

        assertEquals("Andre", hashTable.get(0));
        assertEquals("Lucas", hashTable.get(4));
        assertEquals("Santos", hashTable.get(1));
        assertEquals("Silva", hashTable.get(2));
    }

    @Test
    void shouldSaveALotOfStringData() {
        HashTable<String, String> hashTable = new ProgEmMarteHashTable<>();

        hashTable.put("Andre", "Lucas");
        hashTable.put("Karol", "Amorim");
        hashTable.put("Linda", "Santos");
        hashTable.put("Waldir", "Batista");

        assertEquals("Lucas", hashTable.get("Andre"));
        assertEquals("Amorim", hashTable.get("Karol"));
        assertEquals("Santos", hashTable.get("Linda"));
        assertEquals("Batista", hashTable.get("Waldir"));
    }


    @Test
    void shouldRemoveByKey() {
        HashTable<String, String> hashTable = new ProgEmMarteHashTable<>();
        hashTable.put("key0", "value0");
        hashTable.put("key1", "value1");

        hashTable.remove("key0");

        assertThrows(RuntimeException.class, () -> hashTable.get("key0"));

        assertEquals("value1", hashTable.get("key1"));
    }
}