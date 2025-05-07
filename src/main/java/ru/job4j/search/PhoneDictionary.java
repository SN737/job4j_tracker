package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person element : persons) {
            if (element.getName().contains(key) || element.getSurname().contains(key)
                    || element.getPhone().contains(key) || element.getAddress().contains(key)) {
                result.add(element);
                break;
            }
        }
        return result;
    }
}