package com.company;


public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Чубайс", "рыжий", 10);
        Cat cat2 = new Cat("Шнурок", "серый", 4);
        Dog dog1 = new Dog("Шарнир", "блондин", 5);
        Dog dog2 = new Dog("Мелкий", "черный", 5);

        cat1.run(300);
        cat2.run(150);
        cat1.swim(50);
        cat2.swim(5);

        dog1.run(550);
        dog2.run(300);
        dog1.swim(5);
        dog2.swim(11);

        System.out.println("Всего у нас животных " + dog1.getAnimalsQuantity() + " штук!");
        System.out.println("Всего КОТЭ у нас " + cat1.getCatsQuantity() + " штук!");
        System.out.println("Всего песелей у нас " + dog1.getDogsQuantity() + " штук!");
    }

}

