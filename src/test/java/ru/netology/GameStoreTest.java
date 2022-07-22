package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGame2() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldAddGame3() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldAddGame4() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        // для теста метода publishGame не хватает геттера
    }

    @Test
    public void shouldContains1() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContains2() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldContains3() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        Game game5 = new Game("Gena", "AntiGena", store);
        assertFalse(store.containsGame(game5));
    }

    @Test
    public void shouldContains4() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldAddPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Masha", 2);


        // не хватает геттера для реализации теста


    }

    @Test
    public void shouldGetMostPlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 4);
        Assertions.assertEquals("Masha", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer2() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 0);
        store.addPlayTime("Sveta", 0);
        store.addPlayTime("Anya", 0);
        store.addPlayTime("Nata", 0);
        store.addPlayTime("Petya", 0);
        Assertions.assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer3() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 7);
        store.addPlayTime("Sveta", 7);
        store.addPlayTime("Anya", 7);
        store.addPlayTime("Nata", 7);
        store.addPlayTime("Petya", 7);
        Assertions.assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer4() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 0);
        store.addPlayTime("Sveta", 1);

        Assertions.assertEquals("Sveta", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer5() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 0);
        store.addPlayTime("Sveta", 0);
        store.addPlayTime("Anya", 1);
        store.addPlayTime("Nata", 0);
        store.addPlayTime("Petya", 0);

        Assertions.assertEquals("Anya", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer6() {
        GameStore store = new GameStore();
        store.addPlayTime("Sveta", 1);

        Assertions.assertEquals("Sveta", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayer7() {
        GameStore store = new GameStore();
        Assertions.assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetSumPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 5);
        store.addPlayTime("Sveta", 7);
        store.addPlayTime("Anya", 1);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 4);

        Assertions.assertEquals(20, store.getSumPlayedTime());
    }
}
