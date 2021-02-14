package com.company;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void printArrayWords(String[] arr){
        //Разбираем массив в хешмап, где слова - ключи, а количество вхождений - значение.
        HashMap<String,Integer > map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) { //такой ключ уже есть, увеличиваем на единицу
                map.put(arr[i],map.get(arr[i])+1);
            } else { //такого ключа еще нет, добавляем
                map.put(arr[i], 1);
            }
        }
        //По итогу, получаем хешмапу, где ключом является слово из массива, а значением является количество его вхождений
        // Соотвественно, те ключи, которые имеют знчение 1, уникальные, а те, значение которых больше единицы - их количество равно значению.
        
        //печатаем уникальные слова
        System.out.println("************Уникальные слова************");
        for (Map.Entry<String, Integer> o: map.entrySet()) {
            if(o.getValue() == 1) { //слово уникальное, печатаем
                System.out.println(o.getKey());
        }
        }
        //печатаем количество вхождений всех слов
        System.out.println("************Все слова************");
        for (Map.Entry<String, Integer> o: map.entrySet() ) {
            System.out.println("Слово: " + o.getKey() + " имеется в массиве в количестве " + o.getValue());
        }

    }

    public static void main(String[] args) {
        String[] array = new String[] {"Один", "Локи", "Тюр", "Тор", "Фрейр", "Один", "Фрейя", "Локи","Хеймдалль", "Один", "Фригг", "Ньёрд", "Вотан", "Эйр", "Фригг", "Хедр", "Лофн"};
        printArrayWords(array);

        TelephoneDirectory directory = new TelephoneDirectory();
        directory.addRecord("Буш", 87651313);
        directory.addRecord("Рейган", 31231);
        directory.addRecord("Обама", 2654948);
        directory.addRecord("Обама", 22132132);
        directory.addRecord("Обама", 7894351);
        directory.addRecord("Клинтон", 16546);
        directory.addRecord("Левински", 48489);
        directory.addRecord("Левински", 786513);
        directory.addRecord("Кеннеди", 4651329);

        directory.findNumbersBySurname("Обама");
        directory.findNumbersBySurname("Рейган");
        directory.findNumbersBySurname("Левински");

    }
}

