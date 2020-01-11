package com.mpettersson.questions.data.structures;

import java.util.LinkedList;

public class QueueUsingLinkedList<T>{

    LinkedList<T> queue = new LinkedList<>();

    // enqueue
    public void enqueue(T value){
        this.queue.addLast(value);
    }

    // dequeue
    public T dequeue(){
        return this.queue.poll();
    }

    // length
    public int length(){
        return this.queue.size();
    }

    // isEmpty
    public boolean isEmpty(){
        return this.queue.isEmpty();
    }

    // print
    public void printQueue(){
        System.out.print("[");
        for(T value : this.queue){
            System.out.print(" " + value);
        }
        System.out.println(" ]");
    }
}

class QueueUsingLinkedListDriver{
    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println(queue.isEmpty());

    }
}