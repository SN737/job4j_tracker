package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

/**
 * Класс описывает работу банковской системы.
 * Реализованы такие действия как добавление/удаление/поиск по паспорту пользователей,
 * добавление/поиск по реквизитам счета
 * @author Jack Hughes
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы и связанных с ними счетов. Коллекция представляет собой
     * отображение типа HashMap, где ключ - пользователь, а значение - список счетов этого
     * пользователя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в список, если его еще в нем нет
     *
     * @param user пользователь для добавления в список
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Выполняет удаление пользователя по номеру паспорта
     * @param passport номер паспорта удаляемого пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счет в список счетов пользователя, найденного по номеру паспорта. Если счет
     * уже существует в системе, то он не добавляется.
     * @param passport номер паспорта пользователя
     * @param account новый счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по указанному номеру паспорта
     *
     * @param passport номер паспорта искомого пользователя
     * @return User || null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод выполняет поиск счета по номеру паспорта пользователя и реквизитам счета
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return объект счета, если он есть в системе, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод выполняет перевод денежных средств с одного счета на другой, если такие счета существуют
     * и сумма перевода не превышает баланс на счете отправителя
     * @param sourcePassport номер паспорта отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport номер паспорта получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма денежных средств для перевода
     * @return true, если перевод выполнен успешно, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null) {
            if (sourceAccount.getBalance() >= amount) {
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                destinationAccount.setBalance(destinationAccount.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Возвращает список счетов пользователя
     * @param user пользователь
     * @return список счетов, иначе null
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}