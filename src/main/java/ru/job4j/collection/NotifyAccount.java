package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> result = new HashSet<>();
        /*result.addAll(accounts);*/
        for (Account element : accounts) {
            result.add(element);
            }
        return result;
    }
}
