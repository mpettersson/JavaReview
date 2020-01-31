package com.mpettersson.review;



import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Java {

    // Enums
    public enum Day {Monday, Tuesday, Wednesday};


    public static void main(String[] args) {


        // Single line comment

        /**
         * Multi line comment, used by javadocs (documentation)
         */

        /*
            Multi line comment
         */

        ////////////////////////
        // NAMING CONVENTIONS //
        ////////////////////////
        /**
         *  PACKAGES
         *      - Always lowercase
         *      - Should be unique
         *      - Use your internet domain name reversed as prefix for package.
         *          - Replace invalid characters with underscore (_), i.e., experts-exchange.com --> com.experts_exchange
         *          - Domain name components starting with a number should start with an underscore (_), i.e., 1world.com --> com._1world
         *          - Domain name components that are java key words should start with an underscore (_), i.e., switch.supplier.com --> com.supplier._switch
         *
         *  CLASSES
         *      - CamelCase
         *          - Should start with a capital letter
         *          - Each word in the name should also start with a capital letter.
         *      - Should be a nouns.
         *
         *  INTERFACES
         *      - CamelCase
         *          - Should start with a capital letter.
         *          - Each word in the name should also start with a capital letter.
         *      - Can start with I (old convention)
         *
         *  METHODS
         *      - MixedCase
         *          - Should start with a lowercase letter.
         *          - Each word in the name should start with a capital letter.
         *      - Often Verbs
         *
         *  CONSTANTS
         *      - All upper case.
         *      - Separate words with an underscore (_)
         *      - Declare using the final keyword.
         *
         *  VARIABLES
         *      - MixedCase
         *          - Should start with a lowercase letter.
         *          - Each word in the name should start with a capital letter.
         *      - No underscores (_).
         *
         *  TYPE PARAMETERS
         *      - Single Capital Letter.
         *      - examples:
         *          E - Element
         *          K - Key
         *          V - Value
         *          S, U, V, etc. - 2nd, 3rd, 4th types.
         *          ? - Is the Unknown Type.
         *
         */


        ////////////////////////////
        // 8 PRIMITIVE DATA TYPES //
        ////////////////////////////

        // null is case sensitive in java, i.e., you CAN'T use NULL!
        // final variables can't be changed once initialized (can declare and define/initalize in two different lines).
        // Multiple variables of the same type can declared and assigned at once:  int a = 10, b = 11, c = 12;


        // BYTE - 8 bits
        final byte myMinByte = -128;
        byte myMaxByte = 127;
        byte byteCastExample = (byte) (myMinByte / 2);      // How to cast.

        // SHORT - 16 bits
        short myMinShort = -32768;
        short myMaxShort = 32767;

        // INT - 32 bits
        int myMinInt = -2_147_483_648;    // You can use underscores now...
        int myMaxInt = 2_147_483_647;

        // LONG - 64 bits
        long myMinLong = -9_223_372_036_854_775_808L;   // Need to put a 'L' or 'l' behind it.
        long myMaxLong = 9_223_372_036_854_775_807L;    // NOTE there isn't anything for short or byte.

        // FLOAT - 32 BITS -  7 decial digit percision
        float myFloatValue = 5F / 3f; // Should cast or use either 'F' or 'f' for float
        System.out.println("myFloatValue: " + myFloatValue);

        // DOUBLE - 64 BITS - has 16 decial digit percision
        // NOTE: USE DOUBLE OVER FLOAT, double is usually faster on modern computers and many of java's functions use it
        double myDoubleValue = 5d / 3D; // Should cast or use either 'D' or 'd' for double
        double pi = 3.141_592_7d;   // can use literals in numbers in java 7 or greater
        System.out.println("myDoubleValue: " + myDoubleValue);

        // CHAR - 16 bits, can be unicode or ASCII, remember there is only 128 ASCII...
        char myChar = '#';              // has to use single quotes.
        char copyrightChar = '\u00a9';  // can be unicode
        System.out.println("Unicode copyright char: '\\u00a9' = " + copyrightChar);
        System.out.println("ASCII to char: (char)42 = " + (char)42);
        System.out.println("Char to ASCII: (int)'*' = " + (int)'*');

        // BOOLEAN - No defined size
        boolean myBoolean = true;

        // Display common numeric types.
        System.out.println(Byte.TYPE);
        System.out.println(Byte.SIZE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);

        System.out.println(Short.TYPE);
        System.out.println(Short.SIZE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        System.out.println(Character.TYPE);
        System.out.println(Character.SIZE);
        System.out.println((int) Character.MIN_VALUE);
        System.out.println((int) Character.MAX_VALUE);

        System.out.println(Integer.TYPE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Float.TYPE);
        System.out.println(Float.SIZE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        System.out.println(Double.TYPE);
        System.out.println(Double.SIZE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println(Long.TYPE);
        System.out.println(Long.SIZE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        // Common Math Functions
        int x = 10, y = 100;
        double d = 1.0 / 3.0;
        System.out.println("Math.max(" + x + ", " + y + "): " + Math.max(x, y));
        System.out.println("Math.min(" + x + ", " + y + "): " + Math.min(x, y));
        System.out.println("Math.pow(" + x + ", " + y + "): " + Math.pow(x, y));
        System.out.println("Math.floorDiv(" + x + ", " + y + "): " + Math.floorDiv(x, y));
        System.out.println("Math.floorMod(" + x + ", " + y + "): " + Math.floorMod(x, y));
        System.out.println("Math.sqrt(" + x + "): " + Math.sqrt(x));
        System.out.println("Math.log(" + x + "): " + Math.log(x));
        System.out.println("Math.floor(" + d + "): " + Math.floor(d));
        System.out.println("Math.ceil(" + d + "): " + Math.ceil(d));
        System.out.println("Math.abs(" + x + "): " + Math.abs(x));
        System.out.println("Math.random():" + Math.random());  // Returns double >= 0.0 and < 1.0

        // How to get random values:
        System.out.println("Math.random():" + Math.random());  // Returns double >= 0.0 and < 1.0

        int bound = 10;
        int seed = 100;
        byte[] bytes = new byte[10];
        Random random = new Random();

        random.nextInt();  // Returns int >= Integer.MIN_VALUE and <= Integer.MAX_VALUE
        random.nextInt(bound);  // Returns int >=0 < bound, ONLY int can have bound.
        random.nextDouble();  // Returns double >= 0.0 and < 1.0
        random.nextBytes(bytes);  // Puts random bytes into each index of supplied array.
        random.nextBoolean();
        random.setSeed(seed);
        System.out.println("random.nextInt(): " + random.nextInt());
        System.out.println("random.nextInt(" + bound + "): " + random.nextInt(bound));
        System.out.println("random.nextDouble(): " + random.nextDouble());
        System.out.println("random.nextBytes(bytes): " + Arrays.toString(bytes));
        System.out.println("random.nextBoolean(): " + random.nextBoolean());
        System.out.println("random.setSeed(" + seed + ")");


        // COMPARETO
        //
        // NOTE: The object type must extend Comparable, i.e., class MyObject<T extends Comparable>
        //       Can't be primitive types (so use Integer for int, Double for double, etc...)
        //
        // Usage:
        //      myObjectLeft<T>.compareTo(myObjectRight<T>)
        //
        // Results:
        //      0 if myObjectLeft == myObjectRight
        //     -1 if myObjectLeft < myObjectRight   (it's -1 no matter size i.e., 1 < 2 or 1 < 2222)
        //      1 if myObjectLeft > myObjectRight   (it's 1 no matter size i.e., 2 > 1 or 2222 > 1)
        Integer one = 1;
        Integer negOne = -1;
        Integer six = 6;
        System.out.println(one + ".compareTo(" + one + ")" + one.compareTo(one));       // 1.compareTo(1)  == 0 (1 == 1)
        System.out.println(one + ".compareTo(" + six + ")" + one.compareTo(six));       // 1.compareTo(6) == -1 (1 < 6)
        System.out.println(six + ".compareTo(" + one + ")" + six.compareTo(one));       // 6.compareTo(1)  == 1 (6 > 1)
        System.out.println(one + ".compareTo(" + negOne + ")" + six.compareTo(negOne)); // 6.compareTo(-1) == 1 (6 > -1)


        /////////////
        // STRINGS //
        /////////////

        // Strings are a class/Object and not a primitive type.

        String myString = "This is my string!";
        String strHello = "Hello";
        String strWorld = "World";

        // Concat with
        System.out.println(strHello + strWorld);        // This will automatically convert to string
        System.out.println(strHello.concat(strWorld));  // This WILL NOT automatically convert to string!!!

        // NOTE: You can assign null to a string, BUT, it'll cause exceptions with many of the common string ops.
        String nullString = null;
        System.out.println(nullString);

        String emptyString = "";

        // Find string length with <stringVar>.length();
        System.out.println("emptyString.length() = " + emptyString.length());

        // Find if string is empty (i.e., length == 0) with <stringVar>.isEmpty();
        System.out.println("emptyString.isEmpty() = " + emptyString.isEmpty());


        String example = "This should be complicated enough to show some things we should show";

        // Find the characters at the indexes given
        System.out.println(example.charAt(0));
        System.out.println(example.charAt(5));

        // An StringIndexOutOfBoundsException is thrown in both these cases:
        // System.out.println(example.charAt(-1));
        // System.out.println(example.charAt(200));

        // Find the index of characters or substrings
        System.out.println(example.indexOf('s'));                         // returns the first occurence of 's'
        System.out.println(example.indexOf('s', 4));        // the first 's' after index 4
        System.out.println(example.indexOf("should"));                    // the index of the first "should" in our string
        System.out.println(example.indexOf("should", 15));  // the index of the first "should" in our

        // Find the last index of characters or substrings
        System.out.println(example.lastIndexOf('s'));                    // returns the first occurence of 's' when we look backwards from the end of the string
        System.out.println(example.lastIndexOf('s', 45));      // searches for 's' backwards from the position 45
        System.out.println(example.lastIndexOf("should"));               // returns the position at which the substring 'should' appears, looking backwards from the end of the string
        System.out.println(example.lastIndexOf("should", 20)); // finds substring 'should' from position 20 backwards, and returns the position at which it begins

        // The compareTo() method compares the Unicode value of two strings and returns a NUMBER.
        System.out.println("a".compareTo("a"));
        System.out.println("a".compareTo("b"));
        System.out.println("1".compareTo("12345678"));

        // Get substrings with substring() method.
        System.out.println(example.substring(2));
        System.out.println(example.substring(5,11));

        // Trim off the leading and trailing whitespace with .trim()
        String ourString = "      Any non-leading and non-trailing whitespace is  \n  preserved       ";
        System.out.println(ourString.trim());


        // Printf: formatted output
        // %s   : strings
        // %d   : Integers
        // %f   : Floats/Doubles
        // %c   : Characters
        // %e   : Scientific Notation
        // %t   : Dates
        // %b   : Booleans
        // %o   : Octal
        // %h   : Hex

        // The format syntax is:    %[argument_index$][flags][width][.precision]conversion

        double ourDouble = 1123.9303;
        System.out.println(String.format("%f", ourDouble));
        System.out.println(String.format("%.3f", ourDouble)); // specifies that we only want 3 digits after decimal point
        System.out.println(String.format("%e", ourDouble));

        String formatString  = "what does precision do with strings?";
        System.out.println(String.format("%.8s", formatString)); // prints the first 8 characters of our string

        int ourInt = 123456789;
        // System.out.println(String.format("%.4d", ourInt)); // precision can't be used on ints

        // If our number has less than 6 digits, this will add extra 0s to the beginning until it does
        System.out.println(String.format("%06d", 12));

        // If our number has more than 6 digits, it will just print it out
        System.out.println(String.format("%06d", 1234567));

        // We can specify output width, with the output being aligned to the right if it's shorter than the given space. If it's
        // longer, everything gets printed. The || are added for demonstration purposes only
        System.out.println(String.format("|%20d|", 12));
        // Or we can align the output to the left
        System.out.println(String.format("|%-20d|", 12));

        // We can also easily print an octal/hexadecimal value of an integer
        System.out.println(String.format("Octal: %o, Hex: %x", 10, 10));

        String replaceString = "We really don't like the letter e here";

        System.out.println(replaceString.replace('e', 'a'));
        System.out.println(replaceString.replace("here", "there"));
        System.out.println(replaceString.replaceAll("e(r+)", "a"));
        System.out.println(replaceString.replaceFirst("e(r+)", "a"));


        // How to split a string using regex:
        String[] fruits = "apples, oranges, pears, pineapples".split(",");

        System.out.println(Arrays.toString(fruits));

        // Using trim() to clean up some of the items.
        for(int i = 0; i < fruits.length; i++) {
            fruits[i] = fruits[i].trim();
        }

        System.out.println(Arrays.toString(fruits)); // Arrays.toString() formats the output array on its own

        // This returns then prints an empty array, since every character is interpreted as something to be split at and ignored
        System.out.println(Arrays.toString("apples.oranges.pears.pineapples".split(".")));

        // The "regex safe" way of doing this would be
        System.out.println(Arrays.toString("apples.oranges.pears.pineapples".split(Pattern.quote("."))));

        // Splits our string to two substrings at most, completely ignoring all other occurrences of "."
        System.out.println(Arrays.toString("apples.oranges.pears.pineapples".split(Pattern.quote("."), 2)));


        // examples of String.join()
        String arrayOfStrings[] = {"1","2","3","4","5"};
        System.out.println(String.join("-", arrayOfStrings));
        System.out.println(String.join("-", Arrays.asList(arrayOfStrings))); // Works just fine with lists as well
        System.out.println(String.join("", arrayOfStrings));


        // How to convert a string to a char aray:
        System.out.println(Arrays.toString("How to convert a string to a Char Array".toCharArray()));

        // SORT STRING - No method to sort a string, but can do this:
        String stringToSort = "Hahaha, Sort ME!";
        char[] chars = stringToSort.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        System.out.println(sortedString);


        // How to remove all whitespaces (and newlines) from a string:
        String strWithWhiteSpaces = "  S\ttring  wit h      white spa\n c e s !!!  ";
        System.out.println(strWithWhiteSpaces);
        System.out.println(strWithWhiteSpaces.replaceAll("\\s+", ""));


        //////////////////////////////////
        // STRINGBUILDER & STRINGBUFFER //
        //////////////////////////////////

        // StringBuffer - First, Thread Safe/Synchronized
        // StringBuilder - Second, NOT Thread Safe, Several times FASTER

        StringBuilder strBuilder = new StringBuilder("A Random Value");

        // How to check the current capacity
        System.out.println(strBuilder.capacity());
        // Get the length of the used string with .length()
        System.out.println(strBuilder.length());
        // Append
        // NOTE: It will automatically add to the capacity if needed.
        System.out.println(strBuilder.append(" Again And Again And Again And Again And Again And Again And Again"));
        // Replace
        System.out.println(strBuilder.replace(2, 7,"NONRANDOM"));
        // Delete:
        System.out.println(strBuilder.delete(15, 21));
        // Insert:
        System.out.println(strBuilder.insert(30, "String To Insert"));
        // Print:
        System.out.println(strBuilder);
        // Use this to assign to a string
        System.out.println(strBuilder.toString());


        ///////////
        // INPUT //
        ///////////

//        // Scanner Example:
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter name: ");
//        if(sc.hasNextLine()){
//            String userName = sc.nextLine();
//            System.out.println("Hello " + userName);
//        }
//
//        // Scanner Example with different types:
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your name: ");
//        String name = scanner.nextLine();
//        System.out.println("Your name is: " + name);
//        System.out.println("Enter your year of birth: ");
//        int year = scanner.nextInt();
//        NOTE YOU HAVE TO CALL scanner.nextLine() to handle the newline (enter) if you want to do nextLine() for a string.
//        scanner.nextLine();
//        System.out.println("Your age is: " + (2018 - year));
//        scanner.close();
//
//        // JOPtion Pane Dialog Box Example:
//        String jopName = JOptionPane.showInputDialog("Enter name");
//        System.out.println("Hello " + jopName);


        /////////////////////////////
        // CONTROL FLOW STATEMENTS //
        /////////////////////////////

        int someVar = 4;
        // Remember that assignment returns the value assigned, so it has some weird cases...
        if((someVar = 10) == 10){
            System.out.println("what");
        }

        boolean blah;

        if(blah = true){
            System.out.println("this is the 'if' with an assignment.");
        }

        // NOTE: Unlike other languages (python, C/C++, etc.) numbers cannot be used in place of booleans.
        // The following (commented out code), has an error ('Incompatible Types'):
        // if(1){ System.out.println("True"); }

        // Whitespace and indenting stuff...
        int anothervar=5;
        System.out.println(anothervar);

        int
                anotherMessedUp
                =
                5
                ;
        System.out.println(anotherMessedUp);


        String mySwitchString = "matt";
        switch(mySwitchString){
            case "matt":
                System.out.println("input was matt");
                break;
            case "no":
                System.out.println("input was no");
                break;
            default:
                System.out.println("blah");
        }

        // Can use byte, short, char, int, and Strings with switch statements.
        int switchValue = 1;

        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break;

            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5: // How to have multiple values in a case.
                System.out.println("Value was 3, 4, or 5.");

            default:
                System.out.println("In default case...");
                break; // Don't really need a break here, but it's probably good to add it.
        }


        int count = 1;
        while(count != 6){
            System.out.println("count value is " + count);
            count++;
        }

        for(int i = 6; i !=6; i++){
            System.out.println("count value is " + count);
        }

        count = 1;
        do{
            System.out.println("count value is " + count);

            if(count > 100){
                break;
            }
            count++;
        }while(count != 6);


        String numberAsString = "2018";

        int intNumber = Integer.parseInt(numberAsString);
        double doubleNumber = Double.parseDouble(numberAsString);
        System.out.printf("This is the value for intNumber: %d and this is the value for doubleNumber: %f.\n", intNumber, doubleNumber);


        ////////////
        // ARRAYS //
        ////////////

        //For primitive types:

        int[] myIntArray1 = new int[3];
        int[] myIntArray2 = {1, 2, 3};
        int[] myIntArray3 = new int[]{1, 2, 3};

        //For classes, for example String, it's the same:
        String[] myStringArray1 = new String[3];
        String[] myStringArray2 = {"a", "b", "c"};
        String[] myStringArray3 = new String[]{"a", "b", "c"};


        //The third way of initializing is useful when you declare the array first and then initialize it. The cast is necessary here.
        String[] myStringArray4;
        myStringArray4 = new String[]{"a", "b", "c"};

        // Multidimentional
        int[][] multiDimArray = {{1,2}, {1,2}, {1,2}, {1,2}, {1,2}};


        // How to copy arrays:
        // NOTE: Anything other than primitive data types will have shallow copies.
        int a1[] = {1,2,3};
        int a2[] = Arrays.copyOf(a1, 3);
        System.out.println(a2[0] + " " + a2[1] + " " + a2[2]);

        // How to sort an Array:
        int a3[] = {8, 7, 5, 2, 1};
        Arrays.sort(a3);

        // How to print an Array:
        System.out.println(Arrays.toString(a3));


        ////////////////////////////
        // COLLECTION (INTERFACE) //
        ////////////////////////////

        // A collection represents a group of objects, known as its elements. The Collection interface is the root
        // interface in the collection hierarchy, that is, List Set and Queue interfaces extend the Collection interface.
        // Although the Map interface does not extend/implement the Collection interface (because Map hash key value
        // paris), it is considered part of the Collections Framework.
        //
        // The Collection interface is in the java.util package, some of it's more important methods include size(),
        // isEmpty(), contains(),  iterator(), toArray(), add(E e) , remove(), clear(), equals(), and hashCode().
        //
        // The four major data structure types in the Collections Framework are List, Set, Queue, and Map.
        //
        // LIST
        // Lists are ordered collections (sequences) of items that are accessed via an integer index, and typically
        // allow duplicate values.  The following are implemented List classes:
        //      Vector - Synchronized, growable array of objects accessed via an int index.
        //      Stack - Synchronized, Last-In-First-Out (LIFO) stack of objects (extends Vector).
        //      ArrayList - NOT synchronized, resizeable array implementation of List, allows nulls.
        //      LinkedList - NOT synchronized, doubly-linked list implementation (extends AbstractSequentialList).
        //
        // SET
        // Sets are collections that do not allow duplicate elements, and model the mathematical set abstraction.  The
        // following are implemented Set classes:
        //      HashSet - NOT synchronized, Set implementation by HashMap, allows one null, NOT ordered.
        //      LinkedHashSet - NOT synchronized, Hashtable & LinkedList imp of Set, ordered via doubly-linked list.
        //      TreeSet - Not synchronized, NavigableSet implementation based on HashMap, allows one null, NOT ordered.
        //
        // QUEUE
        // Queues are "a collection designed for holding elements prior to processing".  Queues typically, but do not
        // necessarily, order elements in a FIFO (first-in-first-out) manner.  Among the exceptions are priority queues,
        // which order elements according to a supplied comparator, or the elements' natural ordering, and LIFO queues
        // (or stacks) which order the elements LIFO (last-in-first-out).  The implemented Queue classes are:
        //      ArrayDequeue - NOT synchronized, resizable-array imp of the Deque interface, nulls NOT allowed.
        //      PriorityQueue - NOT synchronized, unbounded priority queue (First-In-First-Out) based on a priority heap.
        //      NOTE: LinkedList implements Dequeue.
        //
        // MAP
        // A Map is an object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most
        // one value.  The Map interface is interesting in that it does not implement or extend any other class.
        // Implemented Map classes include:
        //      HashMap - NOT synchronized, Hashtable based imp of Map, allows null vals and 1 null key, no order guarantees.
        //      Hashtable - Synchronized, Hashtable imp of Map, null NOT allowed, NOT ordered.
        //      TreeMap - NOT synchronized, Red-Black tree based NavigableMap imp; (ordered) SORTED by keys.
        //      LinkedHashMap - NOT synchronized, HashTable & LinkedList imp of the Map interface, ordered via dlinkedlist.
        //      IdentityHashMap - NOT synchronized, HashTable based Map imp using reference-equality when comparing keys.
        //
        // To iterate over a collection, without modifying it, use the for-each loop (for(Element e: collection)...).
        // To iterate over and access collection elements use; Enumeration, Iterator, and ListIterator.
        //
        // ENUMERATION
        // The Enumeration Interface was the first iterator, present in JDK 1.0, and only works on legacy collections
        // (Vector and Hashtable).  Only three methods were provided; hasMoreElements(), nextElement(), and asIterator().
        // It can only iterate in a forward direction (and can't Remove/Add/Set elements).
        //
        // ITERATOR
        // Added in Java 1.2, "Iterator takes the place of Enumeration in the Java Collections Framework". Iterators can
        // read and remove elements on ALL Collection objects.  Iterator methods include: hasNext(), next(), remove, and
        // forEachRemaining().
        //
        // LISTITERATOR
        // ListIterator extends Iterator, is ONLY available to lists (only AbstractList implements it), allows for
        // Bi-Directional movement, and can add/remove/set elements.  ListIterator has hasNext(), next(), hasPrevious(),
        // previous(), nextIndex(), previousIndex(), remove(), set(E e) and add(E e) methods.
        //
        // NOTE: ListIterator has no "current" element, that it always lies between the element that would be returned
        // by a previous() call and the element that would be returned by a next() call, furthermore, the remove() and
        // set(E e) methods act on the last element returned by next()/previous().


        ///////////////
        // ARRAYLIST //
        ///////////////

        // NOTE: You have to use Uppercase Integer here BC it needs classes not primitives.
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4));

        // Then autoboxing will be used to get the contents.
        arrayList.add(Integer.valueOf(1));
        arrayList.add(1);  // Same as above BC autoboxing
        System.out.println(arrayList.get(0).intValue());
        System.out.println(arrayList.get(0));   // Same as above BC autoboxing


        // Iterate with an Enhaned For
        for(Integer i: arrayList){
            System.out.print(i);
        }

        // Iterate Using an ITERATOR
        Iterator it = arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // Size
        System.out.println("Size: " + arrayList.size());
        // Overwrite at an index:
        arrayList.set(0, 0);
        // Remove at an index
        arrayList.remove(0);
        // Contains
        System.out.println(arrayList.contains(4));
        // Clear everything
        arrayList.clear();
        // isEmpty
        System.out.println(arrayList.isEmpty());


        ArrayList<String> arrayListExample = new ArrayList<>();
        arrayListExample.add("some string");
        for(int i = 0; i < arrayListExample.size(); i++){
            System.out.println(arrayListExample.get(i));
        }

        boolean arrayListContainsExample = arrayListExample.contains("some string");
        int arrayListIndexOfExample = arrayListExample.indexOf("some string");



        ////////////////
        // LINKEDLIST //
        ////////////////


        // LINKED LIST
        LinkedList<Integer> iL1 = new LinkedList<>();

        // Add to Linked List
        iL1.add(1);
        iL1.add(2);
        iL1.add(3);


        // Add a list of things to a Linked List:
        iL1.addAll(Arrays.asList(5,6,7,8));

        // Add to the beginning of a Linked List:
        iL1.addFirst(0);

        // Add to the end of a Linked List:
        iL1.addLast(99);

        // Replace index
        iL1.set(0, 42);

        // TestClass if the Linked List contains a value:
        boolean result = iL1.contains(4);
        System.out.println(result);

        // Get the index of a value in a Linked List:
        int index = iL1.indexOf(4);
        System.out.println(index);

        // How to get items from a Linked List:
        iL1.get(0);
        iL1.getFirst();
        iL1.getLast();

        // How to remove items from a linked list:
//        iL1.remove(0);
//        iL1.removeFirst();
//        iL1.removeFirstOccurrence(0);
//        iL1.removeLast();
//        iL1.removeLastOccurrence(0);

        // How to get the size of a linked list:
        System.out.println(
                iL1.size()
        );

        // How to convert a Linked List to an Array:
        Object[] llObj = iL1.toArray();

        for(Integer i: iL1){
            System.out.print(i);
        }
        System.out.println();


        LinkedList<String> linkedListExample = new LinkedList<String>();
        linkedListExample.add("Hello");
        linkedListExample.add("World");
        linkedListExample.add("That");
        linkedListExample.add("Is");
        linkedListExample.add("All");
        linkedListExample.add(1, "What?");

        Iterator<String> strIter = linkedListExample.iterator();

        while(strIter.hasNext()){
            System.out.println(strIter.next());
        }


        /////////////////////////
        // HASHMAP & HASHTABLE //
        /////////////////////////

        // HashMap ISN'T thread safe and allows ONE null key value.
        // Hashtable IS thread safe, just use synchronized blocks, but DOESNOT allow any null key values.
        // Another threadsafe possiblitiy is Collections.synchronizedMap:
        // Exmaple: Map<String, Integer> syncHashMap = Collections.synchronizedMap(new HashMap<>());

        Map<String, Integer> hash = new HashMap<>();

        // Adding key-value pairs to a HashMap
        hash.put("One", 1);
        hash.put("Two", 2);
        hash.put("Three", 3);
        hash.put("Five", 5);
        hash.put("Six", 6);

        // Add a new key-value pair only if the key does not exist in the HashMap, or is mapped to `null`
        hash.putIfAbsent("Four", 8);
        // put() - How to modify a value.
        hash.put("Four", 4);
        // get()
        System.out.println("hash.get(\"Four\"): " + hash.get("Four"));
        // isEmpty()
        System.out.println("hash.isEmpty(): " + hash.isEmpty());
        // size()
        System.out.println("hash.size(): " + hash.size());
        // containsKey()
        System.out.println("hash.containsKey(\"One\"): " + hash.containsKey("One"));
        // containsValue()
        System.out.println("hash.containsValue(1): " + hash.containsValue(1));
        // remove(Key) - One arg
        System.out.println("hash.remove(\"Six\"): " + hash.remove("Six"));
        // remove(Key, Value) - Only removes if the Key is mapped to the Value, returns true or false.
        System.out.println("hash.remove(\"Five\", 5): " + hash.remove("Five", 5));
        // remove(<NonExistantKey>) returns null
        System.out.println("hash.remove(\"Nine\"): " + hash.remove("Nine"));


        Set<Map.Entry<String, Integer>> keysAndValueSet = hash.entrySet();
        System.out.println("hash.entrySet(): " + keysAndValueSet);

        // keySet()
        Set<String> keySet = hash.keySet();
        System.out.println("hash.keySet(): " + keySet);

        // values()
        Collection<Integer> valueSet = hash.values();
        System.out.println("hash.values(): " + valueSet);


        // Iterating using Java 8 forEach and lambda
        System.out.print("Iterate with forEach and lambda: ");
        hash.forEach((key, value) -> {
            System.out.print(key + "=>" + value + ", ");
        });

        // Iterating with entrySet using iterator()
        System.out.print("\nIterate with entrySet and iterator(): ");
        Set<Map.Entry<String, Integer>> hashMapEntries = hash.entrySet();
        Iterator<Map.Entry<String, Integer>> hashMapIterator = hashMapEntries.iterator();
        while (hashMapIterator.hasNext()) {
            Map.Entry<String, Integer> entry = hashMapIterator.next();
            System.out.print(entry.getKey() + "=>" + entry.getValue() + ", ");
        }

        // Iterating with entrySet using Java 8 forEach and lambda
        System.out.print("\nIterate with entrySety(), forEach, and lambda: ");
        hash.entrySet().forEach(entry -> {
            System.out.print(entry.getKey() + "=>" + entry.getValue() + ", ");
        });

        // Iterating with entrySet using simple for-each loop
        System.out.print("\nIterate with entrySet() and for-each loop: ");
        for(Map.Entry<String, Integer> entry: hash.entrySet()) {
            System.out.print(entry.getKey() + "=>" + entry.getValue() + ", ");
        }

        // Iterating with keySet
        System.out.print("\nIterate with keySet(): ");
        hash.keySet().forEach(key -> {
            System.out.print(key + "=>" + hash.get(key) + ", ");
        });

        System.out.println();


        ///////////
        // STACK //
        ///////////

        Stack<Integer> stackVar = new Stack<>();

        // PUSH a value onto the stack:
        for(int i = 0; i < 5; i++) {
            stackVar.push(i);
        }

        // SIZE of a stack:
        System.out.println("Get the size of a stack with stackVar.size(): " + stackVar.size());

        // POP a value off the stack:
        System.out.println("Pop a value off a stack with stackVar.pop(): " + stackVar.pop());

        // SEARCH a stack for a value:
        System.out.println("Search a stack with stackVar.search(2): " + stackVar.search(2));

        // PEEK at the next item on a stack (won't take it off/pop it)
        System.out.println("Peek or Look at the next item on a stack with stackVar.peek(): " + stackVar.peek());

        // Check if a stack is EMPTY
        System.out.println("Check if a stack is empty with stackVar.empty(): " + stackVar.empty());


        ////////////////
        // EXCEPTIONS //
        ////////////////

        // All exceptions are subclasses of Exception and RuntimeException

        try{
            int badInt = 10/0;
        }catch (ArithmeticException ex){
            System.out.println("Can't divide by zero");
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        } catch( NullPointerException | ArrayIndexOutOfBoundsException e) { // Catch two exceptions in one catch block
            System.out.println(e.getMessage());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Clean up here, Close DBs, Etc...");
        }


        // THROW A CUSTOM EXCEPTION
        try{
            throw new Exception("BAD STUFF");
        }catch (ArithmeticException ex){
            System.out.println("Can't divide by zero");
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Clean up here, Close DBs, Etc...");
        }


        ///////////
        // FILES //
        ///////////

        // How to CREATE and RENAME a file:
        File f1 = new File("f1.log");
        File f1NewName = new File("F1BU.log");
        try{
            if(f1.createNewFile()){
                System.out.println("File created");
                f1.renameTo(f1NewName);
                // NOTE: Delete DOES NOT work if you changed the name of the file:
                f1.delete();
            }else{
                System.out.println("File not created");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // How to WRITE to a File:
        File f2 = new File("f2.txt");
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f2)));
            pw.println("This is sample text");
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        // How to READ from a File:
        f2 = new File("f2.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(f2));
            String text = br.readLine();
            while(text != null){
                System.out.println(text);
                text = br.readLine();
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        // How to write BINARY DATA:
        File f3 = new File("f3.dat");
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(f3);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            // NOTE: To write primitives you need DataOutputStream
            DataOutputStream dos = new DataOutputStream(bos);
            String name = "Matt";
            int age = 37;
            double bal = 1234.56;

            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeDouble(bal);
            dos.close();
        } catch (IOException e){
            e.printStackTrace();
        }


        // How to READ BINARY files
        f3 = new File("f3.dat");
        FileInputStream fis;
        try{
            fis = new FileInputStream(f3);
            BufferedInputStream bis = new BufferedInputStream(fis);

            DataInputStream dis = new DataInputStream(bis);
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            fis.close();

        } catch (IOException e){
            e.printStackTrace();
        }


        // How to get the Absolute and Canonical PATHS of FILES.
        try {
            System.out.println("Absolute Path: " + f3.getAbsolutePath());
            System.out.println("Canonical Path: " + f3.getCanonicalPath());
            System.out.println("Path: " + f3.getPath());
        }catch(IOException e){
            e.printStackTrace();
        }

        // How to get the PATH of the current working DIR:
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        // How to READ files from a DIRECTORY:
        File d1 = new File(s);
        System.out.print(s + ": ");
        if(d1.isDirectory()){
            File[] files = d1.listFiles();
            for(File f : files) System.out.print(f.getName() + " ");
        }
        System.out.println();


        // Check if a DELETE worked using java.io.File.delete()
        if(f1NewName.delete()) {
            System.out.println("File " + f1NewName.getName() + " deleted successfully");
        } else {
            System.out.println("Failed to delete the file " + f1NewName.getName() + ".");
        }

        // How to DELETE if a file exists using java.nio.file.files.deleteifexists(Path p):
        try {
            Files.deleteIfExists(Paths.get(f2.getAbsolutePath()));
            Files.deleteIfExists(Paths.get(f3.getAbsolutePath()));
        } catch(NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch(DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        } catch(IOException e) {
            System.out.println("Invalid permissions.");
        }



        /////////////
        // CLASSES //
        /////////////

        // INTERFACE VS EXTENDS
        //    If the end class "IS" something (but WITHOUT additional functionality) then use EXTENDS
        //    If the end class "CAN" do something (but HAS additional functionality) then use INTERFACE.
        //    Interfaces are more flexible than abstract classes, abstracting the 'what' from the 'how'.
        //    Use interfaces on UNRELATED classes.


        // COMPOSITION VS INHERITANCE
        //    Composition (HAS A relation) is accomplished by including an INSTANCE of another class as a FIELD of your class
        //    Inheritance (IS A relation) is accomplished by by EXTENDING another class in your class

        // MISC. CLASS STUFF
        //    super. - used to access/call the parent class members.
        //    super() - Only way to call parent constructor, must be first statement in constructor.
        //    this. - used to call the current class members (fields and methods), can't use in static context.
        //    this() - Only way to call a constructor (used for CONSTRUCTOR CHAINING). Must be first statement.
        //    Constructor can't have call to both super() and this().
        //    If a class is final or has a private constructor it can't be subclassed.


        // 4 TYPES OF NESTED CLASS
        //    static nested class
        //    non-static nested class (inner class)
        //    local class (inner class in a scope block/method) -- not used too often, in theory would help with encapsulation.
        //    anonymous nested class (no class name) -- used only once, used alot with attaching event handlers to buttons (for example, in android apps).



        // How to instantiate classes.
        Rectangle rectangle = new Rectangle(0,0, true, 10, 10);
        Circle circle = new Circle(0, 0 , true, 1);

        // How to determine if something is an instance of a specific class:
        if(rectangle instanceof Rectangle){
            System.out.println("(rectangle instanceof Rectangle) :" + (rectangle instanceof Rectangle));
        }


        SerializationReview.examples();
        LambdaReview.examples();
        StreamReview.examples();
        ConcurrentReview.examples();
        GCReview.examples();

        // How to exit; this terminates the currently running Java Virtual Machine. The argument serves as a status
        // code; by convention, a nonzero status code indicates abnormal termination.
        System.exit(0);

    } // END OF MAIN
}


//////////////////////
// ABSTRACT CLASSES //
//////////////////////

abstract class AbstractClassEmpty {
}

// CAN EXTENDS or IMPLEMENT in an abstract class.
abstract class AbstractClass extends AbstractClassEmpty implements InterfaceClassEmpty {

    // Can have member variables that are inherited (can't in interface unless static).
    private String name;

    // Can have a constructor (interfaces can't)
    public AbstractClass(String name){
        this.name = name;
    }

    // Can have non-abstract methods (that have bodies) in an abstract class
    public String getName() {
        return name;
    }

    // Remember that any class that implements (extends) this class must implement ALL of the things defined in this,
    // Where if they extended a base class, they can choose what they want to implement.

    // Only methods (and class) are allowed to be abstract.
    // Methods that are abstract don't have bodies (but you can have non-abstract methods that must have bodies in an abstract class).
    public abstract void doSomething();
    public abstract void doSomethingElse(int someInt);
}


////////////////
// INTERFACES //
////////////////

interface InterfaceClassEmpty {
}

// An interface can ONLY extend an interface (can't implement an interface, can't extend an abstract class).
interface InterfaceClass extends InterfaceClassEmpty{

    // Can ONLY have public static variables.
    public static String staticString = "Only static variables are allowed.";
    public static final int STATIC_INT = 838;

    // Can ONLY have public methods (no private or protected).
    public void interfaceMethod();
    public boolean interfaceMethodWithArg(int i);

    // SINCE JAVA 8, Interfaces can contain default methods (with implementation).
    default void defaultMethod(int defaultArg){
        System.out.println("Can actually implement something (have a body of a method in an Interface).");
    }

    // SINCE JAVA 9, Interfaces can have private methods.
    //private void privateMethod();
}




class Shape{
    // STATIC MEMBER VARIABLE
    //   SHARED by all instances of the class. i.e., scanners or loggers.
    private static int numberOfShapes = 0;

    // Instance Variables aka Fields aka Member Variables.
    private double xLocation;
    private double yLocation;
    private boolean visible;

    // Constructor
    public Shape(double xLocation, double yLocation, boolean visible){
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.visible = visible;
        numberOfShapes++;
    }

    // INSTANCE METHOD
    //   This method is created when the class is instantiated with the "new" keyword.
    public void instanceMethod(){

    }

    // STATIC METHODS
    //   CAN'T access instance methods and instance variables directly (NO this.<whatev>..).
    //   Are not made when class is instantiated.
    public static void staticMethod(){
    }

    // MULTIPLE METHOD ARGS
    public static void multipleArgsMethod(int ... vals){
        for(int x : vals){
            // Do something...
        }
    }

    // See child class for Method Overriding.
    public void methodOverridingExample(){
    }

    // Deprecated!
    // A method called before object is garbage collected (Not a destructor, but often compared to a destructor).
    // Only use for logging.
    public void finalize(){
    }
}

// EXTENDS SHAPE
class Rectangle extends Shape{
    private double width;
    private double heigth;

    // CONSTRUCTOR CHAINING
    public Rectangle(double x, double y, boolean visible){
        this(x, y, visible, 0, 0);
    }

    public Rectangle(double xLocation, double yLocation, boolean visible, double width, double heigth){
        super(xLocation, yLocation, visible);
        this.width = width;
        this.heigth = heigth;
    }

    // METHOD OVERLOADING
    //   Must have same name, must have different parameters, CAN have different return types, CAN have different
    //   modifiers, CAN throw different checked or unchecked exceptions.
    public void methodOverloadExample(){

    }
    private boolean methodOverloadExample(int x){
        return true;
    }

    // METHOD OVERRIDING
    //   JVM will determine what method will be called at RUNTIME.  SHOULD (but don't have to) annotate with @Override.
    //   CAN'T override static methods (only instance methods).
    //   Only inherited methods can be overridden, constructors and private and final methods CAN'T be overridden.
    //   Use: super.methodName() to call the superclass version of an overridden method.
    //   MUST have same name and args, return type CAN be a subclass of the return type in the parent class,
    //   it CAN'T have a lower access modifier (if parent is protected then private child ISN'T allowed, can be public)
    @Override
    public void methodOverridingExample(){
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(double x, double y, boolean visible, double radius){
        super(x, y, visible);
        this.radius = radius;
    }
}

//////////////
// GENERICS //
//////////////

// Added to Java5

// class
class ClassWithGenerics<T extends Comparable>{

    T val;

    public void setVal(T val){
        this.val = val;
    }

    // NOTE: If you have a static class, you must put the type in angle brackets behind the static keyword.
    // Example:  public static<T extends Comparable> void mergeSort(T[] arr){ ... }

    public T getVal(){
        return val;
    }

    public void usingRawAndGenerics() {
        // Raw type, have to typecast when reference, so prone to run time errors.
        ArrayList rawTypesList = new ArrayList();
        rawTypesList.add(1);
        rawTypesList.add("hi");
        rawTypesList.add(1.2);

        // Using Generics
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(144);
    }

    // How to print amy type of object in an ArrayList with <?>
    public static void printArrayList(ArrayList<?> aL){
        for(Object x : aL) System.out.println(x);
    }
}


////////////////
// COMPARATOR //
////////////////

// Comparator interface is used to order the objects of user-defined classes.
// A comparator object is capable of comparing two objects of two different classes.

// Usage Example:
//        String[] stringArray = new String[]{"they", "fun", "race", "fights", "care", "listens", "silent", "acre"};
//        Arrays.sort(stringArray, new AnagramComparator());

// This example would sort each string in a string array so that anagrams would be ordered next to each other.
class AnagramComparator implements Comparator<String>{
    public String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // Must implement compare when implementing Comparator.
    public int compare(String s1, String s2){
        return sortChars(s1).compareTo(sortChars(s2));
    }

    // How to implement a Comparator as an Anonymous Class (Say if you wanted to do this in main()):
    public void howToImplementComparatorViaAnonymousClass(){
        String[] stringArray = new String[]{"they", "fun", "race", "fights", "care", "listens", "silent", "acre"};
        Arrays.sort(stringArray, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char[] content1 = s1.toCharArray();
                Arrays.sort(content1);
                char[] content2 = s2.toCharArray();
                Arrays.sort(content2);
                return (new String(content1)).compareTo(new String(content2));
            }
        });
    }
}


///////////////////////////////////////////////////
// SERIALIZATION (SERIALIZABLE & EXTERNALIZABLE) //
///////////////////////////////////////////////////

// Serialization, in Java, is the process which is used to serialize object in java by storing object’s state into a
// file and recreating object's state from that file (the reverse process is called deserialization).  The file (byte
// stream) created is platform independent, therefore, an object serialized on one platform can be deserialized on a
// different platform.  This is useful for network communication and to save objects states.
//
// NOTE: Any object being serialized (from an serialized object) MUST ALSO be serialized or a
// java.io.NotSerializableException will be thrown.
//
// The Java Serialization API provides the Serializable interface and the Externalizable interface as object
// serialization mechanisms.
//
// SERIALIZABLE INTERFACE
// Serializable is a MARKER INTERFACE, or, an interface that has no methods or constants inside it, and is intended to
// provide information to the compiler and JVM.  Therefore, to make a class Serializable, add "implements
// java.io.Serializable", then the JVM will provide default serialization.  The default serialization is serialization
// of all non-static and non-transient data members.  Variables defined with transient keyword are initialized with the
// default value (NOT current value) during deserialization. Variables defined with static keyword are loaded with the
// current value of the variable during deserialization.
//
// EXTERNALIZABLE INTERFACE
// The Externalizable interface, which extends Serializable, allows for flexibility and control of object serialization
// via writeExternal() and readExternal() methods.  When overriding these two methods, the user can specify/customize
// the items that are read and written, thus, allowing for better control and backwards compatibility.  Contrary to the
// Serializable interface, the Externalizable interface CAN write/read transient and static variables.
//
// NOTE: The same items and order must be used during writing (writeExternal()) and reading (readExternal()).
// NOTE: There must be a public default no-arg constructor to use readObject() on an object that implemented
//       Externalizable, or a java.io.InvalidClassException will be thrown.
//
// SERIALVERSIONUID
// The Serialization runtime associates a version number with each Serializable class called, this number is the
// serialVersionUID.  This is used during Deserialization to verify that the sender and receiver of a serialized object
// have loaded compatible classes (w.r.t. serialization). If the serialVersionUID differ during Deserialization, then a
// InvalidClassException will be thrown.  If no serialVersionUID is defined, Java will automatically create one based on
// the class'es attributes (note that small changes in the class can cause a different ID).  It is considered good
// practice to define your own serialVersionUID; to do this, define "static final long serialVersionUID" and assign it
// to a type of long value.
//
// SERIALVER
// serialver is a tool that comes with JDK. It is used to get serialVersionUID number for Java classes. The tool is used
// via the following command:
//      serialver [-classpath classpath] [-show] [classname…]


class SerializationReview{
    public static void examples(){

        SerializableClass serializableClass = new SerializableClass();
        SerializableClass readSerializableClass = null;

        serializableClass.transientInt = 8008;
        serializableClass.staticInt = 6;
        serializableClass.string = "Hello World!";
        serializableClass.i = 42;

        ExternalizableClass externalizableClass = new ExternalizableClass();
        ExternalizableClass readExternalizableClass = null;

        externalizableClass.transientInt = 80085;
        externalizableClass.staticInt = 69;
        externalizableClass.string = "Hello World!!!";
        externalizableClass.i = 420;

        System.out.println(serializableClass.toString());
        System.out.println(externalizableClass.toString());

        try {
            // Serialize serializableClass:
            ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("serializableClass.txt"));
            so.writeObject(serializableClass);
            so.flush();
            so.close();

            // Serialize externalizableClass:
            so = new ObjectOutputStream(new FileOutputStream("externalizableClass.txt"));
            so.writeObject(externalizableClass);
            so.flush();
            so.close();

            serializableClass.transientInt = 800;
            serializableClass.staticInt = -6;
            serializableClass.string = "Hello!";
            serializableClass.i = 4;

            externalizableClass.transientInt = 800850;
            externalizableClass.staticInt = 690;
            externalizableClass.string = "Hello World!!!!!!!!!!!";
            externalizableClass.i = 4200;

            // Deserialize serializableClass:
            ObjectInputStream si = new ObjectInputStream(new FileInputStream("serializableClass.txt"));
            readSerializableClass = (SerializableClass)si.readObject();
            si.close();

            // Deserialize externalizableClass:
            si = new ObjectInputStream(new FileInputStream("externalizableClass.txt"));
            readExternalizableClass = (ExternalizableClass)si.readObject();
            si.close();

            // Delete files:
            File f = new File("serializableClass.txt");
            f.delete();
            f = new File("externalizableClass.txt");
            f.delete();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(readSerializableClass.toString());
        System.out.println(readExternalizableClass.toString());

    }
}

// To make a class serializable just implement java.io.Serializable; it's easy, but consider long term implications...
class SerializableClass implements java.io.Serializable{

    // It is considered good practice to specify a serialVersionUID.
    private static final long serialVersionUID = 123456789L;
    transient int transientInt;
    static int staticInt;
    String string;
    int i;

    public String toString() {
        return ("serialVersionUID: " + serialVersionUID + " transientInt: " + transientInt + " staticInt: " + staticInt
                + " string: " + string + " i: " + i);
    }
}

// To make a class externalizable add implements Externalizable, then, add both writeExternal() and readExternal()
// methods; this is also easy, but please consider the long term implications...
class ExternalizableClass implements Externalizable{

    // It is considered good practice to specify a serialVersionUID.
    private static final long serialVersionUID = 1234567890L;
    transient int transientInt;
    static int staticInt;
    String string;
    int i;

    // NOTE: When implementing Externalizable, there MUST be a default no-arg constructor to prevent a
    // java.io.InvalidClassException when readObject is called on a file (of the serialized object).
    public ExternalizableClass(){}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // NOTE: ORDER WRITTEN MUST MATCH ORDER READ.
        out.writeObject(string);
        // Can write/read transient and static variables with Externalizable.
        out.writeInt(transientInt);
        out.writeInt(staticInt);
        // Using Externalizable, I can choose not to serialize something by not writing it:
        // out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // NOTE: ORDER READ MUST MATCH ORDER WRITTEN.
        string = (String)in.readObject();
        staticInt = in.readInt();
        transientInt = in.readInt();
    }

    public String toString() {
        return ("serialVersionUID: " + serialVersionUID + " transientInt: " + transientInt + " staticInt: " + staticInt
                + " string: " + string + " i: " + i);
    }
}



////////////////////////////////////////////////////
// LAMBDA EXPRESSIONS // aka FUNCTIONAL INTERFACE //
////////////////////////////////////////////////////

// Lambda Expressions can ONLY be used with interfaces that contain only one method that HAS to be implemented.
// java.util.function contains functional interfaces designed to be used with Lambda Expressions.
// If the body of the Lambda Expression has more than one statement you need to add curly braces ({}) and a return.
// Local variables referenced from a Lambda Expression must be final or effectively final.

class LambdaReview {
    public static void examples(){

        // NOTE: Lambda Expressions can easily replace Anonymous Classes with single methods.

        // How to start a runnable (thread) via Anonymous Class:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is a thread that only prints then dies.");
            }
        }).start();

        // A LAMBDA EXPRESSION for RunnableCode.
        new Thread(() -> System.out.println("This is a thread that only prints then dies.")).start();

        // LAMBDA CONSUMER (via accept(), 1 or 2 args, DOESN'T RETURN a value, CAN be Chained).
        Consumer<String> print = s -> System.out.println(s);
        // Use Lambda Consumer via accept() method:
        print.accept("my string");

        // LAMBDA PREDICATE (via test(), 1 or 2 args, RETURNS a value, CAN'T be Chained).
        Predicate<Integer> even = i -> i % 2 == 0;
        // Use Lambda Predicate via test() method:
        System.out.println(even.test(2));

        // LAMBDA SUPPLIER (via get(), ZERO args, RETURNS a value, CAN'T be Chained).
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        // Use Lambda Supplier via get() method:
        System.out.println(randomSupplier.get());

        // LAMBDA FUNCTIONS (via apply(), 1 or 2 args, RETURNS a value, CAN be Chained).
        Function<String, String> trim = (String s) -> { return s.trim(); };
        Function<String, Integer> length = s -> s.length();
        // Use Lambda Function via apply() method:
        System.out.println(trim.apply("     t r   i     m       e   d     "));

        // CHAINED Lambda Functions
        Function chainedFunctions = trim.andThen(length);
        System.out.println(chainedFunctions.apply("     t r   i     m       e   d     "));

        // LAMBDA UNIARY OPERATOR (1 argument, RETURNS same type as arg, CAN be Chained).
        IntUnaryOperator add5 = i -> i + 5;
        System.out.println(add5.applyAsInt(10));

        // LAMBDA FOREACH
        List<String> stringList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");
        stringList.forEach(num -> System.out.println(num));

    }
}


/////////////////////////
// STREAM (COLLECTION) //
/////////////////////////

// Added in Java 8
// A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
// Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
// Streams are composed of Intermediate and Terminal Operations

class StreamReview{
    public static void examples(){

        // NOTE: METHOD REFERENCE OPERATOR (:: or DOUBLE COLON)
        //   Used to call a method by referring to it with the help of its class directly.
        //   The only difference to lambda expressions is that :: uses direct reference to the method by name instead
        //   of providing a delegate to the method.
        //   Example: .map(String::toUpperCase) behaves as .map(s->s.toUpperCase())

        List<Integer> numbers = Arrays.asList(2,2,3,4,5,3,6,7,8,9);
        List<String> names = Arrays.asList("Matthew", "Brenton", "mark", "ryan", "Chris", "Bob", "michelle");


        // STREAM INTERMEDIATE OPERATIONS (Lazily Executed, Returns a Stream)
        //   Intermediate Operations can be pipelined or chained together.
        //   Each intermediate operation is lazily executed and returns a stream as a result.
        //   NOTE: An Intermediate Operation must have a Terminal Operation, or a return to be executed.

        // MAP (Returns a stream of the results of applying a function to the elements of the stream)
        List<Integer> listInteger = numbers.stream().map(x-> x * x ).collect(Collectors.toList());
        Stream<Integer> streamInt = numbers.stream().map(x-> {return x * x;});

        // FILTER (Filter selects elements as per the Predicate argument).
        List<String> filteredNames = names.stream().filter(s->s.startsWith("M")).collect(Collectors.toList());

        // SORTED (Sorts the Stream)
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());

        // PEEK (Mainly For Debugging)
        names.stream().filter(e -> e.length() > 4)
                      .peek(e -> System.out.println("Remaining value: " + e))
                      .collect(Collectors.toList());

        // LIMIT (Returns a stream of the elements truncated to be no longer than maxSize in length)
        List<Integer> firstTwo = numbers.stream().sorted().limit(2).collect(Collectors.toList());

        // DISTINCT (Returns a stream of distinct elements
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());

        // MAX (Returns the max element of the stream according to the provided comparator)
        Integer max = numbers.stream().max(Integer::compare).get();

        // MIN (Returns the min element of the stream according to the provided comparator)
        Integer min = numbers.stream().min(Integer::compare).get();


        // STREAM TERMINAL OPERATIONS (Returns a Result)
        //   Terminal operations mark the end of the stream and return the result (primitive, collection, or no value).
        //   Terminal operations are typically preceded by intermediate operations.

        // GET (Returns a value, if one is present, else throws NoSuchElementException)
        Integer maxNumber = numbers.stream().max(Integer::compare).get();

        // COLLECT (Returns the result of the Intermediate Operation(s))
        Set<Integer> squareSet = numbers.stream().map(x->x*x).collect(Collectors.toSet());

        // FOREACH (Iterates through every element of a Stream)
        numbers.stream().map(x->x*x).forEach(y->System.out.println(y));

        // REDUCE (Reduces the elements of a stream to a single value via a BinaryOperator)
        int even = numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

        // COUNT (Returns, AS LONG, the number of elements in the stream)
        long count = numbers.stream().distinct().count();

        // TOARRAY (Returns an array of the elements of this stream, using the provided generator function)
        Integer[] intArray = numbers.stream().map(x->x*x).toArray(Integer[]::new);
    }
}


////////////////
// CONCURRENT //
////////////////

class ConcurrentReview {
    public static final String EOF = "EOF";



    //////////////
    // VOLATILE //
    //////////////

    // The volatlie keyword/modifier guarantees that any thread that reads a field will access the most recently written
    // value (as opposed to a cached value) and NOTHING about mutual exclusion (so multiple threads can still access the
    // field).  Therefore, use of the volatile keyword without synchronization CAN cause memory consistency errors.
    //
    // HOWEVER, java.util.concurrent.atomic supports lock-free thread-safe programming on single varaibles.
    static volatile boolean volatileFlag = true;


    public static void examples() {
        List<Thread> threadList = null;



        ////////////
        // THREAD //
        ////////////

        // Threads, aka light weight processes, consists of; a program counter, registers, stack, and state and run in
        // shared memory space.  Threads can communicate with other threads (of the same process) directly by using
        // methods like wait(), notify(), notifyAll() (where processes must use inter-process communication).
        //
        // Threads can be created via:
        //   (1) Extend the java.lang.Thread class.
        //   (2) Implement the java.lang.Runnable interface
        //   (3) Implement the java.util.concurrent.Callable interface using FutureTask and a Thread
        //
        // The most common methods for a thread are:
        //   getName()	    Obtain thread’s name
        //   getPriority()	Obtain thread’s priority
        //   isAlive()	    Determine if a thread is still running
        //   join(timeout)	Wait for a thread to terminate
        //   run()	        Entry point for the thread
        //   sleep()	    Suspend a thread for a period of time
        //   start()        Start a thread by calling its run method


        // THREAD VIA ANONYMOUS THREAD CLASS
        new Thread(){public void run() { System.out.println("I'm an Anonymous Thread Class Thread"); }}.start();


        // THREAD VIA ANONYMOUS RUNNABLE
        new Thread(new Runnable() {public void run() { System.out.println("I'm a Anonymous Runnable Thread"); }}).start();


        // THREAD VIA LAMBDA THREAD EXPRESSION
        new Thread(()->{System.out.println("I'm a Lambda Thread Expression");}).start();


        // THREADS VIA LAMBDA RUNNABLE EXPRESSION
        Runnable runnable = () -> {System.out.println("I'm a Lambda Runnable Expression");};
        new Thread(runnable).start();


        // THREAD VIA EXTEND THREAD
        //   This prevents a class from extending anything else.
        //   Cannot return a value.
        //   Cannot throw exceptions.
        class ClassExtendingThread extends Thread {
            @Override
            public void run() {
                try {
                    System.out.println("ClassExtendingThread Thread " + Thread.currentThread().getId() + " is running");
                } catch (Exception e) {
                    System.out.println ("Exception is caught");
                }
            }
        }
        ClassExtendingThread classExtendingThread = new ClassExtendingThread();
        classExtendingThread.start();


        // THREAD VIA IMPLEMENTS RUNNABLE
        //   More flexible than extending Thread
        //   Single Abstract Method Type
        //   Cannot return a value.
        //   Cannot throw exceptions.
        class ClassImplementingRunnable implements Runnable {
            @Override
            public void run() {
                try {
                    System.out.println ("ClassImplementingRunnable Thread " + Thread.currentThread().getId() + " is running");
                } catch (Exception e) {
                    System.out.println ("Exception is caught");
                }
            }
        }
        Thread threadRunnable = new Thread(new ClassImplementingRunnable());
        threadRunnable.start();


        // THREADS VIA IMPLEMENTS CALLABLE USING FUTURETASK AND THREAD
        //   Added in Java 5
        //   Single Abstract Method Type
        //   Can return a result (Future object)
        //   call() method can throw Checked exception.
        class ClassImplementingCallable implements Callable<String> {
            @Override
            public String call() {
                String str = null;
                try {
                    str = "ClassImplementingCallable Thread " + Thread.currentThread().getId() + " is RETURNED this string!";
                } catch (Exception e) {
                    System.out.println ("Exception is caught");
                }
                return str;
            }
        }
        Callable<String> callable = new ClassImplementingCallable();
        FutureTask<String> futureTask = new FutureTask(callable);
        Thread threadCallable = new Thread(futureTask);
        threadCallable.start();
        try{
            System.out.println("FutureTask value: " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }



        /////////////////////
        // SYNCHRONIZATION //
        /////////////////////

        // The synchronized keyword restricts multiple threads from executing code simultaneously on the same object
        // instance; synchronized can be used on a METHOD or a CODE BLOCK.  Every object (EXCLUDING Primitives) has an
        // Implicit lock, sometimes called a monitor.  In Java, Synchronization is implemented with monitors.
        // Only one thread can own a monitor at a given time. When a thread acquires a monitor, it is said to have
        // entered the monitor. All other threads attempting to enter the locked monitor will be suspended until the
        // first thread exits the monitor.
        //
        // Java uses java uses wait(), notify() and notifyAll() to better coordinate thread interactions, these methods
        // belong to the OBJECT Class, hence, are available to all classes:
        //   wait()         Thread will go to waiting state, releasing the monitor, wakes when notified by another thread.
        //   notify()       Wakes one (other) thread waiting on the same monitor, does not give up the monitor.
        //   notifyAll()    Wakes all (other) threads that are waiting (called wait()) on the same object.  Might have
        //                  performance issues if many threads are present.


        // Class implementing SYNCHRONIZED METHOD and SYNCHRONIZED CODE BLOCK:
        class Message{
            private String message;
            private boolean empty = true;
            // SYNCHRONIZED METHOD EXAMPLE
            public synchronized String read(){
                while(empty){
                    try{
                        wait();
                    }catch(InterruptedException ex){
                        System.out.println("Exception: " + ex.toString());
                    }
                }
                empty = true;
                notifyAll();
                return message;
            }
            // SYNCHRONIZED CODE BLOCK EXAMPLE
            // Static methods use:      synchronized(ClassName.class){ ... }
            // Non-Static methods use:  synchronized(this){ ... }
            public void write(String message){
                synchronized (this) {
                    while (!empty) {
                        try {
                            wait();
                        } catch (InterruptedException ex) {
                            System.out.println("Exception: " + ex.toString());
                        }
                    }
                    empty = false;
                    this.message = message;
                    notifyAll();
                }
            }
        }

        // Thread to write to synchronized object.
        class Writer implements Runnable {
            private Message message;
            public Writer(Message message) {
                this.message = message;
            }
            public void run() {
                String messages[] = {"Humpty","Dumpty","sat","on","a","wall","Humpty","Dumpty","had","a","great","fall",
                        "All","the","king's","horses","and","all","the","king's","men","Couldn't","put",
                        "Humpty","together","again"};
                Random random = new Random();
                for(int i=0; i<messages.length; i++) {
                    message.write(messages[i]);
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch(InterruptedException e) {
                        System.out.println("Exception: " + e.toString());
                    }
                }
                message.write("Finished");
            }
        }

        // Thread to read from synchronized object.
        class Reader implements Runnable {
            private Message message;
            public Reader(Message message) {
                this.message = message;
            }
            public void run() {
                Random random = new Random();
                for(String latestMessage = message.read(); !latestMessage.equals("Finished");
                    latestMessage = message.read()) {
                    System.out.print(" " + latestMessage);
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch(InterruptedException e) {
                        System.out.println("Exception: " + e.toString());
                    }
                }
            }
        }


        // SYNCHRONIZATION EXAMPLE
        Message message = new Message();
        threadList = new ArrayList<>();
        threadList.add(new Thread(new Writer(message)));
        threadList.add(new Thread(new Reader(message)));
        threadList.stream().forEach(x->x.start());
        for(Thread t : threadList) {
            try {
                t.join(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.toString());
            }
        }
        System.out.println();



        ///////////////////
        // REENTRANTLOCK //
        ///////////////////

        // ReentrantLock synchronizes access to a shared resource by associating the resource with the reentrantLock,
        // NOT via a synchronized method or synchronized code block.  A thread gets access to a shared resource by first
        // acquiring the reentrantLock associated with the resource.  At any given time, at most one thread can hold the
        // reentrantLock and access the resource.
        //
        // The most common reentrantLock methods are:
        //   reentrantLock()        Get reentrantLock if available; if not, the thread gets blocked until the lock is released.
        //   lockInterruptibly()    Similar to reentrantLock(), but it allows the blocked thread to be interrupted and
        //                          resume the execution through a thrown java.lang.InterruptedException.
        //   tryLock()              Non-blocking version of reentrantLock(); attempts to get the lock, if successful RETURNS true.
        //   tryLock(timeout)       Similar to tryLock(), except it waits up the given timeout before giving up.
        //   unlock()               Unlocks the Lock instance
        //   lock()                 If lock unavailable then current thread lies dormant until the lock has been acquired.
        //
        // In addition to the Lock interface, there is the ReadWriteLock interface which maintains a pair of locks, one for
        // read-only operations, and one for the write operation. The read reentrantLock may be simultaneously held by
        // multiple threads as long as there is no write.
        //
        // The rules for acquiring the ReadLock or WriteLock by a thread:
        //   Read Lock – If no thread acquired the write reentrantLock, or requested it, then multiple threads can acquire
        //               the read reentrantLock.
        //   Write Lock – If no threads are reading or writing, then only one thread can acquire the write reentrantLock.



        class MyProducer implements Runnable {
            private List<String> buffer;
            private Lock lock;
            public MyProducer(List<String> buffer, Lock lock) {
                this.buffer = buffer;
                this.lock = lock;
            }
            public void run() {
                Random random = new Random();
                String[] nums = { "1", "2", "3", "4", "5"};
                for(String num: nums) {
                    try {
                        System.out.println(Thread.currentThread() + " Adding..." + num);
                        lock.lock();
                        try {
                            buffer.add(num);
                        } finally {
                            lock.unlock();
                        }
                        Thread.sleep(random.nextInt(100));
                    } catch(InterruptedException e) {
                        System.out.println("Producer was interrupted");
                    }
                }
                System.out.println(Thread.currentThread() + " Adding EOF and exiting...");
                lock.lock();
                try {
                    buffer.add("EOF");
                } finally {
                    lock.unlock();
                }
            }
        }

        class MyConsumer implements Runnable {
            private List<String> buffer;
            private Lock lock;
            public MyConsumer(List<String> buffer, Lock lock) {
                this.buffer = buffer;
                this.lock = lock;
            }
            public void run() {
                while(true) {
                    lock.lock();
                    try {
                        if(buffer.isEmpty()) {
                            continue;
                        }
                        if(buffer.get(0).equals(EOF)) {
                            System.out.println(Thread.currentThread() + " Exiting");
                            break;
                        } else {
                            System.out.println(Thread.currentThread() + " Removed " + buffer.remove(0));
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        // A shared "Buffer" or resource.
        List<String> buffer = new ArrayList<>();

        // REENTRANT LOCK EXAMPLE
        ReentrantLock reentrantLock = new ReentrantLock();

        threadList = new ArrayList<>();
        threadList.add(new Thread(new MyProducer(buffer, reentrantLock)));
        threadList.add(new Thread(new MyConsumer(buffer, reentrantLock)));
        threadList.add(new Thread(new MyConsumer(buffer, reentrantLock)));
        threadList.add(new Thread(new MyProducer(buffer, reentrantLock)));
        threadList.stream().forEach(x->x.start());
        for(Thread t : threadList) {
            try {
                t.join(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.toString());
            }
        }




        ///////////////
        // EXECUTORS //
        ///////////////

        // Executors are used for creating and managing threads. Added in Java 5. Some of the benefits include:
        //   Returns Future Objects
        //   Scheduling (via ScheduledExecutorService).
        //   Optimized cost overheads; reuses threads to decrease creation/cleanup overhead.
        //   Decouples task submission from task execution.
        //   Controls processing of tasks ( Work Stealing, ForkJoinPool, invokeAll) etc.
        //   Monitors the progress and health of Threads.
        //   Work Stealing (via newWorkStealingPool()) in JAVA 8
        //
        // ExecutorService common methods:
        //   execute()      Submits a Callable or a Runnable task to an ExecutorService (returns void).
        //   submit()       Submits a Callable or a Runnable task to an ExecutorService and returns a result of type FUTURE.
        //   invokeAny()    Submits a COLLECTION of tasks to an ExecutorService, and returns ONE FUTURE result, if successful.
        //   invokeAll()    Submits a COLLECTION of tasks to an ExecutorService, and returns the results of ALL task executions
        //                  in the form of a list of objects of type FUTURE aka List<Future<String>>.
        //   shutdown()     ExecutorService stops accepting new tasks, waits for previously submitted tasks to execute, then
        //                  terminates the executor.  DOESN'T shut down immediately.
        //   shutdownNow()  this method interrupts the running task and shuts down the executor immediately.
        //
        // Future Object common methods:
        //   get()          (BLOCKING) Returns an actual result of the Callable task's execution or null if Runnable task.
        //   isDone()       Used to check if the assigned task is already processed, returns BOOLEAN.
        //   cancel(true)   Cancels task execution, takes boolean mayInterruptIfRunning, returns BOOLEAN (false if couldn't cancel).
        //   isCancelled()  Checks if task was cancelled, returns BOOLEAN.


        // EXECUTOR, EXECUTORSERVICE, FUTURE OBJECTS EXAMPLE
        // Create a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
        ExecutorService executorServiceFixedPool = Executors.newFixedThreadPool(2);

        // NOTE: For SCHEDULED Threads use: Executors.newScheduledThreadPool(int corePoolSize);

        // NOTE: For WORK STEALING Threads use: Executors.newWorkStealingPool(int parallelism)!!!
        //       newWorkStealingPool(int parallelism) Creates a thread pool that creates new threads as needed via the
        //       provided ThreadFactory, and will reuse previously constructed threads when they are available

        // Use execute() on Classes that extended Threads OR implemented Runnable
        executorServiceFixedPool.execute(new ClassExtendingThread());
        executorServiceFixedPool.execute(new ClassImplementingRunnable());

        // A List for Future Objects returned by the ExecutorService:
        List<Future<String>> futureList = new ArrayList<>();

        // Use submit() on Classes that Implemented Callable, can get returned FutureObject
        futureList.add(executorServiceFixedPool.submit(new ClassImplementingCallable()));

        // To Convert Classes that extended Thread OR implemented Runnable to Callable Executors.callable(new myClass):
        Callable<String> callableT = Executors.callable(new ClassExtendingThread(), "ClassExtendingThread Done!");
        Callable<String> callableR = Executors.callable(new ClassImplementingRunnable(), "ClassImplementingRunnable Done!");
        futureList.add(executorServiceFixedPool.submit(callableT));
        futureList.add(executorServiceFixedPool.submit(callableR));

        // Use get(1000, TimeUnit.MILLISECONDS) (with timeout) to get the returned Future Objects (Strings):
        try {
            for(Future future : futureList) {
                System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
            }
        } catch ( TimeoutException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Oracle recommended shut down for ExecutorService:
        executorServiceFixedPool.shutdown();
        try{
            if(!executorServiceFixedPool.awaitTermination(800, TimeUnit.MILLISECONDS)){
                executorServiceFixedPool.shutdownNow();
            }
        }catch(InterruptedException e){
            executorServiceFixedPool.shutdownNow();
        }



        ///////////////////////
        // FORK/JOIN THREADS //
        ///////////////////////

        // Fork/Join adds divide-and-conquer, or recursive task processing.  Added in Java 7. Benefits include:
        //   Work Stealing (An idle thread steals work from a thread having tasks queued more than it can process)
        //   Ability to recursively decompose the tasks and collect the results.
        //
        // To make use of ForkJoin's recursive task processing, extend RecursiveAction (a task with return type void)
        // OR RecursiveTask<Object> (a task that returns a result) and implement/Override the compute() method.
        // The compute() method defines subtasks (instances of your class) and forks them via .fork().


        // FORK/JOIN FORKJOINPOOL EXAMPLE
        class ClassExtendingRecursiveTask extends RecursiveTask<Long> {
            private long workLoad = 0;
            public ClassExtendingRecursiveTask(long workLoad) { this.workLoad = workLoad; }
            @Override
            protected Long compute() {
                if(this.workLoad > 16) {                                                            // THREASHOLD
                    System.out.println("Splitting : " + this.workLoad);
                    List<ClassExtendingRecursiveTask> subtasks = new ArrayList<>();
                    subtasks.addAll(createSubtasks());
                    for(ClassExtendingRecursiveTask subtask : subtasks){
                        subtask.fork(); }                                                           // FORK
                    long result = 0;
                    for(ClassExtendingRecursiveTask subtask : subtasks) {
                        result += subtask.join(); }                                                 // JOIN
                    return result;
                } else { System.out.println("Computing: " + this.workLoad); return workLoad * 3; }
            }
            private List<ClassExtendingRecursiveTask> createSubtasks() {
                List<ClassExtendingRecursiveTask> subtasks = new ArrayList<>();
                subtasks.add(new ClassExtendingRecursiveTask(this.workLoad / 2));
                subtasks.add(new ClassExtendingRecursiveTask(this.workLoad / 2));
                return subtasks;
            }
        }

        // Create a ForkJoinPool with the specified level of parallelism. The parallelism == number of task threads/CPUs.
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        ClassExtendingRecursiveTask recursiveTask = new ClassExtendingRecursiveTask(75);

        // Performs the given task, returning its result upon completion
        long mergedResult = forkJoinPool.invoke(recursiveTask);
        System.out.println("mergedResult = " + mergedResult);



        /////////////
        // PROCESS //
        /////////////

        // Java provides java.lang.Process for process related tasks.
        // Two common ways to start a process are ProcessBuilder.start() and Runtime.getRuntime.exec(); both methods
        // creates a native process and return an instance (of a subclass of java.lang.Process) that can be used to
        // control the process and get information about it.
        //
        // ProcessBuilder was added in JAVA 5 and is preferred over Runtime due to the following reasons:
        //   Can change the working directory our shell command is running in using builder.directory().
        //   Can set-up a custom key-value map as environment using builder.environment().
        //   Redirects input and output streams to custom replacements.
        //   Can inherit both of them to the streams of the current JVM process using builder.inheritIO()
        //
        // Common Process methods include:
        //   destroy()          Kills the subprocess.
        //   exitValue()        Returns the exit value, as INT, for the subprocess.
        //   getErrorStream()   Returns the INPUTSTREAM of the subprocess.
        //   getOutputStream()  Returns OUTPUTSTREAM of the subprocess; output is piped into the std input stream.
        //   waitFor()          (BLOCKING) Returns the exit code, as INT, returned by the process.
        //   isAlive()          Returns BOOLEAN true if the process is still alive.
        //   destroyForcibly()  Destroys the process by force.

        // How to get OS name/type (so our process example can call the right app).
        String operSys = System.getProperty("os.name").toLowerCase();
        String line;
        if(operSys.contains("mac")) {
            try {


                // PROCESS VIA RUNTIME EXAMPLE
                System.out.println("Runtime Example");
                Runtime runtime = Runtime.getRuntime();
                // NOTE: Runtime exec can take a single string delimited by spaces.
                Process runtimeProcess = runtime.exec(String.format("sh -c ls"));

                // INPUT STREAM
                BufferedReader runtimeInputStream = new BufferedReader(new InputStreamReader(runtimeProcess.getInputStream()));
                while ((line = runtimeInputStream.readLine()) != null) {
                    System.out.print(line + " ");
                }
                System.out.println();

                // WAIT FOR
                System.out.println("exitcode: " + runtimeProcess.waitFor());


                // PROCESS VIA PROCESS BUILDER
                System.out.println("ProcessBuilder Example");
                // NOTE: ProcessBuilder requires a list of strings (args must be a list too).
                ProcessBuilder processBuilder = new ProcessBuilder(new String[]{"sh", "-c", "ls"});
                processBuilder.directory(new File(System.getProperty("user.home")));
                Process processBuilderProcess = processBuilder.start();

                // INPUT STREAM
                BufferedReader pbInputStream = new BufferedReader(new InputStreamReader(processBuilderProcess.getInputStream()));
                while ((line = pbInputStream.readLine()) != null) {
                    System.out.print(line + " ");
                }
                System.out.println();

                // WAIT FOR
                System.out.println("exitcode: " + runtimeProcess.waitFor());

            }catch(IOException | InterruptedException ex){
                System.out.println("Caught Exception: " + ex.toString());
            }
        } else {
            // TODO Add condition for your OS here...
            System.out.println("TODO Add condition for your OS here...");
        }



    }

}



////////////////////////////
// GC (GARBAGE COLLECTOR) //
////////////////////////////
//
// To understand the Garbage Collector system, we must first understand the JVM and JVM memory management.
//
// The Java Virtual Machine (JVM) acts as a run-time engine to run Java applications, and is a part of Java Runtime
// Environment (JRE).  The JVM memory management system is divided into several main parts; the Stack, Heap, and
// Permanent Generation.
//
// JVM STACK
// For each thread the JVM creates a stack.  JVM stack memory does not need to be contiguous. The JVM pushes and pops
// frames off the stack; stack frame consists of three parts:
//      Local Variable Array: A zero-based, indexed, array of words,
//      Operand Stack: Organized as array of words, that are pushed/popped from.
//      Frame Data: Contains exception table, symbolic, and constant references.
//
// JVM HEAP
//        The java Heap is divided into two main parts:
//        - Young Generation - has "MINOR GC", subdivided into three parts:
//        * Eden - Most of new objects are created. here
//        * Survivor0 - Objects are checked and moved from one to the other survivor space.
//        * Survivor1 - Objects that survive many GC cycles move from survivor space to Old Memory.
//        - Old Memory - has "MAJOR GC", GC runs when full.
//        Objects are created on the heap.
//        Call hierarchy and local variables are stored on stacks.
//        Java Heap dump is a snapshot of the heap at any given time.
//        Garbage collection in the heap is mandatory.
//        The Heap size can only be changed on JVM startup ()NOT dynamically once running).
//
// JVM PERMANENT GENERATION
//        Permanent Generation (a.k.a. Perm Gen) contains the application metadata required
//        by the JVM to describe the classes and methods used in the application.
//        NOTE: The Perm Gen is not part of Java Heap memory.
//        Perm Gen is populated by JVM at runtime based on the classes used by the
//        application, it also contains Java SE library classes and methods.
//        Perm Gen objects ARE garbage collected in a full garbage collection.
//
// GARBAGE COLLECTION
// Garbage Collection tracks each and every object available in the JVM heap space and removes unused objects when they
// become eligible.  This comes at a slight performance cost, or overhead, but removes the need for the user to allocate
// and de-allocating memory.
//
// Objects becomes eligible for GC when there is no live reference for that object, or, it can no longer be reached by
// any live thread. Note that cyclic references do not count as a live reference (i.e., if two objects are pointing to
// each other, neither hav a live reference, then both are eligible for GC).
//
// The object that performs the garbage collection is called a Garbage Collector or GC.  There are four implementations
// of garbage Collector:
//      Serial      Simplest, freezes all application threads when it runs: java -XX:+UseSerialGC -jar Application.java
//      Parallel    A.k.a Throughput Collectors, use multiple threads for managing heap space, also freezes other
//                  application threads while performing GC: java -XX:+UseParallelGC -jar Application.java
//      CMS         A.k.a. Concurrent Mark and Sweep, uses multiple garbage collector threads for GC, has short GC
//                  pauses, but responds slower: java -XX:+UseParNewGC -jar Application.java
//      G1          Garbage First, added in Java 1.7, increases throughput and decreases GC pause time, is the DEFAULT
//                  collector in Java 9: java -XX:+UseG1GC -jar Application.java
//
// JVM FLAGS
//      -X                          Shows all -X options
//      -Xss<size>                  Set java thread stack size
//      -Xmx<size>                  Set maximum memory allocation pool.
//      -Xms<size>                  Set initial memory allocation pool.
//      -Xmn<size>                  Set the initial and maximum size (in bytes) of heap for young generation/nursery.
//      -XX:+UseSerialGC            Set Serial Collector as GC.
//      -XX:+UseParallelGC          Set Parallel Collector as GC.
//      -XX:+UseConcMarkSweepGC     Set CMS (Concurrent Mark and Sweep Collector) as GC.
//      -XX:+UseG1GC                Set G1 Collector as GC.
//      -XX:PermGen<size>           Set initial PermGen size.
//      -XX:MaxPermSize<size>       Set the maximum PermGen size.
//      -XX:SurvivorRatio=<ratio>   Set ratio of Eden space and Survivor space.
//      -XX:NewRatio=<ratio>        Set ratio of old/new generation sizes (default is 2).

class GCReview {
    public static void examples() {
        // NOTE: Garbage Collecting can only be REQUESTED, and not immediately forced, via:
        System.gc();  // Class method, non-native method, in java.lang.System.
        // Or:
        Runtime.getRuntime().gc();  // - Instance method, native method, in java.lang.Runtime.
    }
}


