package ru.netology.manager;

public class Manager {

    private int resultLimit;

    //argsConstructor
    public Manager(int resultLimit) {
        this.resultLimit = resultLimit;
    }

    // noArgsAonstructor
    public Manager() {
        this.resultLimit = 10;
    }

    public Movie[] posterLot = new Movie[0]; // лента(репозиторий)

    // метод добавить фильм в ленту
    public void add(Movie item) {
        int length = posterLot.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(posterLot, 0, tmp, 0, posterLot.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        posterLot = tmp;
    }


    Movie[] posterResult = new Movie[0];
    int tmpArrLength;

    /* этот метод выводит содержимое массива posterLot в обратном порядке.
       Кол-во выводимых объектов указано в поле resultLimit */
    public void exePosterResult() {
        if (resultLimit <= 0) {
            tmpArrLength = 0;
        } else if (resultLimit > posterLot.length) {
            tmpArrLength = posterLot.length;
        } else {
            tmpArrLength = resultLimit;
        }
        Movie[] result = new Movie[tmpArrLength];
        for (int i = 0; i < result.length; i++) {
            int index = posterLot.length - i - 1;
            result[i] = posterLot[index];
        }
        posterResult = result;
    }

    public void fillRepo(Movie[] data) {
        posterLot = data;
    }

}





