package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertTrue(store.getGames().contains(game));
    }

    @Test
    public void shouldAddGame2() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Маша", "Ваня");
        Game game3 = store.publishGame("Света", "Таня");
        Game game4 = store.publishGame("Оля", "Дима");
        assertTrue(store.getGames().contains(game1));
        assertTrue(store.getGames().contains(game2));
        assertTrue(store.getGames().contains(game3));
        assertTrue(store.getGames().contains(game4));
    }

    @Test
    public void shouldAddGame3() {

        GameStore store = new GameStore();
        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);
        assertFalse(store.getGames().contains(game));
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
    public void shouldAddPlayedTime1() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Masha", 2);
        Assertions.assertEquals(10, store.getPlayedTime().get("Masha"));
    }

    @Test
    public void shouldAddPlayedTime2() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Masha", -2);
        Assertions.assertEquals(6, store.getPlayedTime().get("Masha"));
    }

    @Test
    public void shouldAddPlayedTime3() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Masha", 2);
        Assertions.assertEquals(1, store.getPlayedTime().get("Sveta"));
    }

    @Test
    public void shouldGetMostPlayer1() {
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
        store.addPlayTime("Sveta", 5);
        store.addPlayTime("Anya", 7);
        store.addPlayTime("Nata", 7);
        store.addPlayTime("Petya", 3);
        ArrayList<String> tmp = new ArrayList<>();
        int count = 0;
        for (String key : store.getPlayedTime().keySet()) {
            if (store.getPlayedTime().get(key) > 6) {
                tmp.add(count, key);
                count++;
            }
        }
        assertTrue(tmp.contains(store.getMostPlayer()));
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

    @Test
    public void shouldGetSumPlayedTime2() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 5);
        store.addPlayTime("Sveta", -7);
        store.addPlayTime("Anya", 1);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 4);

        Assertions.assertEquals(6, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTime3() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 0);
        store.addPlayTime("Sveta", 0);
        store.addPlayTime("Anya", 0);
        store.addPlayTime("Nata", 0);
        store.addPlayTime("Petya", 0);

        Assertions.assertEquals(0, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTime4() {
        GameStore store = new GameStore();
        Assertions.assertEquals(0, store.getSumPlayedTime());
    }
}
