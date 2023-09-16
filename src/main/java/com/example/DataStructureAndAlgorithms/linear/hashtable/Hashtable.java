package com.example.DataStructureAndAlgorithms.linear.hashtable;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Hashtable {
    LinkedList[] Array;
    Integer size;

    public Hashtable(Integer size) {
        this.size = size;
        this.Array = new LinkedList[size];
    }

    public Integer Index(Integer key) {
        return key % size;
    }

    public void put(Entry entry) {
        Integer index = Index(entry.getK());
        if (Array[index] == null) {
            Array[index] = new LinkedList<Entry>();
            LinkedList list = Array[index];
            list.add(entry);
        } else {
            LinkedList<Entry> list = Array[index];
            for (Entry e : list) {
                if (Objects.equals(e.getK(), entry.getK())) {
                    e.setV(entry.getV());
                    return;
                }
            }
        }

    }

    public String get(Integer key) {
        Integer index = Index(key);

        LinkedList<Entry> list = Array[index];

        for (Entry e : list) {
            if (Objects.equals(e.getK(), key)) {
                return e.getV();
            }
        }

        return null;
    }

    public void remove(Integer key) {
        Integer index = Index(key);
        LinkedList<Entry> list = Array[index];
        for (Entry e : list) {
            if (Objects.equals(e.getK(), key)) {
                list.remove(key);
            }
        }
    }


    public char findTheFirstUnRepeatedChar(String chars) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (var ch : chars.toCharArray()) {
            int count = hash.getOrDefault(ch, 0);
            hash.put(ch, count + 1);
        }

        for (var ch : chars.toCharArray()) {
            if (hash.get(ch) == 1) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedCharacter(String chars) {
        HashSet<Character> characters = new HashSet<>();
        for (var ch : chars.toCharArray()) {
            if (characters.contains(ch)) {
                return ch;
            } else {
                characters.add(ch);
            }
        }

        return Character.MIN_VALUE;
    }
}
