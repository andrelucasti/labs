package com.andrelucas.algo.hashtable;

public class ProgEmMarteHashTable<TKey, TValue> implements HashTable<TKey, TValue>{

    private final TablePair<TKey, TValue>[] table;

    public ProgEmMarteHashTable() {
        this.table = new TablePair[10];
    }

    @Override
    public void put(TKey tKey, TValue tValue) {
        int index = createIndexBy(tKey);
        table[index] = new TablePair<>(tKey, tValue);
    }

    @Override
    public TValue get(TKey tKey) {
        int index = getIndexBy(tKey);
        while (table[index] != null) {
            if (table[index].tkey().equals(tKey)) {
                return table[index].tValue();
            }
            index = (index + 1) % table.length;
        }

        throw new RuntimeException("Key not found");
    }

    @Override
    public void remove(TKey tKey) {
        int index = getIndexBy(tKey);
        while (table[index] != null) {
            if (table[index].tkey().equals(tKey)) {
                table[index] = null;
            }
            index = (index + 1) % table.length;
        }
    }

    private int createIndexBy(TKey tKey) {
        var index = getIndexBy(tKey);

        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        return index;
    }

    private int getIndexBy(TKey tKey) {
        var hash = Math.abs(tKey.hashCode());
        return hash % table.length;
    }
}
