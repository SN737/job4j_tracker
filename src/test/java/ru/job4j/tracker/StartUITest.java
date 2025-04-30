package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
//    @Test
//    void whenAddItem() {
//        String[] answers = {"Fix PC"};
//        Input input = new MockInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("Fix PC");
//        assertThat(created.getName()).isEqualTo(expected.getName());
//    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        String[] select = {"0", "new item", "6"};
        new StartUI().init(new MockInput(select), tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("new item");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenCreateItem() {
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        String[] select = {"0", "new item", "3", "1" ,"6"};
        new StartUI().init(new MockInput(select), tracker, actions);
        Item deleted = tracker.findById(1);
        assertThat(deleted).isEqualTo(null);
    }
}