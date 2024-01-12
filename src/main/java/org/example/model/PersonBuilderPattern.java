package org.example.model;

public class PersonBuilderPattern {
    private String name;
    private int age;

    public PersonBuilderPattern(PersonBuilder personBuilder) {
        this.name=personBuilder.name;
        this.age=personBuilder.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static class PersonBuilder{
        private String name;
        private int age;

        private PersonBuilder(){

        }

        public static PersonBuilder builder(){
            return new PersonBuilder();
//            we're returning object here to the class
        }
        public PersonBuilder setName(String name){
            this.name=name;
            return this;
        }
        public PersonBuilder setAge(int age){
            this.age=age;
            return this;
        }
        public PersonBuilderPattern build (){
            return new PersonBuilderPattern(this);
        }
    }

}

