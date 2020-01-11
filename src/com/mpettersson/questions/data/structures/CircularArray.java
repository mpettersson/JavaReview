package com.mpettersson.questions.data.structures;


import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private int head = 0;
    private T[] values;

    public CircularArray(int size){
        values = (T[]) new Object[size];
    }

    public int length(){
        return values.length;
    }

    private int convert(int index){
        if(index < 0){
            // -N % M has a negative (or zero) result in java, so need to add it to values.length to get positive...
            index = (index % values.length) + values.length;
        }
        return (head + index) % values.length;
    }

    public void rotate(int rightShift){
        head = convert(rightShift);
    }

    public void set(int index, T value){
        values[convert(index)] = value;
    }

    public T get(int index){
        return values[convert(index)];
    }

    public Iterator<T> iterator(){
        return new CircularArrayIterator(this);
    }

    private class CircularArrayIterator<TI> implements Iterator<TI>{
        // _current reflects the offset from the rotated head, not from the actual start of the raw array.
        private int _current = -1;
        private TI[] _values;

        public CircularArrayIterator(CircularArray<TI> array){
            _values = array.values;
        }

        @Override
        public boolean hasNext(){
            return _current < values.length - 1;
        }

        @Override
        public TI next(){
            _current++;
            TI value = (TI) _values[convert(_current)];
            return value;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException("Remove is not supported by CircularArray");
        }
    }


}



class CircularArrayDriver{
    public static void main(String[] args) {

//        System.out.println(0 % 6);
//        System.exit(0);

        CircularArray<Integer> circularArray = new CircularArray<>(6);
        circularArray.set(0, 0);
        circularArray.set(1, 1);
        circularArray.set(2, 2);
        circularArray.set(3, 3);
        circularArray.set(4, 4);
        circularArray.set(5, 5);

        System.out.print("[");
        for(int i = 0; i < circularArray.length(); i++){
            System.out.print(" " + circularArray.get(i));
        }
        System.out.println("]");

        circularArray.rotate(-3);

        System.out.print("[");
        for(int i = 0; i < circularArray.length(); i++){
            System.out.print(" " + circularArray.get(i));
        }
        System.out.println("]");

        for(Object o : circularArray){
            System.out.println(o);
        }


    }
}