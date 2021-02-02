package com.company;

public class Dog extends Animal {
    private static int countDogs = 0;
    public Dog(String name, String color, int age) {
        super(name,color, age, 500, 10);
        countDogs++;
    }
    public int getDogsQuantity() { return countDogs; }
    @Override
    public void swim(int range) {
        if(range<=getLimitSwim()) {
            System.out.println("Пес " + getName() + " проплыл " + range + " метров!");
        } else {
            System.out.println("Пес " + getName() + " благоразумно не стал плыть на расстояние " + range + " метров!");
        }
    }

    @Override
    public void run(int range) {
        if(range<=getLimitRun()) {
            System.out.println("Пес " + getName() + " пробежал " + range + " метров!");
        } else {
            System.out.println("Пес " + getName() + " не смог пробежать " + range + " метров, пробежав лишь " + getLimitRun() + " метров!");
        }
    }
}
