package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
    public void shouldAddPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 8);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Anya", 2);
        store.addPlayTime("Masha", 2);
        store.addPlayTime("Nata", 3);
        store.addPlayTime("Petya", 9);
        assertEquals("Masha", store.getMostPlayer());
    }

        // не хватает геттера для реализации теста


    // другие ваши тесты
}
