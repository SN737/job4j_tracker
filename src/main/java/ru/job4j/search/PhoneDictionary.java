package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

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
    @Deprecated
    /*
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person element : persons) {
            if (element.getName().contains(key) || element.getSurname().contains(key)
                    || element.getPhone().contains(key) || element.getAddress().contains(key)) {
                result.add(element);
            }
        }
        return result;
    }
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> byName = person -> person.getName().contains(key);
        Predicate<Person> bySurname = person -> person.getSurname().contains(key);
        Predicate<Person> byAddress = person -> person.getAddress().contains(key);
        Predicate<Person> byPhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = byName.or(bySurname.or(byAddress.or(byPhone)));
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}