package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {

    @Test
    public void shouldAddAllFilms() {
        FilmsManager manager = new FilmsManager();

        manager.add("film1");
        manager.add("film2");
        manager.add("film3");

        String[] expected = {"film1", "film2", "film3"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneFilm(){
        FilmsManager manager = new FilmsManager();

        manager.add("film1");

        String[] expected = {"film1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNilFilm(){
        FilmsManager manager = new FilmsManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLatestFilmsReverseOrder() {
        FilmsManager manager = new FilmsManager(5);

        manager.add("film1");
        manager.add("film2");
        manager.add("film3");
        manager.add("film4");
        manager.add("film5");

        String[] expected = {"film5", "film4", "film3", "film2", "film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLatestFilmsReverseOrderLessLimit() {
        FilmsManager manager = new FilmsManager(5);

        manager.add("film1");
        manager.add("film2");
        manager.add("film3");
        manager.add("film4");

        String[] expected = {"film4", "film3", "film2", "film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLatestFilmsReverseOrderOverLimit() {
        FilmsManager manager = new FilmsManager(5);

        manager.add("film1");
        manager.add("film2");
        manager.add("film3");
        manager.add("film4");
        manager.add("film5");
        manager.add("film6");
        manager.add("film7");



        String[] expected = {"film7", "film6", "film5", "film4", "film3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
