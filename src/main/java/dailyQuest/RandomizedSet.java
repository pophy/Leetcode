package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RandomizedSet {

    private int MAX_SIZE = 10000;
    private  int size = 0;
    private int[] arraySet = new int[10000];
    private Map<Integer,Integer> indexMap = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        //check if val in set
        if (indexMap.containsKey(val)) {
            return false;
        }
        arraySet[size] = val;
        indexMap.put(val,size);
        size++;
        if (size == arraySet.length) {
            doubleSetSize();
        }

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.get(val);
        //update list - copy last element in list to index location,
        size--;
        arraySet[index] = arraySet[size];
        //update indexMap
        indexMap.put(arraySet[index],index);
        indexMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = (int)(Math.random() * (size-1));
        return arraySet[randomIndex];
    }

    private void doubleSetSize() {
        MAX_SIZE = MAX_SIZE * 2;
        int[] newSet = new int[MAX_SIZE];
        for (int i = 0; i < arraySet.length; i++) {
            newSet[i] = arraySet[i];
        }
        arraySet = newSet;
    }

    @Test
    public void test() {
        RandomizedSet mySet = new RandomizedSet();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(mySet.insert(random.nextInt(1000)));
            System.out.println(mySet.remove(random.nextInt(1000)));
            System.out.println(mySet.getRandom());
        }
    }

}
