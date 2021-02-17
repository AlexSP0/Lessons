package com.company;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        //печатаем количество вхождений всех слов
        System.out.println("************Все слова************");
        for (Map.Entry<String, Integer> o: map.entrySet() ) {
            System.out.println("Слово: " + o.getKey() + " имеется в массиве в количестве " + o.getValue());
        }

    }

    public static void main(String[] args) {
        String[] array = new String[] {"Один", "Локи", "Тюр", "Тор", "Фрейр", "Один", "Фрейя", "Локи","Хеймдалль", "Один", "Фригг", "Ньёрд", "Вотан", "Эйр", "Фригг", "Хедр", "Лофн"};
        //Задание 1
        printArrayWords(array);

        //Задание 2
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.add("Обама", "8917987456");
        directory.add("Вашингтон", "15456879");
        directory.add("Клинтон", "1778432184651");
        directory.add("Левински", "4654621");
        directory.add("Левински", "4654621"); //дубль не попадет в номера, так как Set может содержать только уникальные объекты
        directory.add("Кеннеди", "1654654");
        directory.add("Кеннеди", "6541351321654654");
        directory.add("Обама", "1561");
        directory.add("Обама", "6132132132132132132154616211");
        directory.add("Рейган", "651651651");

        System.out.println("");
        printNumbers("Обама", directory);
        printNumbers("Левински", directory);
        printNumbers("Кеннеди", directory);
        printNumbers("Ельцин", directory);


    }
    public static void printNumbers(String surname, TelephoneDirectory dir) {
        Set<String> num;
        num = dir.get(surname);
        if(num != null) { //фамилия присутствует в телефонном справочнике
            System.out.println("Абонент: " + surname);
            for (String s:
                 num) {
                System.out.println(s);
            }
        } else { //такой фамилии нет в телефонном справочнике
            System.out.println("Нет такой фамилии.");
        }
    }
}

