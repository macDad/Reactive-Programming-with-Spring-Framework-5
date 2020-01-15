package com.mac.springframework.netfluxexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@SpringBootTest
public class FunctionalProgrammingExamples {
    /* 4 properties of a function
     * 1. name
     * 2. return type
     * 3. parameter list
     * 4. body
     */

    @Test
    public void functionWith4Things() throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In thread t1");
            }
        });

        t1.start();

        System.out.println("In Main Test");
    }

    @Test
    public void lambdaExpression() throws Exception {
        /* lambda expression
         *	(parameter list) -> body
         * 1. name - anonymous
         * 2. return type - can be inferred
         * 3. parameter list
         * 4. body
         */
        Thread t1 = new Thread(() -> System.out.println("In thread t1"));
        // Constructor is a higher order function,
        // function is a first class citizen
        t1.start();

        System.out.println("In Main Test");
    }

    @Test
    public void listiteratorHighCeremony() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i));
        }
        //very complex, requires a lot of knowledge of code, a lot to go wrong
    }

    @Test
    public void listiteratorLessCeremonyExternalIter() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        for (String dog : dogs) {
            System.out.println(dog);
        }
        //simple, still using external iterator
    }

    @Test
    public void listInternalIterConsumer() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        dogs.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    @Test
    public void listInternalIterlambdaMethod() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        dogs.forEach((String s) -> System.out.println(s));
    }

    @Test
    public void listInternalIterlambdaMethodTypeInference() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        dogs.forEach((s) -> System.out.println(s)); // inferred by compiler
    }

    @Test
    public void listInternalIterlambdaMethodTypeInferenceJustOne() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        //drop () if we have one, still need for none or more then one parameter
        dogs.forEach(s -> System.out.println(s)); // inferred by compiler
    }

    @Test
    public void listInternalIterlambdaMethodTypeJava8MethodRef() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        //java 8 method Ref
        dogs.forEach(System.out::println);
    }

    @Test
    public void countDogsWithSixCharactersImp() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        int dogCount = 0;
        for (String dog : dogs) { // external iterator
            if (dog.length() == 6) {
                dogCount++; // note dogCount is mutating
            }
        }
        System.out.println(dogCount);
    }

    @Test
    public void countDogsWithSixCharactersDec() {
        List<String> dogs = Arrays.asList("Vizsla", "lab", "Golden", "GSP", "POODLE", "Yorkie", "Mutt");
        //no mutability
        System.out.println(dogs.stream() //like iterator java 8 Streams
                .filter(dog -> dog.length() == 6)
                .collect(Collectors.toList())// filter condition
                .size());

        /*-------------------- OR ------------------------*/

        System.out.println(dogs.stream() //like iterator java 8 Streams
                .filter(dog -> dog.length() == 6) // filter condition
                .count());
    }
}
