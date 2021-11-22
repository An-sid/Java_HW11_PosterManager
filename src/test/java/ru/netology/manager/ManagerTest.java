package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    // подготавливаем тестовые данные
    Movie film1 = new Movie("quarantine2008", "ref", "Quarantine", "Action");
    Movie film2 = new Movie("taken2008", "ref", "Taken", "Action");
    Movie film3 = new Movie("hulk2008", "ref", "Hulk", "Action");
    Movie film4 = new Movie("rambo2008", "ref", "Rambo", "Action");
    Movie film5 = new Movie("race2008", "ref", "Race", "Action");
    Movie film6 = new Movie("sunday2008", "ref", "Sunday", "Action");
    Movie film7 = new Movie("hancock2008", "ref", "Hancock", "Action");
    Movie film8 = new Movie("wanted2008", "ref", "Wanted", "Action");
    Movie film9 = new Movie("jumper2008", "ref", "Jamper", "Action");
    Movie film10 = new Movie("mummy2008", "ref", "Mummy", "Action");
    // сохраняем в массив
    Movie[] testData = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};

    //mng.fillRepo(testData) - заполняем массив (репозиторий) тестовыми данными

    Manager mng = new Manager();

    @Test
    void isAddCorrect() {
        Manager mng = new Manager();
        mng.add(film1);
        mng.exePosterResult();
        Movie[] expected = {film1};
        assertArrayEquals(expected, mng.posterResult);
    }

    @Test
    void isOneRequare() {
        Manager mng = new Manager(1);
        mng.fillRepo(testData);
        mng.exePosterResult();
        Movie[] expected = {film10};
        assertArrayEquals(expected, mng.posterResult);
    }

    @Test
    void isAvgRequare() {
        Manager mng = new Manager(5);
        mng.fillRepo(testData);
        mng.exePosterResult();
        Movie[] expected = {film10, film9, film8, film7, film6};
        assertArrayEquals(expected, mng.posterResult);

    }

    @Test
    void isMaxRequare() {
        Manager mng = new Manager(10);
        mng.fillRepo(testData);
        mng.exePosterResult();
        Movie[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        assertArrayEquals(expected, mng.posterResult);
    }

    @Test
    void isEmptyRequare() {
        Manager mng = new Manager(0);
        mng.exePosterResult();
        Movie[] expected = {};
        assertArrayEquals(expected, mng.posterResult);
    }

    @Test
    void isRequareOverLimit() {
        Manager mng = new Manager(11);
        mng.fillRepo(testData);
        mng.exePosterResult();
        Movie[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        assertArrayEquals(expected, mng.posterResult);
    }

    @Test
    void isUncorrectRequare() {
        Manager mng = new Manager(-1);
        mng.fillRepo(testData);
        mng.exePosterResult();
        Movie[] expected = {};
        assertArrayEquals(expected, mng.posterResult);
    }

}



