package com.mpettersson.questions.data.structures;

import java.util.LinkedList;

/**
 *  ANIMAL SHELTER QUEUE
 *
 *  An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.  People
 *  must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether
 *  they would prefer a dog or a cat (and will receive the oldest animal of that type).  They cannot select which
 *  specific animal they would like.  Create the data structures to maintain this system and implement operations
 *  such as enqueue, dequeueAny, dequeueDogs, and dequeueCats.  You may use the built-in LinkedList data ds.
 */

abstract class Animal{
    private int order;
    protected String name;
    public Animal(String n){name = n;}
    public void setOrder(int ord){order = ord;}
    public int getOrder(){return order;}

    // Compare orders of animal to return the older items
    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

class Dog extends Animal{
    public Dog(String n) {super(n);}
}

class Cat extends Animal{
    public Cat(String n) {super(n);}
}

public class AnimalShelterQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;


    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) dogs.addLast((Dog) animal);
        else if (animal instanceof Cat) cats.addLast((Cat) animal);
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0){
            return dequeueCats();
        }else if (cats.size() == 0) {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)){
            return dequeueDogs();
        }else{
            return dequeueCats();
        }
    }

    public Animal dequeueDogs(){
        return dogs.poll();
    }

    public Animal dequeueCats(){
        return cats.poll();
    }
}

class AnimalShelterQueueDriver{
    public static void main(String[] args) {
        AnimalShelterQueue shelter = new AnimalShelterQueue();

        Dog dogOne = new Dog("dogOne");
        Dog dogTwo = new Dog("dogTwo");
        Dog dogThree = new Dog("dogThree");
        Cat catOne = new Cat("catOne");
        Cat catTwo = new Cat("catTwo");
        Cat catThree = new Cat("catThree");

        shelter.enqueue(dogOne);
        shelter.enqueue(catOne);

    }
}
