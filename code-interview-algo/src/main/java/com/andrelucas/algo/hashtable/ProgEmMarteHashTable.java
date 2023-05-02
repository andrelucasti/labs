package com.andrelucas.algo.hashtable;

public class ProgEmMarteHashTable<TKey, TValue> implements HashTable<TKey, TValue>{

    private final TablePair<TKey, TValue>[] table;
    private final int size;

    public ProgEmMarteHashTable() {
        this.table = new TablePair[10];
        this.size = 0;
    }

    @Override
    public void put(TKey tKey, TValue tValue) {
        var hash = Math.abs(tKey.hashCode());
        int index = generatingIndexBy(hash);

        table[index] = new TablePair<>(tKey, tValue);
    }

    private int generatingIndexBy(int hash) {
        var index = hash % table.length;

        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        return index;
    }

    @Override
    public TValue get(TKey tKey) {
        int index = calcAndGetIndexBy(tKey);
        while (table[index] != null) {
            if (table[index].tkey().equals(tKey)) {
                return table[index].tValue();
            }
            index = (index + 1) % table.length;
        }


        throw new RuntimeException("Key not found");
    }

    private int calcAndGetIndexBy(TKey tKey) {
        var hash = Math.abs(tKey.hashCode());
        return hash % table.length;
    }

    @Override
    public boolean containsKey(TKey tKey) {
        return false;
    }

    @Override
    public void remove(TKey tKey) {
        int index = calcAndGetIndexBy(tKey);
        while (table[index] != null) {
            if (table[index].tkey().equals(tKey)) {
                table[index] = null;
            }
            index = (index + 1) % table.length;
        }
    }
}
