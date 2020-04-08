
Java Interview Review
=====================

[//]: # (This file is formatted such that it can be printed and the solutions can be obscured while reviewing.)

This file is meant as a very quick study guide for the polyglot programmer who needs to make sure that they don't forget 
something foolish in an interview.  

String & Char Manipulation
--------------------------
-[ ] Split  
                                        String str = "Hello Hello World!";  
                                        String splitStrs[] = str.split(" ");  
                                        String spaces[] = myString.split("\\s+");  
                                        String lines[] = myString.split("[\\r\\n]+");  
-[ ] Trim/Strip  
                                        String s = "    M a tthew \t  \n Pettersson    \n";  
                                        String s1 = s.trim();  // ONLY removes whitespace before & after (NOT in between).  
                                        s = s.replaceAll("\\s+", "");  // Removes all whitespace and non-visible char.  
-[ ] Replace  
                                        char oldChar = 'l';  
                                        char newChar = 'd';  
                                        String rStr = str.replace(oldChar, newChar);  
                                        String regex = "ll";  
                                        String replacement = "LL";  
                                        String raStr = rStr.replaceAll(regex, replacement);  
                                        String rfStr = rStr.replaceFirst(regex, replacement);            
-[ ] Find  
                                        int fIndex = str.indexOf("Hello");  
                                        int lIndex = str.lastIndexOf("Hello");  
                                        char zeroChar = str.charAt(0);  
                                        boolean sw = str.startsWith("Hell");  
                                        boolean swI = str.startsWith("Hell", 6);  
                                        boolean ew = str.endsWith("d!");  
-[ ] Substring  
                                        String ssf = str.substring(6);  
                                        String ssfl = str.substring(6, 10);  
-[ ] Upper/Lower Case 
                                        String uC = str.toUpperCase();  
                                        String lC = str.toLowerCase();  
-[ ] Is Digit/Alpha  
                                        Character.isLetter('c');  
                                        Character.isDigit('3');  
-[ ] Array --> String     
                                        double[] doubs = {2.34, 44.566, 23.66};  
                                        Arrays.toString(doubs)  
-[ ] String --> Array  
                                        String num = "22,33,44,55,66,77";  
                                        String str[] = num.split(",");  
-[ ] List --> String  
                                        List<String> list = Arrays.asList("A","B","C");  
                                        String res1 = String.join("", list);  
                                        String res2 = "".join(list);  
-[ ] String --> List    
                                        String num = "22,33,44,55,66,77";  
                                        String str[] = num.split(",");  
                                        List<String> al = new ArrayList<String>();   
                                        al = Arrays.asList(str);  
-[ ] String --> Char Array                
                                        str.toCharArray();  
-[ ] Char Array --> string  
                                        char[] charArray = {'f', 'o', 'o', 'b', 'a', 'r'};  
                                        String foobar = new String(charArray);  
                                        int index = 3, count = 3;  
                                        String bar = new String(charArray, index, count);  
-[ ] StringBuilder vs. StringBuffer               
                                        BuFFer First (so Synchronized), Builder second used builder pattern.    
                                        strBuilder.capacity();    
                                        strBuilder.length();    
                                        strBuilder.append("Again And Again");    
                                        strBuilder.replace(2, 7,"NONRANDOM");   
                                        strBuilder.delete(15, 21);   
                                        strBuilder.insert(30, "String To Insert");    
                                        strBuilder.toString();    

Array Manipulation
------------------
-[ ] Make Array  
                                        int[] myIntArray1 = new int[3];  
                                        int[] myIntArray2 = {1, 2, 3};  
                                        int[] myIntArray3 = new int[]{1, 2, 3};
                                        int[][] arr = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
                                        Arrays.deepToString(arr); // How to print a nested object.
                                        String[] myStringArray1 = new String[3];  
                                        String[] myStringArray2 = {"a", "b", "c"};  
                                        String[] myStringArray3 = new String[]{"a", "b", "c"};  
-[ ] Sub-array:                      
                                        Arrays.copyOf(Object[] src, int newLength); // (truncates or fills with null)  
                                        Arrays.copyOfRange(Object[] src, int from, int to); // (fills with null)  
-[ ] Fill  
                                        Arrays.fill(Object[] src, Object value);  
                                        Arrays.fill(Object[] src, int from, int to, Object value);  
-[ ] Sort  
                                        int numArray[] = {8, 7, 5, 2, 1};  
                                        Arrays.sort(numArray);  // Works on all primitive (except boolean) arrays...  
-[ ] Shallow Copy  
                                        String[] sArray = {"A","B","C"};  
                                        String[] sArrayCopy = new String[sArray.length];  
                                        int srcPos = 0, destPos = 0;  
                                        System.arraycopy(sArray, srcPos, sArrayCopy, destPos, sArray.length);  
                                        String[] sClone = sArray.clone();  
-[ ] Deep Copy  
                                        // Using Apache Commons 3 SerializationUtils clone() method.   
                                        // NOTE: Object needs to implement Serializable interface.   
                                        MyObj[] myObjArray = createMyObjArray();   
                                        MyObj[] myObjArrayClone =  SerializationUtils.clone(myObjArray);    
                                        // Using Serialization/Streams  
                                        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
                                        ObjectOutputStream oos = new ObjectOutputStream(baos);  
                                        oos.writeObject(myObjArray);  
                                        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());  
                                        ObjectInputStream ois = new ObjectInputStream(bais);  
                                        MyObj[] myObjArrayCopy = ois.readObject();  
                                        
Numbers & Math
--------------
-[ ] Max/Min Type Size   
                                        Integer.SIZE;  // Number of Bits for any type...  
                                        Float.MIN_VALUE;  
                                        Long.MAX_VALUE;  
-[ ] Max/Min/Power/FloorDiv/FloorMod  
                                        int x = 10, y = 100;  
                                        double d = 1.0 / 3.0;  
                                        Math.max(x, y);  
                                        Math.min(x, y);  
                                        Math.pow(x, y);  
                                        Math.floorDiv(x, y);  
                                        Math.floorMod(x, y);  
-[ ] Sqrt/Log/Floor/Ceiling/Abs  
                                        Math.sqrt(x);  
                                        Math.log(x);  
                                        Math.floor(d);  
                                        Math.ceil(d);  
                                        Math.abs(x);  
-[ ] Random  
                                        Math.random();              // Returns double >= 0.0 and < 1.0   
                                        int bound = 10, seed = 100;  
                                        byte[] bytes = new byte[10];  
                                        Random random = new Random();  
                                        random.nextInt();           // Returns INT.MIN_VALUE <= INT <= INT.MAX_VALUE  
                                        random.nextInt(bound);      // Returns 0 <= INT < bound, ONLY int can have bound.  
                                        random.nextDouble();        // Returns 0.0 <= DOUBLE < 1.0  
                                        random.nextBytes(bytes);    // Puts random bytes into each index of supplied array.  
                                        random.setSeed(seed);  
-[ ] Decimal/Binary/Hex/Octal  
                                        int num = 32;  
                                        int bNum = 0b100000;            // Use negative (-) for neg, not leading 1.  
                                        int BNum = 0B100000;            // Use negative (-) for neg, not leading 1.  
                                        int hNum = 0x20;                // Use negative (-) for neg, not leading 1.  
                                        int HNum = 0X20;                // Use negative (-) for neg, not leading 1.  
                                        int oNum = 040;                 // Use negative (-) for neg, not leading 1.  
-[ ] Int --> Binary/Hex/Octal String  
                                        Integer.toString(num, 2);       // To Binary String  
                                        Integer.toBinaryString(num);      
                                        Integer.toString(num, 16);      // To Hex String  
                                        Integer.toHexString(num);  
                                        Integer.toString(num, 8);       // To Octal  String  
                                        Integer.toOctalString(num);  
-[ ] String --> Int  
                                        Integer.valueOf("32")           // Doesn't work with "0b100000"/"0x20"/"0o40"  
                                        Integer.parseInt("32");         // Doesn't work with "0b100000"/"0x20"/"0o40"  
                                        Integer.decode("0x20");         // Doesn't work with "0b100000"/"0B100000"  
                                        Integer.decode("040");          // Doesn't work with "0b100000"/"0B100000"  
                                        
Formatting & I/O
----------------
- Formatting  
                                        // Printf (formatted output via String.format() or System.out.printf())  
                                        // Syntax: %[argument_index$][flags][width][.precision]conversion  
                                        // %s    : strings  
                                        // %d    : Integers  
                                        // %f    : Floats/Doubles  
                                        // %c    : Characters  
                                        // %e    : Scientific Notation  
                                        // %t    : Dates  
                                        // %b    : Booleans  
                                        // %o    : Octal  
                                        // %h    : Hex  
                                        // %%    : Print Percent  
                                        System.out.println(String.format("|%-20.5f|", Math.PI));  
                                        System.out.printf("%s, %04d, %f, %c", "string", 2, .2, 'c' );  
                                        System.out.printf("%e, %b", Math.pow(1000, 1000), true);  
                                        System.out.printf("%o, %h, %%", 32, 32);  
                                        // No Format Specifier for Binary, Use:  
                                        String.format("%16s", Integer.toBinaryString(1)).replace(" ", "0");      
- User Input  
                                        Scanner scanner = new Scanner(System.in);    
                                        String s = scanner.nextLine();    
                                        int i = scanner.nextInt();   
                                        scanner.nextLine();             // To consume newline.    
                                        float f = scanner.nextFloat();   
                                        scanner.nextLine();             // To consume newline.  
                                        scanner.close();   
- Open, Read, Write (file)  
                                        File file = new File("file.txt");  
                                        try{  
                                            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));  
                                            pw.println("This is sample text");  
                                            pw.close();  
                                            System.out.println("Absolute Path: " + file.getAbsolutePath());  
                                            System.out.println("Canonical Path: " + file.getCanonicalPath());  
                                            System.out.println("Path: " + file.getPath());  
                                            BufferedReader br = new BufferedReader(new FileReader(file));  
                                            String text = br.readLine();  
                                            while(text != null){  
                                                System.out.println(text);  
                                                text = br.readLine(); }    
                                            br.close();   
                                        }catch (IOException e){ e.printStackTrace(); }  
                                        file.delete();  
                                        Path currentRelativePath = Paths.get("");  
                                        String path = currentRelativePath.toAbsolutePath().toString();  
                                        System.out.println("Current relative path is: " + path);  

Classes & Objects
-----------------
-[ ] Objects  
                                        Basic unit of OOP.  
                                        Consists of:  
                                            - State - Attributes or fields.  
                                            - Behavior - Methods.  
                                            - Identity - Name.  
-[ ] Creating Objects  
                                        Using the new keyword:  
                                            "Cls c = new Cls();"  
                                        Three methods which internally use the new keyword:  
                                            - Class.forName(String className).newInstance()   
                                                Cls c = (Cls)Class.forName("com.path.to.Cls").newInstance();  
                                            - clone()  
                                                Cls c2 = (Cls)c.clone();  
                                            - Deserialization  
                                                FileInputStream file = new FileInputStream(filename);  
                                                ObjectInputStream in = new ObjectInputStream(file);  
                                                Cls c = (Cls)in.readObject();  
-[ ] Class  
                                        class Cls extends OneSuperClass implements IMultiple, IInterfaces{  
                                            // Static Member Var - Shared by all instances of the class.  
                                            private static int sharedVar = 0;  
                                            // Instance Vars aka Fields aka Member Vars.  
                                            private String s;  
                                            // Constructor  
                                            public Cls(String s, int i){  
                                                this("constructor chaining");  
                                                this.s = s;  
                                                sharedVar++;  
                                            }  
                                            // Instance Method - Created when the Cls instance is instantiated.  
                                            public void instanceMethod(){}  
                                            // Static Methods - Can't access instance methods or instance vars directly.  
                                            // Exist before Cls instance is instantiated.  
                                            public static void staticMethod(){}  
                                            // Multiple Args Method   
                                            public void multipleArgsMethod(int ... vals){for(int x : vals){}  
                                        }   
-[ ] Abstract Class  
                                        // Only methods/classes can be abstract.   
                                        // Any class extending an abstract class must implement all abstract methods...  
                                        // Can be empty, can extend or implements.  
                                        abstract class AbstractClass extends AbstractEmpty implements InterfaceEmpty {  
                                            // Can have member (inherited) variables (interfaces can't unless static).  
                                            private String name;  
                                            // Can have a constructor (interfaces can't)  
                                            public AbstractClass(String name){this.name = name;}  
                                            // Can have non-abstract methods (or methods w/ bodies):  
                                            public String getName() {return name;}  
                                            public abstract void doSomething();  
                                            public abstract void doSomethingElse(int someInt);  
                                        }  
-[ ] Interface  
                                        // Can only extend an interface.  
                                        // Can't implement an interface.  
                                        // Can't extend an abstract class.  
                                        interface InterfaceClass extends InterfaceClassEmpty{  
                                            // Can ONLY have public static variables.  
                                            public static String staticString = "Only static variables are allowed.";  
                                            public static final int STATIC_INT = 838;  
                                            // (Pre-Java 9) Can only have public methods (no private or protected).  
                                            public void interfaceMethod();  
                                            public boolean interfaceMethodWithArg(int i);  
                                            // In Java 9, can have private methods.  
                                            //private void privateMethod();  
                                            // In Java 8, can contain default methods (with implementation).  
                                            default void defaultMethod(int defaultArg){  
                                                System.out.println("Can do all the things.");}  
                                        }  
-[ ] Generics  
                                        // Allows types to be parameterized.  
                                        // Benefits: Code Reuse, Type Safety, Elimination of casts, generic algorithms.  
                                        // Added to Java5  
                                        // Sorta similar to C++ templates.   
                                        // Use <> to specify parameter types.  
                                        class ClassWithGenerics<T extends Comparable>{  
                                            T valWithGenericType;  
                                            // Static keyword must have matching Generic type if generic type used in method.  
                                            // Static generic methods can be used in non-generic classes.  
                                            public static<T extends Object> void staticMethod(T[] arr){}  
                                            public void setValWithGenericType(T valWithGenericType){this.valWithGenericType=val;}  
                                            public T getValWithGenericType(){return valWithGenericType;}  
                                            public void usingRawAndGenerics() {  
                                                // List with Raw types:  
                                                ArrayList rawTypesList = new ArrayList();  
                                                rawTypesList.add(1); rawTypesList.add("hi"); rawTypesList.add(1.2);  
                                                // List Using Generics:  
                                                ArrayList<Integer> intList = new ArrayList<>();  
                                                intList.add(144);  
                                            }  
                                            // Must typecast when referencing; prone to run time errors.  
                                            public static void printArrayList(ArrayList<?> aL){  
                                                for(Object x : aL) System.out.println(x);}  
                                        }  
-[ ] Generics Implementation  
                                        The implementation of Java generics is rooted in an idea of "type erasure"; this
                                        technique eliminates the parameterized types when source code is translated to 
                                        JVM byte code. Other aspects of Java generics are:  
                                            - Cannot use primitive types.  
                                            - Generics can be restricted to certain types.  
                                            - All instances of a generic class, regardless of type params, are the same 
                                                (because type params are erased at runtime).  
                                        NOTE: Java Generics != C++ Templates; C++ Templates are a glorified macro set; 
                                        the compiler creates a new copy of the template for each type.  
-[ ] Abstract Class vs Interface  
                                        Abstract Class  
                                            - "IS" something.  
                                            - Uses "extends".  
                                            - Less flexible.  
                                        Interface  
                                            - "CAN" do something.  
                                            - The end class will have additional functionality.  
                                            - Uses "implements".  
                                            - More Flexible.  
                                            - Used on unrelated classes.  
-[ ] Composition vs Inheritance  
                                        Composition 
                                            - "HAS A" relation.  
                                            - Accomplished by including an INSTANCE of another class as a FIELD.  
                                        Inheritance 
                                            - "IS A" relation.  
                                            - Accomplished by EXTENDING another class.  
-[ ] Method Overloading vs 
     Method Overriding  
                                        Method Overloading  
                                            - Must have same name & different parameters.  
                                            - Can have different return types.  
                                            - Can have different modifiers.  
                                            - Can throw different checked or unchecked exceptions.  
                                        Method Overriding     
                                            - Only inherited, non-constructor/private/final methods can be overridden.  
                                            - Must have same name and args as overridden method.  
                                            - Must return same (or subclassed) type of the parent class.  
                                            - Must have same (or less restrictive) access modifier of the parent class.  
                                            - Use super.methodName() to call the superclass ver. of an overridden method.  
                                            - Should, but don't have to, annotate with @Override.  
                                            - JVM will determine what method will be called at runtime.  
                                            - Can't override static methods (only instance methods).  
     
Misc. Java Syntax
-----------------
-[ ] Exit  
                                        System.exit(0);  

Built-In Data Structures
------------------------
-[ ] Iterable Interface  
                                        Root interface for all collection classes.  
                                        In package java.lang;   
-[ ] Collection Interface  
                                        Root interface in the collection hierarchy.  
                                        Interface in package java.util;  
                                        A collection represents a group of objects, known as its elements.  
                                        Methods: size(), isEmpty(), contains(), iterator(), toArray(), add(E e),
                                        remove(), containsAll(), addAll(), removeAll(), clear(), equals(), hashCode(),
                                        and several others.   
-[ ] Collections  
                                        Utility class with Static classes and methods, which operate on or return collections.  
                                        Class in package java.util;   
                                        Includes sort, search, shuffle, swap, get, and other utility methods.                                        
-[ ] Concurrent Collections  
                                        Additions to collections fwk to solve "Memory Consistency Errors" or synchronization.  
                                        Performs better than synchronized version of the traditional collections.  
                                        A Package in java.util (has atomic and locks subpackages)  
                                        DS Classes: ArrayBlockingQueue, ConcurrentHashMap, ConcurrentLinkedDeque,
                                        ConcurrentLinkedQueue, ConcurrentSkipListMap, ConcurrentSkipListSet,
                                        CopyOnWriteArrayList, CopyOnWriteArraySet, DelayQueue, LinkedBlockingDeque,
                                        LinkedBlockingQueue, LinkedTransferQueue, PriorityBlockingQueue, and
                                        SynchronousQueue.   
-[ ] List Interface  
                                        LIST IMPLEMENTATIONS    | get  | add  | contains    | next  | remove(0) | iterator.remove  
                                        |:---------------------:|:----:|-----:|:-----------:|:-----:|:---------:|:-------------:|  
                                        ArrayList               | O(1) | O(1) | O(n)        | O(1)  | O(n)      | O(n)  
                                        LinkedList              | O(n) | O(1) | O(n)        | O(1)  | O(1)      | O(1)  
                                        CopyOnWrite-ArrayList   | O(1) | O(n) | O(n)        | O(1)  | O(n)      | O(n)  
                                        Vector                  | O(1) | O(1) | O(n)        | O(1)  | O(n)      | O(n)  
                                        Stack                   | O(1) | O(1) | O(n)        | O(1)  | O(n)      | O(n)                                               
                                        Extends Collection  
                                        Included Methods: size(), isEmpty(), contains(Object o), iterator(), toArray(),
                                        add(E e), remove(Object o), sort(), clear(), equals(Object o), hashCode(), 
                                        get(int i), set(int i, E e), indexOf(Object o), subList(int from, int to), etc...  
-[ ] ArrayList  
                                        RESIZEABLE-Array imp of the List interface; allows NULL, is NOT synchronized.  
                                        Extends AbstractList  
                                        Implements List, RandomAccess, Cloneable, java.io.Serializable.  
-[ ] LinkedList   
                                        Doubly-linked list implementation; NOT synchronized, implements List and Dequeue.  
                                        Extends AbstractSequentialList.  
                                        Implements List, Deque, Cloneable, java.io.Serializable.  
-[ ] Vector  
                                        GROWABLE array of obj accessed via a int index; IS SYNCHRONIZED.  
                                        Extends AbstractList  
                                        Implements List, RandomAccess, Cloneable, and java.io.Serializable.  
                                        Methods Included: add(E e), set(int i, E e), get(int i), remove(Object o), 
                                        clear(), addAll(Collection c), equals(Object o), etc...  
-[ ] Stack  
                                        Last-In-First-Out (LIFO) stack of objects; is SYNCHRONIZED.  
                                        Extends Vector.  
                                        Methods:  push(E item), pop(), peek(), empty(), search(Object o)  
-[ ] Set Interface  
                                        SET IMPLEMENTATIONS     | add       | contains  | next       
                                        |:---------------------:|:---------:|:---------:|:----------------------------:|       
                                        HashSet                 | O(1)      | O(1)      | O(h/n) (h = table capacity)        
                                        LinkedHashSet           | O(1)      | O(1)      | O(1)      
                                        CopyOnWriteArraySet     | O(n)      | O(n)      | O(1)       
                                        EnumSet                 | O(1)      | O(1)      | O(1)       
                                        TreeSet                 | O(log n)  | O(log n)  | O(log n)      
                                        ConcurrentSkipListSet   | O(log n)  | O(log n)  | O(1)           
                                        Extends Collection  
                                        Included Methods: size(), isEmpty(), contains(Object o), iterator(), toArray(),
                                        add(E e), remove(Object o), clear(), equals(Object o), hashCode(), etc...  
-[ ] HashSet  
                                        Set imp backed by HashMap; allows one null, NOT ordered, NOT synchronized.  
                                        Extends AbstractSet  
                                        Implements Set, Cloneable, java.io.Serializable  
-[ ] LinkedHashSet    
                                        HashTable & LinkedList imp of the Set interface; NOT synchronized, ORDERED via 
                                        doubly-linked list (different than from HashSet).  
                                        Extends HashSet.  
                                        Implements Set, Cloneable, java.io.Serializable.  
-[ ] TreeSet  
                                        NavigableSet imp based on TreeMap; ORDERED elements, NOT synchronized.  
                                        Extends AbstractSet  
                                        Implements NavigableSet, Cloneable, java.io.Serializable.  
-[ ] Queue Interface  
                                        QUEUE IMPLEMENTATIONS   | offer     | peek      | poll      | size   
                                        |:---------------------:|:---------:|:---------:|:---------:|:--------:|  
                                        PriorityQueue           | O(log n)  | O(1)      | O(log n)  | O(1)        
                                        ConcurrentLinkedQueue   | O(1)      | O(1)      | O(1)      | O(n)  
                                        ArrayBlockingQueue      | O(1)      | O(1)      | O(1)      | O(1)  
                                        LinkedBlockingQueue     | O(1)      | O(1)      | O(1)      | O(1)    
                                        PriorityBlockingQueue   | O(log n)  | O(1)      | O(log n)  | O(1)     
                                        DelayQueue              | O(log n)  | O(1)      | O(log n)  | O(1)    
                                        LinkedList              | O(1)      | O(1)      | O(1)      | O(1)  
                                        ArrayDeque              | O(1)      | O(1)      | O(1)      | O(1)  
                                        LinkedBlockingDeque     | O(1)      | O(1)      | O(1)      | O(1)  
                                        Extends Collection  
                                        Methods: add(E e), offer(E e), remove(), poll(), element(), peek().  
-[ ] PriorityQueue  
                                        An unbounded priority queue based on a priority heap; NOT synchronized.  
                                        Extends AbstractQueue.  
                                        Implements java.io.Serializable.  
-[ ] ArrayDeque  
                                        Resizable-array imp of the Deque interface, NOT synchronized, nulls NOT allowed,
                                        faster than stack (if used as stack), faster than LinkedList (if used as Queue).  
                                        Extends AbstractCollection.  
                                        Implements Deque, Cloneable, Serializable.  
-[ ] Map Interface  
                                        MAP IMPLEMENTATIONS     | get       | containsKey   | next  
                                        |:---------------------:|:---------:|:-------------:|:-------------------------:|  
                                        HashMap                 | O(1)      | O(1)          | O(h/n) (h = table capacity)  
                                        LinkedHashMap           | O(1)      | O(1)          | O(1)   
                                        IdentityHashMap         | O(1)      | O(1)          | O(h/n) (h = table capacity)  
                                        EnumMap                 | O(1)      | O(1)          | O(1)   
                                        TreeMap                 | O(log n)  | O(log n)      | O(log n)  
                                        ConcurrentHashMap       | O(1)      | O(1)          | O(h/n) (h = table capacity)  
                                        ConcurrentSkipListMap   | O(log n)  | O(log n)      | O(1)  
                                        Does not extend or implement anything.                                      
                                        Included Methods: size(), isEmpty(), containsKey(Object k), containsValue(Object v),
                                        get(Object k), put(Object k, Object v), clear(), keySet(), values(), entrySet(),
                                        equals(Object o), hashCode(), remove(Object k, Object v), replace(K k, V v), etc...  
-[ ] HashMap  
                                        Hashtable based imp of Map interface; allows NULL values and a NULL key,
                                        NOT synchronized, and has NO ORDER guarantees.  
                                        Extends AbstractMap  
                                        Implements Map, Cloneable, Serializable.   
-[ ] LinkedHashMap  
                                        HashTable & LinkedList imp of the Map interface; NOT synchronized, ORDERED via 
                                        doubly-linked list (different than from HashSet).  
                                        Extends HashMap.  
                                        Implements Map.  
-[ ] IdentityHashMap  
                                        Map interface imp via HashTable using reference-equality (not object-equality)
                                        when comparing keys; NOT for general use (typical use is topology-preservation),
                                        NOT synchronized.    
                                        Extends AbstractMap  
                                        Implements Map, java.io.Serializable, Cloneable  
-[ ] EnumMap  
                                        Specialized Map imp for enum type NON-NULL keys; NOT synchronized.  
                                        Extends AbstractMap  
                                        Implements java.io.Serializable, Cloneable.  
-[ ] TreeMap  
                                        Red-Black tree based NavigableMap imp; (ORDERED) SORTED by keys, NOT synchronized.  
                                        Extends AbstractMap  
                                        Implements NavigableMap, Cloneable, java.io.Serializable.   
-[ ] Hashtable   
                                        HashTable imp; NO nulls allowed, IS synchronized.  
                                        Extends Dictionary  
                                        Implements Map, Cloneable, java.io.Serializable  
-[ ] BitSet  
                                        Vector of (NON-NULL boolean valued) Bits; size GROWS as needed, NOT synchronized.   
                                        Implements Cloneable, java.io.Serializable   
-[ ] HashSet vs HashMap vs Hashtable vs
     TreeMap vs LinkedHashMap  
                                        HashSet  
                                            - A SET (via HashMap),  
                                            - Allows ONE null,  
                                            - NOT ordered,  
                                            - NOT synchronized.  
                                        HashMap  
                                            - O(1) find/add,  
                                            - NOT synchronized,  
                                            - Allows ONE null,  
                                            - NOT ordered,  
                                            - Implemented via linkedList.  
                                        Hashtable  
                                            - IS synchronized.  
                                        TreeMap  
                                            - O(log n) find/add,  
                                            - NOT synchronized,  
                                            - ORDERED keys,  
                                            - Implemented via Red-Black tree.  
                                        LinkedHashMap  
                                            - O(1) find/add,  
                                            - NOT synchronized,  
                                            - ORDERED keys,  
                                            - Implemented via doubly-linkedList.  
-[ ] ArrayList vs LinkedList vs Vector  
                                        ArrayList  
                                            - RESIZABLE,   
                                            - Allows NULL,  
                                            - Is NOT synchronized.  
                                        LinkedList  
                                            - Doubly-linked list,   
                                            - NOT synchronized.  
                                        Vector  
                                            - IS Synchronized.  
                                            - Similar to ArrayList.  
-[ ] Collection vs Collections  
                                        Collection  
                                            - Root interface...  
                                        Collections  
                                            - Utility class with static classes and methods.   
-[ ] Collections vs 
     Synchronized Collections vs 
     Concurrent Collections   
                                        Collections  
                                            - Only Vector, Stack and Hashtable are synchronized.  
                                        Synchronized Collections  
                                            - Wrappers that synchronized collections through intrinsic locking.  
                                            - Entire collections are locked.  
                                            - Methods:  
                                                - synchronizedCollection()  
                                                - synchronizedList()  
                                                - synchronizedMap()  
                                                - synchronizedSet()  
                                                - synchronizedSortedSet()   
                                        Concurrent Collections  
                                            - Achieves thread-safety by dividing their data into segments.  
                                            - Better performance.  

Data Structures
---------------
-[ ] Stack  
                                        SEE ./src/com/mpettersson/review/data/structures/Stack.java.  
                                        Variable(s): top<Node>.  
                                        Methods: push(E e), pop(), isEmpty(), search(Object o).  
                                        Node Variable(s): value<E>, next<Node>.  
-[ ] Queue  
                                        SEE ./src/com/mpettersson/review/data/structures/Queue.java.  
                                        Variable(s): first<Node>, last<Node>.  
                                        Methods: add(E e), remove(), peek(), isEmpty().  
                                        Node Variable(s): value<E>, next<Node>.                                         
-[ ] LinkedList  
                                        SEE ./src/com/mpettersson/review/data/structures/SLinkedList.java.  
                                        Variable(s): head<Node>.  
                                        Methods: add(E e), remove(Object o), clear(), equals(Object o), get(int i), 
                                        set(int i, E e), indexOf(Object o).  
                                        Node Variable(s): value<E>, next<Node>.  
-[ ] HashMap  
                                        SEE ./src/com/mpettersson/review/data/structures/HashMap.java.  
                                        Variable(s): array<List<Node>>, capacity<int>, size<int>, threshold<float>.  
                                        Methods: add(E e), getIndex(Key k), remove(Key k), get(Key k), put(Key k, Value v), 
                                        size(), isEmpty().  
                                        Node Variable(s): key<K>, value<V>, next<Node>.  
-[ ] Graph  
                                        SEE ./src/com/mpettersson/review/data/structures/Graph.java.  
                                        NOTE: Because graphs might not be fully connected, a Node Class needs to be 
                                        wrapped in a Graph Class.  
                                        Node Variable(s): name<String>, value<V>, neighbors<List<Node>>.   
                                        Node Method(s): addNeighbor(Node n), removeNeighbor(Node n), getNeighbors().  
-[ ] Tree  
                                        SEE ./src/com/mpettersson/review/data/structures/BST.java.  
                                        NOTE: During interviews it's easier to just use a list of nodes (no Tree Class).  
                                        Node Variable(s): value<V>, children<List<Node>>.  
                                        Node Method(s): addChild(Node n), removeChild(Node n), getChildren().  

Common Interview Functions & Algorithms
---------------------------------------
-[ ] isPrime  
-[ ] Fibonacci  
-[ ] Factorial  

-[ ] Russian Peasant Alg (A * B)  
-[ ] Sieve of Eratosthenes (primes 2 to N)  
-[ ] Euclidean or Euclid's Alg (GDD)  
-[ ] Pollard's Rho (Prime Factorization Alg)  

-[ ] Towers of Hanoi  
-[ ] Floyd Cycle Detection  
-[ ] Quick Select Alg (kth sm/lg num in arr)  
-[ ] Rabin-Karp Alg (Substring Search)  

-[ ] Bubble Sort  
-[ ] Insertion Sort  
-[ ] Selection Sort  
-[ ] Quick Sort  
-[ ] Merge Sort  
-[ ] Topological Sort  

-[ ] Binary Search  
-[ ] In-Order Tree Traversal  
-[ ] Pre-Order Tree Traversal  
-[ ] Post-Order Tree Traversal  
-[ ] Breath First Tree Traversal  
-[ ] Depth First Search  
-[ ] Breadth First Search  

-[ ] Dijkstra's Algorithm  
-[ ] Bellman-Ford Algorithm  
-[ ] Floyd-Warshall algorithm  


Concurrency
-----------
-[ ] Threads/Threading   
                                        Threads, aka light weight processes, consists of; a program counter, registers, 
                                        stack, and state and run in shared memory space.   
                                        Threads can communicate with other threads (of the same process) directly by 
                                        using methods like wait(), notify(), notifyAll() (where processes must use 
                                        inter-process communication).  
                                        Threads can be created via:  
                                           - Extend the java.lang.Thread class.  
                                           - Implement the java.lang.Runnable interface.  
                                           - Implement the java.util.concurrent.Callable interface via FutureTask and Thread.  
-[ ] Synchronization  
                                        The synchronized keyword restricts multiple threads from executing code 
                                        simultaneously on the same object instance; synchronized can be used on a METHOD 
                                        or a CODE BLOCK. Every object (EXCLUDING Primitives) has an Implicit lock, a.k.a. 
                                        monitor. Synchronization is implemented with monitors. Only one thread can own a 
                                        monitor at a given time. When a thread acquires a monitor, it is said to have
                                        entered the monitor. All other threads attempting to enter the locked monitor 
                                        will be suspended until the first thread exits the monitor.  
                                        Java uses java uses wait(), notify() and notifyAll() to better coordinate thread 
                                        interactions, these methods belong to the OBJECT Class.   
-[ ] Executors  
                                        Used for creating managing, and monitoring threads, Added in Java 5, returns 
                                        Future Objects, has scheduling, are optimized, have Work Stealing ( in Java 8).  
-[ ] Process  
                                        Start processes via ProcessBuilder.start() or Runtime.getRuntime.exec(); both
                                        create a native process, returning a java.lang.Process subclass instance.  
-[ ] Executor vs Executors vs
     ExecutorService  
                                        Executor - Interface w/ ONLY (one) execute() method to execute a submitted runnable. 
                                        Executors -  A class with (static) Factory and utility methods for Executor, 
                                            ExecutorService, ScheduledExecutorService, ThreadFactory}, Callable classes.
                                        ExecutorService - A manageable executor that can produce Future objects. 

Exceptions
----------
-[ ] Throwable vs Error vs Exception  
                                        Throwable  
                                            - "Is the superclass of all errors and exceptions in the Java language."
                                            - Implements Serializable.  
                                            - In java.lang.  
                                        Error  
                                            - A serious problem that should not be caught (related to environment).  
                                            - Probably can't recover.  
                                            - Unchecked.   
                                            - Extends Throwable.  
                                            - In java.lang.  
                                            - Examples:  
                                                - StackOverflowError  
                                                - OutOfMemoryError  
                                                - AssertionError  
                                                - VirtualMachineError  
                                        Exception   
                                            - A "condition that a reasonable application might want to catch".  
                                            - Checked (Everything under RuntimeExceptions) & Unchecked.  
                                            - Extends Throwable.  
                                            - In java.lang.  
                                            - Examples:  
                                                - IOException  
                                                - ArrayIndexOutOfBoundsException  
                                                - NullPointerException  
                                                - ClassCastException  
-[ ] Checked vs Unchecked Exceptions  
                                        Checked Exceptions  
                                            - Checked at compile time.  
                                            - Are exceptions that a "client can reasonably be expected to recover" from.  
                                            - Methods must either handle via catch block or declare checked exceptions 
                                              with the throws keyword. 
                                        Unchecked Exceptions  
                                            - Not checked at compiled time. 
                                            - Are exceptions "a client cannot do anything to recover" from. 
-[ ] Exception Syntax  
                                        // Never catch Throwable, Error, or RuntimeException, it's supposed to fail...  
                                        try{  
                                            // Causes built-in java.lang.ArithmeticException  
                                            int badInt = 10/0;  
                                            // NOTE: The next line will never execute (but would cause custom exception):  
                                            throw new Exception("BAD STUFF");  
                                        }catch (ArithmeticException ex){  
                                            System.out.println(ex.getMessage());  
                                            System.out.println(ex.toString());  
                                        // Catch two exceptions in one catch block  
                                        } catch( NullPointerException | ArrayIndexOutOfBoundsException e) {   
                                            System.out.println(e.getMessage());  
                                        // Generic catch all:    
                                        }catch (Exception ex){  
                                            System.out.println(ex.getMessage());  
                                        // Always executes (unless thread dies), even if return was in try body:  
                                        }finally {  
                                            System.out.println("Clean up here, Close DBs, Etc...");  
                                        }  

JVM Memory & Garbage Collecting
-------------------------------
-[ ] JVM Flags  
                                        JVM Flags (note: java -X will show all -X options):  
                                            -Xss<size> - Set java thread stack size  
                                            -Xmx<size> - Set maximum memory allocation pool.    
                                            -Xms<size> - Set initial memory allocation pool.   
                                            -Xmn<size> - Set the initial and maximum size (in bytes) of the heap for 
                                                the young generation (nursery)  
                                            -XX:+UseSerialGC - To use the Serial Garbage Collector.  
                                            -XX:+UseParallelGC - To use the Parallel Garbage Collector.  
                                            -XX:+UseConcMarkSweepGC - To use the CMS (Concurrent Mark and Sweep Collector).  
                                            -XX:+UseG1GC - To use the G1 Garbage Collector.   
                                            -XX:PermGen<size> - Set initial PermGen size.  
                                            -XX:MaxPermSize<size> - Set the maximum PermGen size.  
                                            -XX:SurvivorRatio=<ratio> - Set ratio of Eden space and Survivor space.  
                                            -XX:NewRatio=<ratio> - Set ratio of old/new generation sizes (default is 2).  
-[ ] JVM Memory Tools  
                                        jstat - Command line tool to monitor the JVM memory and GC activities.  
                                        jvisualvm - GUI based tool, part of JDK.  
-[ ] JVM Stack  
                                        The JVM creates a stack for each thread.  
                                        JVM stack memory does not need to be contiguous.  
                                        The JVM pushes and pops frames off the stack; stack frame consists of three 
                                        parts: Local Variable Array (a zero-based, indexed, array of words), Operand 
                                        Stack (organized as array of words, that are pushed/poped from), and Frame Data 
                                        (contains exception table, symbolic, and constant references).   
-[ ] JVM Heap  
                                        The java Heap is divided into two main parts:  
                                            - Young Generation - has "MINOR GC", subdivided into three parts:  
                                                - Eden - Most of new objects are created here.  
                                                - Survivor0 - Objs are checked & moved from one to other survivor space.  
                                                - Survivor1 - Objs that survive many GCs move from survivor space to Old Mem.   
                                            - Old Memory - has "MAJOR GC", GC runs when full.   
                                        Objects are created on the heap.   
                                        Call hierarchy and local variables are stored on stacks.  
                                        Java Heap dump is a snapshot of the heap at any given time.  
                                        Garbage collection in the heap is mandatory.    
                                        The Heap size can only be changed on JVM startup (NOT dynamically once running).  
-[ ] JVM Permanent Generation  
                                        Permanent Generation (a.k.a. Perm Gen) contains the application metadata required 
                                        by the JVM to describe the classes and methods used in the application.  
                                        NOTE: The Perm Gen is not part of Java Heap memory.  
                                        Perm Gen is populated by JVM at runtime based on the classes used by the 
                                        application, it also contains Java SE library classes and methods.  
                                        Perm Gen objects ARE garbage collected in a full garbage collection.  
-[ ] Garbage Collection   
                                        Garbage Collection tracks each and every object available in the JVM heap space 
                                        and removes unused ones (so no memory allocation/de-allocation).  
                                        4 Implementations (a.k.a Collectors):  
                                            - Serial - Simplest, freezes all application threads when it runs.  
                                                java -XX:+UseSerialGC -jar Application.java  
                                            - Parallel (a.k.a Throughput Collectors) - Uses multiple threads for managing 
                                                heap space, also freezes other application threads while performing GC.  
                                                java -XX:+UseParallelGC -jar Application.java   
                                            - CMS (concurrent Mark n Sweep) - Uses multiple garbage collector threads 
                                                for GC, has short GC pauses, but responds slower.  
                                                java -XX:+UseParNewGC -jar Application.java  
                                            - G1 (Garbage First) - Added in Java 1.7, increases throughput and decreases 
                                                GC pause time, is the DEFAULT collector in Java 9.   
                                                java -XX:+UseG1GC -jar Application.java  
                                        An object becomes ELIGIBLE for GC when:  
                                            1. The (object's) reference variable is null.  
                                            2. The (object's) reference variable is reassigned.           
                                            3. The object was created inside a method.  
                                            4. There is a cyclic dependency where two or more objects reference each 
                                                other (and they have no other references pointing to them).  
-[ ] Request Garbage Collecting  
                                        Garbage Collecting can only be REQUESTED, not immediately forced, with:  
                                            - System.gc() - Class method, non-native method, in java.lang.System.  
                                            - Runtime.getRuntime.gc() - Instance method, native method, in java.lang.Runtime.  
-[ ] finalize() Method  
                                        The finalize() method (a.k.a finalizer) is defined in java.lang.Object and called 
                                        by the GC before collecting any object which is eligible for GC.   
                                        Finalize provides a last chance for cleanup.  

Miscellaneous Java 
------------------
-[ ] Comparator  
                                        The Comparator interface is used to order the objects of user-defined classes.  
                                        A comparator object is capable of comparing two objects of two different classes.  
                                        To implement Comparator<T>, you must implement a compare(T t1, T t2) method that 
                                        returns an int indicating the comparison.  
-[ ] Iterators  
                                        Iterators are used by the Collection framework to to traverse a collection and 
                                        for a sequential access of items in the collection.   
                                        There are three iterators:  
                                            (1) Enumeration Interface - FORWARD Read only, JDK 1, ONLY for Vector/Hashtable.  
                                            (2) Iterator - Added in Java 1.2, FORWARD Read and Remove, works on ALL 
                                                Collections, can't Replace or Add new elements.  
                                            (3) ListIterator - BI-DIRECTIONAL, CAN Remove/Add/Set, List Collection ONLY.  
-[ ] Iterator vs Enumeration vs
     For-Each vs ListIterator    
                                        Iterator  
                                            - Works on ALL Collections objects,   
                                            - Forward Read and Remove.  
                                        Enumeration  
                                            - OLD,  
                                            - Forward Read ONLY,  
                                            - Vector and Hashtable ONLY.  
                                        For-Each 
                                            - Is for traversal,  
                                            - CAN'T modify collection (throws ConcurrentModificationException).  
                                        ListIterator  
                                            - Extends Iterator,  
                                            - Lists ONLY,  
                                            - BI-DIRECTIONAL Add, Remove, and Set.  
-[ ] Stream (Collection)  
                                        Takes input from the Collections, Arrays, or I/O channels perform Intermediate
                                        and Terminal Operations to augment the data.  
-[ ] Lambda Expressions  
                                        Can replace Anonymous Classes with single methods.  
                                        Local vars referenced from a Lambda Expression must be final or effectively final.  
-[ ] Map  
                                        List<Integer> numbers = Arrays.asList(2,2,3,4,5,3,6,7,8,9);  
                                        List<Integer> listInteger = numbers.stream().map(
                                            x-> x * x ).collect(Collectors.toList());  
-[ ] Filter  
                                        List<String> names = Arrays.asList("Matthew", "Brenton", "Chris", "Michelle");  
                                        List<String> filteredNames = names.stream().filter(
                                            s->s.startsWith("M")).collect(Collectors.toList());  
-[ ] Reduce  
                                        int even = numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);  
-[ ] Access Modifiers    
                                        Restrict the scope of a class, constructor, variable, method, or data member.    
                                        Scope                           | default   | private   | protected | public      
                                        |:-----------------------------:|:---------:|:---------:|:---------:|:------:|  
                                        Same Class                      | Yes       | Yes       | Yes       | Yes  
                                        Same Package Subclass           | Yes       | No        | Yes       | Yes  
                                        Same Package Non-Subclass       | Yes       | No        | Yes       | Yes  
                                        Different Package Subclass      | No        | No        | Yes       | Yes  
                                        Different Package Non-Subclass  | No        | No        | No        | Yes  
-[ ] Logging  
                                        Java Util Logging - Limited, not really used.  
                                        Log4J - Has Log levels (e.g. ERROR, INFO, DEBUG), Loggers (entry point of Log4j),
                                          and Appenders (output to a single destination type).  
                                        Others: Apache Commons Logging, SLF4J, Log4J2, etc...  
-[ ] Marker Interface  
                                        An interface that has no methods or constants inside it, and is intended to 
                                        provide information to the compiler and JVM.  
-[ ] Serializable Interface   
                                        A Marker Interface that provides serialization, or writes objects states to a 
                                        file via ObjectOutputStream.writeObject(Object o) & ObjectInputStream.readObject().  
                                        Uses default serialization (does not serialize static or transient variables).  
-[ ] Externalizable Interface                                        
                                        Externalizable extends Serializable, allows for more flexibility and control of 
                                        object serialization by defining what variables are written/read (via it's
                                        writeExternal() and readExternal() methods).  
-[ ] serialVersionUID  
                                        UID used by the Serialization API to validate if a source (read from) and a
                                        destination (wrote to) are compatible.                                        
-[ ] Comparable Interface  
                                        The (one) "natural order" for an object.  
                                        Provides a SINGLE sorting sequence (i.e., can sort on only one attribute like id).  
                                        Affects the original class, (actual class must "implements Comparable").  
                                        Provides the compareTo() method to sort elements.  
                                        Is in the java.lang package.  
                                        USE the Collections.sort(List) method to sort Comparable type elements.  
-[ ] Comparator Interface  
                                        Provides MULTIPLE sorting sequences (i.e., can sort ele on multiple attributes
                                        such as id, name, price).  
                                        Does NOT affect the original class (is defined external to the original class).  
                                        Provides the compare() method to sort elements.  
                                        Is in the java.util package.  
                                        USE the Collections.sort(List, Comparator) method to sort Comparator type elements.  
-[ ] Comparators   
                                        Is a package private supporting class for the Comparator Interface.   
-[ ] Comparable vs Comparator vs 
     Comparators  
                                        Comparable Interface  
                                            - Provides a SINGLE sorting seq (the "natural order"),  
                                            - DOES affect the original class,  
                                            - Has compareTo() method.  
                                        Comparator Interface  
                                            - Provides multiple sorting sequences (different elements of an object),  
                                            - DOESN'T affect the original class,  
                                            - Has compare() method.  
                                        Comparators  
                                            - Is a package private supporting class for the Comparator Interface.  
-[ ] final vs finally, vs finalize  
                                        final - The final statement has different meaning depending on its context:  
                                            final primitiveVar - The value of the variable CAN'T change.  
                                            final referenceVar - The reference var CAN'T point to any other obj on the heap.  
                                            final method() - The method CAN'T be overridden.  
                                            final class{} - The class CAN'T be subclassed.   
                                        finally - An optional finally block after the try or catch block; statements in 
                                            finally block will ALWAYS be executed, even if an exception is thrown (except
                                            if the JVM exits from the try block), and even if there is a return inside  
                                            the try block.  
                                        finalize - An objects method called by the Garbage Collector before the GC 
                                        destroys the object.   
-[ ] Object Reflection  
                                        Object Reflection is a feature in Java that provides a way to get reflective 
                                        information about Java classes and objects, and perform operations such as:  
                                            - Get info about the methods and fields present inside the class at runtime.  
                                            - Creating a new instance of a class.  
                                            - Get/Set obj fields directly via field ref, regardless of access modifier.  
                                        This helps to observe/manipulate runtime behavior, debug or test programs, and 
                                        to call methods by name (when you don't know them in advance).  
  
Testing & JUnit 
---------------
-[ ] JUnit 4 vs JUnit 5  
                                        JUnit 4   
                                            - JDK 5 or later.  
                                            - Single jar (different architecture).  
                                            - Different Annotations.  
                                            - Different Assertions Argument Orders.  
                                        JUnit 5  
                                            - JDK 8 or later.  
                                            - Three sub-projects:  
                                                - JUnit Platform,   
                                                - JUnit Jupiter,   
                                                - JUnit Vintage.   
                                            - Different Annotations.   
                                            - Different Assertions Argument Orders.  
-[ ] Annotations  
                                        JUnit 4                  JUnit 5  
                                        @Test                    @Test               
                                        @RunsWith                @RunsWith  
                                        @Before          -->     @BeforeEach  
                                        @BeforeClass     -->     @BeforeAll  
                                        @After           -->     @AfterEach  
                                        @AfterClass      -->     @AfterAll  
                                        @Ignore          -->     @Disable  
                                        @Category        -->     @Tag  
                                        N/A              -->     @Nested            
                                        N/A              -->     @TestFactory       
                                        N/A              -->     @ExtendWith         
                                        N/A              -->     @SelectPackages  
                                        N/A              -->     @SelectClasses  
                                        N/A              -->     @DisplayName()       
                                        N/A              -->     @RepeatedTest()      
                                        N/A              -->     @TestInstance  
-[ ] Assertions  
                                        JUnit uses assertions to assert conditions in tests.   
                                        Common assertions include:  
                                            - assertEquals()    
                                            - assertNotEquals()  
                                            - assertSame()      
                                            - assertNotSame()  
                                            - assertFalse()   
                                            - assertTrue()  
                                            - assertThrows()  
                                            - assertArrayEquals()  
                                            - assertIterableEquals()  
                                            - assertLinesMatch()  
                                            - assertTimeout()  
                                            - assertTimeoutPreemptively()  
                                            - assertAll()  
-[ ] Assumptions  
                                        Assumptions (or a boolean value), can be supplied to some assertions and dictate 
                                        if that assertion is executed (true) or not executed (false).  
                                        
                                        


