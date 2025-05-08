package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


class StartUITest {
    Output output = new ConsoleOutput();

    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new  CreateAction(output));
                actions.add(new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item")); /* Добавляется в tracker новая заявка */
        String replacedName = "New item name";
        String id = item.getId() + "";
        Input input = new MockInput(
                new String[] {"0", id, replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ReplaceAction(output));
                actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        String id = item.getId() + "";
        Input input = new MockInput(
                new String[]{"0", id, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();


    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "===Завершение программы===" + System.lineSeparator()
        );
    }

    @Test
    void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
                Input input = new MockInput(
                new String[] {"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new FindAllAction(output));
                actions.add(new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "===Завершение программы===" + ln
        );
    }

    @Test
    void whenFindByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Input input = new MockInput(
                new String[] {"0", "test", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new FindByNameAction(output));
                actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "===Завершение программы===" + ln
        );
    }

    @Test
    void whenFindByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        String id = String.valueOf(one.getId());
        Input input = new MockInput(
                new String[] {"0", id, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new FindByIdAction(output));
                actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "===Завершение программы===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"8", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать от 0 до " + (actions.size() - 1) + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "===Завершение программы===" + ln
        );
    }

}