package com.mpettersson.review.data.structures;


import java.util.ArrayList;


public class HashMap<K, V>{

    private class HashNode<K, V>{
        K key;
        V value;
        // Reference to next node
        HashNode<K, V> next;
        // Constructor
        public HashNode(K k, V v){ key = k; value = v; }
    }

    private ArrayList<HashNode<K, V>> bucketArray;  // Stores the array of chains.
    private int numBuckets;     // Current capacity of ArrayList
    private int size;           // Current size of the ArrayList

    // Constructor
    public HashMap(){
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;
        // Create empty chains
        for(int i = 0; i < numBuckets; i++){ bucketArray.add(null); }
    }

    public int size(){ return size; }
    public boolean isEmpty(){ return size == 0; }

    // This implements the hash function to find the index for a key.
    public int getBucketIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    // Method to remove a given key.
    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }

        // If key was not there:
        if(head == null){
            return null;
        }
        // Reduce size
        size--;

        // Remove Key
        if(prev != null){
            prev.next = head.next;
        }else{
            bucketArray.set(bucketIndex, head.next);
        }

        return head.value;
    }


    // Returns value for a key
    public V get(K key){
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in chain
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        // If key not found return null
        return null;
    }

    // Adds a key value pair to the hashtable
    public void add(K key, V value){
        // find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // check if key is already present (if so, update the value)
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        // insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // if load factor goes beyond threshold then double hash table size
        if((1.0 * size)/numBuckets >= .7){
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for(int i = 0; i < numBuckets; i++){
                bucketArray.add(null);
            }
            for(HashNode<K, V> headNode : temp){
                while(headNode != null){
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }




}

class HashMapDriver{
    public static void main(String[] args) {

        HashMap<String, Integer> hashMapStringInteger = new HashMap<>();
        hashMapStringInteger.add("this",1 );
        hashMapStringInteger.add("coder",2 );
        hashMapStringInteger.add("this",4 );
        hashMapStringInteger.add("hi",5 );
        System.out.println("hashMapStringInteger.size(): " + hashMapStringInteger.size());
        System.out.println(hashMapStringInteger.remove("this"));
        System.out.println(hashMapStringInteger.remove("this"));
        System.out.println("hashMapStringInteger.size(): " + hashMapStringInteger.size());
        System.out.println("hashMapStringInteger.isEmpty(): " + hashMapStringInteger.isEmpty());

    }
}
