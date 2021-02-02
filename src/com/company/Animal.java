package com.company;

public abstract class Animal {
    private String name;
    private String color;
    private int age;
    private int limitRun = 0;
    private int limitSwim = 0;
    private static int countAnimals = 0;

    public Animal(String name, String color, int age, int limitRun, int limitSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        countAnimals++;
    }
    public int getLimitRun() {  return limitRun; }
    public int getLimitSwim() { return limitSwim; }
    public String getName() { return name; }
    public static int getAnimalsQuantity() { return countAnimals; }
    public abstract void run(int range);
    public abstract void swim(int range);

}
