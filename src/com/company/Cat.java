package com.company;

public class Cat extends Animal {
    private static int countCats = 0;
    public Cat (String name, String color, int age) {
        super(name, color, age, 200, 0);
        countCats++;
    }
    public int getCatsQuantity() { return countCats; }
    @Override
    public void run(int range) {
        if(range<=getLimitRun()) {
            System.out.println("Кот " + getName() + " пробежал " + range + " метров!");
        } else {
            System.out.println("Кот " + getName() + " не любит далеко бегать, тем более на  " + range + " метров, он неторопливо пробежал лишь " + getLimitRun() + " метров!");
        }
    }

    @Override
    public void swim(int range) {
        System.out.println("Коты вообще не любят плавать, а заставить котов делать то, что они не хотят, невозможно. Поэтому, кот по имени " +
                getName() + " никуда не поплыл, тем более, на " + range + " метров!");
    }
}
