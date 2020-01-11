package com.mpettersson.questions.java;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

/**
 *  OBJECT REFLECTION
 *
 *  Explain what object reflection is in Java and why it is useful.
 *
 *
 *  SOLUTION (See https://www.geeksforgeeks.org/reflection-in-java/)
 *
 *  Reflection is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.
 *      - The required classes for reflection are provided under java.lang.reflect package.
 *      - Reflection gives us information about the class to which an object belongs and also the methods of that class
 *        which can be executed by using the object.
 *      - Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.
 *
 *  Advantages of Using Reflection:
 *      - Extensibility Features: An application may make use of external, user-defined classes by creating instances
 *                                of extensibility objects using their fully-qualified names.
 *      - Debugging and testing tools: Debuggers use the property of reflection to examine private members on classes.
 *
 * Drawbacks:
 *      - Performance Overhead: Reflective operations have slower performance than their non-reflective counterparts,
 *                              and should be avoided in sections of code which are called frequently in
 *                              performance-sensitive applications.
 *      - Exposure of Internals: Reflective code breaks abstractions and therefore may change behavior with upgrades
 *                               of the platform.
 */

// class whose object is to be created
class TestClass {
    // creating a private field
    private String s;

    // creating a public constructor
    public TestClass() { s = "GeeksforGeeks"; }

    // Creating a public method with no arguments
    public void method1() {
        System.out.println("The string is " + s);
    }

    // Creating a public method with int as argument
    public void method2(int n) {
        System.out.println("The number is " + n);
    }

    // creating a private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}

public class ObjectReflection {

    // Function to check String for only Alphabets
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null)
                && (!str.equals(""))
                && (str.chars().allMatch(Character::isLetter)));
    }



    public static void main(String args[]) throws Exception {
        // Creating object whose property is to be checked
        TestClass obj = new TestClass();

        // Creating class object from the object using
        // getclass method
        Class cls = obj.getClass();
        System.out.println("The name of class is " +
                cls.getName());

        // Getting the constructor of the class through the
        // object of the class
        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " +
                constructor.getName());

        System.out.println("The public methods of class are : ");

        // Getting methods of the class through the object
        // of the class by using getMethods
        Method[] methods = cls.getMethods();

        // Printing method names
        for (Method method:methods)
            System.out.println(method.getName());

        // creates object of desired method by providing the
        // method name and parameter class as arguments to
        // the getDeclaredMethod
        Method methodcall1 = cls.getDeclaredMethod("method2",
                int.class);

        // invokes the method at runtime
        methodcall1.invoke(obj, 19);

        // creates object of the desired field by providing
        // the name of field as argument to the
        // getDeclaredField method
        Field field = cls.getDeclaredField("s");

        // allows the object to access the field irrespective
        // of the access specifier used with the field
        field.setAccessible(true);

        // takes object and the new value to be assigned
        // to the field as arguments
        field.set(obj, "JAVA");

        // Creates object of desired method by providing the
        // method name as argument to the getDeclaredMethod
        Method methodcall2 = cls.getDeclaredMethod("method1");

        // invokes the method at runtime
        methodcall2.invoke(obj);

        // Creates object of the desired method by providing
        // the name of method as argument to the
        // getDeclaredMethod method
        Method methodcall3 = cls.getDeclaredMethod("method3");

        // allows the object to access the method irrespective
        // of the access specifier used with the method
        methodcall3.setAccessible(true);

        // invokes the method at runtime
        methodcall3.invoke(obj);
    }
}
