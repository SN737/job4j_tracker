package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student ivanov = new Student();
        ivanov.setName("Ivan Ivanov");
        ivanov.setGroup(35);
        ivanov.setDateOfStart("22-02-2022");
        System.out.println("ФИО: " + ivanov.getName()
                + " группа: " + ivanov.getGroup()
                + " дата поступления: " + ivanov.getDateOfStart());
    }
}
