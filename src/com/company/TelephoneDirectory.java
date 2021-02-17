package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Класс телефонного справочника
public class TelephoneDirectory {
    private HashMap<String, Set> records = new HashMap<>();  //массив записей в телефонном справочнике


    public void add (String surname, String number) {
        Set numbers;
        if(records.containsKey(surname)) { //Такая фамилия в справочнике есть
            numbers = (Set) records.get(surname); //получаем множество номеров существующей фамилии
        } else { //такой фамилии в справочнике нет
            numbers = new HashSet(); //создаем новое множество номеров
        }
        numbers.add(number); //добавляем во множество новый номер. Так ка в Set'е только уникальные элементы, то дублирования номеров НЕ БУДЕТ
        records.put(surname, numbers); // помещаем готовый Set в HashMap. Если такая фамилия есть, то она перезапишется новым значением
    }
    //Метод, печатающий все номера абонента
    public Set get (String surname) {
        return records.containsKey(surname) ? records.get(surname) : null; //Если ключ с фамилией найден, то возвращаем множество номеров.
    }
}
