package com.company;

import java.util.ArrayList;

//Класс телефонного справочника
public class TelephoneDirectory {
    private ArrayList<TelephoneDirectoryEntry> records;  //массив записей в телефонном справочнике

    public TelephoneDirectory() { //по умолчанию, массив будет из 10 записей
        records = new ArrayList<TelephoneDirectoryEntry>(10);
    }
    //метод, добавляющий запись в массив
    public void add (String surname, int number) {
        if(records.size() == 0) { //Если массив пустой
            records.add(new TelephoneDirectoryEntry(surname, number)); //то просто добавляем первую запись
        } else {  //массив не пустой
            boolean isAddedFlag = false; //флаг добавления записи, нужен для избежания добавления дубликатов
            for (int i = 0; i < records.size(); i++) { // перебор всего массива записей
                if(surname.equals(records.get(i).getSurname())   ) { //если фамилии одинаковые,
                    isAddedFlag = true;
                    records.get(i).addNumber(number); //добавляем номер в уже существующую запись
                }
            }
            if(isAddedFlag == false) { //существующей фамилии найдено не было, значит, просто добаляем новую запись
                records.add(new TelephoneDirectoryEntry(surname, number));
            }
        }
    }
    //Метод, печатающий все номера абонента
    public void get (String surname) {
        if(records.size()>0) { //записи есть
            TelephoneDirectoryEntry[] arr = new TelephoneDirectoryEntry[records.size()];
            records.toArray(arr);
            for (int i = 0; i < arr.length; i++) {
                if(surname.equals(arr[i].getSurname())) { //фамилии совпадают, печатаем
                    System.out.println("Абонент по фамилии: " + surname + " имеет следующие номера телефонов: ");
                    arr[i].printNumbers();
                }
            }

        } else { //записей нет
            System.out.println("Телефонный справочник пуст! Купите новый, с номерами и фамилиями!");
        }
    }

    //внутренний класс записи в TelephoneDirectory
    //Содержит фамилию абонента и массив его номеров.
    //Массив объектов этого класса будет храниться в TelephoneDirectory
    class TelephoneDirectoryEntry {
        private String surname; //Хранит фамилию
        private ArrayList<Integer> numbers; //Массив номеров телефонов
        public TelephoneDirectoryEntry (String surname, int number) { //создаем сразу с одним номером
            this.surname = surname;
            this.numbers = new ArrayList<>();
            numbers.add(number);
        }
        public String getSurname () { //возвращает фамилию
            return surname;
        }
        public ArrayList<Integer> getNumbers() { //Сделано на всякий случай, если понадобится весь массив номеров абонента
            return numbers;
        }
        public void addNumber(int number) { //добавляем номер абоненту
            numbers.add(number);
        }
        public void printNumbers() { //печатаем все номера абонента
            Integer[] arr = new Integer[numbers.size()];
            numbers.toArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
