package ru.netology.manager;

import ru.netology.domain.Movie;

public class PosterManager {
    private int moviesCount = 10;
    private Movie[] movies = new Movie[0];

    PosterManager() {
    }

    PosterManager(int moviesCount) {
        this.moviesCount = moviesCount;
    }

    public void add(Movie movie) {
        // создаём новый массив размером на единицу больше
//        int length = movies.length + 1;
        Movie[] tmp = new Movie[movies.length + 1];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
//        int lastIndex = tmp.length - 1;
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        int newLength;
        if (movies.length < moviesCount) {
            newLength = movies.length;
        } else {
            newLength = moviesCount;
        }
        Movie[] result = new Movie[newLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < newLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

}