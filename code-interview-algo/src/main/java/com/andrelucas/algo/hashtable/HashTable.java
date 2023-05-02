package com.andrelucas.algo.hashtable;

public interface HashTable<TKey, TValue> {

    void put(TKey key, TValue value);

    TValue get(TKey key);

    void remove(TKey key);

}
