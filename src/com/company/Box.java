package com.company;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> contents = new ArrayList<>();

    public float getWeight() {
        if(contents.size() !=0) {
            float sum=0;
            for (T fruit:contents ) {
                sum = sum + fruit.getWeight();
            }
            return sum;
        }
        return 0f;
    }
    public boolean compare(Box<?> box2) {
        return this.getWeight() == box2.getWeight() ? true : false;
    }

    public void add(T fruit) {
        contents.add(fruit);
    }


    public void transfer(Box<T> box) {
            for (T fruit : contents) {
                box.add(fruit);
            contents.clear();
        }
    }
}
