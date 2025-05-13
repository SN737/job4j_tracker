package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTest {
    @Test
    void whenSortingAscend() {
        List<Item> items = Arrays.asList(
                new Item (14, "Item"),
                new Item (34, "New Item"),
                new Item (43, "Another Item")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item (43, "Another Item"),
                new Item (14, "Item"),
                new Item (34, "New Item")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenSortingDescent() {
        List<Item> items = Arrays.asList(
                new Item (14, "Fix something"),
                new Item (34, "Implementing"),
                new Item (43, "Broken")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item (34, "Implementing"),
                new Item (14, "Fix something"),
                new Item (43, "Broken")
        );
        assertThat(items).isEqualTo(expected);
    }

}
