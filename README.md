# Reactive-Programming-with-Spring-Framework-5




What is Reactive Programming?

Reactive Programming

• Reactive Programming is an asynchronous programming paradigm focused on streams of data.
• “Reactive programs also maintain a continuous interaction with their environment, but at a speed which is determined by the
environment, not the program itself. Interactive programs work at their own pace and mostly deal with communication, while
reactive programs only work in response to external demands and mostly deal with accurate interrupt handling. Real-time programs are usually reactive.”
        - Gerad Berry, French Computer Scientist

Common Use Cases
• External Service Calls
• Highly Concurrent Message Consumers
• Spreadsheets
• Abstraction Over Asynchronous Processing
    - Abstract whether or not your program is synchronous or asynchronous

Features of Reactive Programming
• Data Streams
• Asynchronous
• Non-blocking
• Backpressure
• Failures as Messages

Key Take Aways
• Reactive Programming focuses on processing streams of data.
• Traditional CRUD applications are still alive and well.



Reactive Streams
• On April 30th, 2015, version 1.0.0 of Reactive Streams was released.
• Under JEP-266, Reactive Streams is now part of the Java 9 JDK.
• Adoptions: Akka Streams, MongoDB, Ratpack, Reactive Rabbit, Project Reactor (Spring 5), RxJava, Slick 3.0, Vert.x 3.0, Cassandra, ElasticSearch, Kafka, Play


What is Functional Programming?





Imperative Example



Functional Example




Imperative vs Declarative





Section 5: Using Java Streams

What is a Stream?
• At the simplest, a Stream is a sequence of elements
• A ‘stream’ is not a collection.
• Collections are in-memory data structures
• Collections are eagerly computed
• Streams can operate on collections
• Streams are lazily evaluated
