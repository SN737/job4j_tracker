package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
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
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        String id = item.getId() + "";
        Input input = new MockInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenDeleteItemMyVer() {
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
    void whenCreateItemMyVer() {
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
        String[] select = {"0", "new item", "3", "1", "6"};
        new StartUI().init(new MockInput(select), tracker, actions);
        Item deleted = tracker.findById(1);
        assertThat(deleted).isEqualTo(null);
    }
}