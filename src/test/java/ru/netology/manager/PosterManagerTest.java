package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();

    Movie first = new Movie(1, "first", "ved1", "detective");
    Movie second = new Movie(2, "second", "ruby2", "horror");
    Movie tri = new Movie(3, "third", "ved3", "drama");

    @Test
    void addAtEmpty() {
        manager.add(first);

        assertArrayEquals(new Movie[]{first}, manager.getAll());
//        Как проверить метод add без метода getAll? Ведь второй метод может не работать... Заглушки?
//        Получается и getAll уже проверена без конструктора.
    }

    @Test
    void addTwoElements() {
        manager.add(first);
        manager.add(second);

        assertArrayEquals(new Movie[]{second, first}, manager.getAll());
    }

    @Test
    void addThreeElements() {
        manager.add(first);
        manager.add(second);
        manager.add(tri);

        assertArrayEquals(new Movie[]{tri, second, first}, manager.getAll());
    }

    @Test
    void getAllViaConstructorUnder() {
        PosterManager manager2 = new PosterManager(1);

        manager2.add(first);
        manager2.add(second);
        manager2.add(tri);

        assertArrayEquals(new Movie[]{tri}, manager2.getAll());
    }

    @Test
    void getAllViaConstructorAbove() {
        PosterManager manager2 = new PosterManager(5);

        manager2.add(first);
        manager2.add(second);
        manager2.add(tri);

        assertArrayEquals(new Movie[]{tri, second, first}, manager2.getAll());
    }
}