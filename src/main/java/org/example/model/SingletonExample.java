package org.example.model;

public class SingletonExample {
    private static SingletonExample singletonExample=new SingletonExample();
    private SingletonExample(){}
    public static SingletonExample getInstance(){
        return singletonExample;
    }
    public String getWelcomeMessage (){
        return "Hello from Singleton.";
    }
}
