package com.andrelucas.algo.hashtable;

public class CustomHashTable<TKey, TValue> implements HashTable<TKey, TValue> {
    private final TablePair<TKey, TValue>[] table;
    private int size;

    public CustomHashTable() {
        table = new TablePair[10];
        size = 0;
    }



    // Bad Implementation O(n)
/*    @Override
    public void put(TKey tKey, TValue tValue) {
        TablePair<TKey, TValue> tablePairByKey = getTablePairByKey(tKey);
        if (size > 0 && tablePairByKey != null) {
          throw new RuntimeException("Key already exists");

        } else {
            table[size++] = new TablePair<>(tKey, tValue);
        }
    }*/

    // O(1)
    @Override
    public void put(TKey tKey, TValue tValue) {
        var hash = Math.abs(tKey.hashCode());
        var index = hash % table.length;

        System.out.println("hash: " + hash);
        System.out.println("index: " + index);
        table[index] = new TablePair<>(tKey, tValue);
    }


// bad implementation (0)n
/*
    @Override
    public TValue get(TKey tKey) {
        TablePair<TKey, TValue> tablePairByKey = getTablePairByKey(tKey);
        if (tablePairByKey != null) {
            return tablePairByKey.tValue();
        }

        throw new RuntimeException("Key not found");
    }
*/

    // O(1)
    @Override
    public TValue get(TKey tKey) {
        var hash = tKey.hashCode();
        var index = hash % table.length;

        return table[index].tValue();
    }

    @Override
    public boolean containsKey(TKey tKey) {
        TablePair<TKey, TValue> tablePairByKey = getTablePairByKey(tKey);
        return tablePairByKey != null;
    }

    @Override
    public void remove(TKey tKey) {
        var hash = tKey.hashCode();
        var index = hash % table.length;

        table[index] = null;
    }

    private TablePair<TKey, TValue> getTablePairByKey(TKey key) {
        for (int i = 0; i < size; i++) {
            TablePair<TKey, TValue> tablePair = table[i];
            if (tablePair.tkey().equals(key)) {
                return tablePair;
            }
        }

       return null;
    }
}
