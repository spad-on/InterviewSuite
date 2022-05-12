package com.paolotalks.exercise.ds;

import java.util.Iterator;
import java.util.Objects;

public interface ILinkedHashMap extends Iterable<ILinkedHashMap.Entry> {

    static class Entry {
        private int key;
        private Integer value;

        public Entry(int key, Integer value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    void put(int key, Integer value);

    Integer get(int key);

    /**
     * Return an iterator over the entries
     * in a linked hashmap
     * @return
     */
    @Override
    Iterator<ILinkedHashMap.Entry> iterator();

    int size();
}
