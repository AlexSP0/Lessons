package com.company;

public class Cat  {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat (String name,  int app) {
        this.name = name;
        appetite = app;
    }
    public void eat(Plate plate) {
        if (satiety  || plate.getFood() < appetite) {
            System.out.println("Эй, бесхвостый," +name + " это есть не будет!");
        } else {
            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println("Мог бы подать что-нибудь и повкуснее. Я же сам " + name);
        }
    }
    public void isFullCat (){
        if (satiety == true) {
            System.out.println(name + " сыт, можешь быть свободен!");
        } else {
            System.out.println("Так ты еще тут?! Неси еду!" + name + " уже 5 минут как голодный!");
        }
    }
}
