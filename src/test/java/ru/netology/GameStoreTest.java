package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {


    @Test
    public void shouldContains() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        Game game5 = new Game("Gena", "AntiGena", store);
        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game4));
        assertFalse(store.containsGame(game5));
    }

    // Берем за истину, что метод containsGame работает верно
    @Test
    public void shouldAddGame1() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        assertTrue(store.containsGame(game3));
        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
        assertTrue(store.containsGame(game4));
    }

    @Test
    public void shouldAddGame2() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        Game game5 = new Game("Lena", "Vova", store);
        assertFalse(store.containsGame(game5));

    }


    @Test
    public void shouldAddPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Masha", 2);
        store.addPlayTime("Lena", 9);
        Assertions.assertEquals("Masha", store.getMostPlayer());


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
    public void shouldGetSumPlayedTime1() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 4);
        Assertions.assertEquals(18, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTime2() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 4);
        store.addPlayTime("Masha", 2);
        Assertions.assertEquals(20, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTime3() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 0);
        store.addPlayTime("Sveta", 0);
        store.addPlayTime("Anya", 0);
        store.addPlayTime("Nata", 0);
        store.addPlayTime("Petya", 0);
        store.addPlayTime("Masha", 0);
        Assertions.assertEquals(0, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTime4() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 7);
        Assertions.assertEquals(7, store.getSumPlayedTime());

    }

    @Test
    public void shouldGetSumPlayedTime5() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", -5);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 4);
        store.addPlayTime("Masha", 2);
        Assertions.assertEquals(7, store.getSumPlayedTime());

    }

    @Test
    public void shouldGetSumPlayedTime6() {
        GameStore store = new GameStore();
        Assertions.assertEquals(0, store.getSumPlayedTime());
    }
}
