package com.company;

public class Plate {
    private int food;

    public void addFood(int food) {
        this.food = this.food + food;
    }
    public int getFood() {
        return  food;
    }
    public void decreaseFood(int quantity) {
        if (food >= quantity) { food = food - quantity; }
    }
}
