package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }



    @Test
    public void shouildSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Игра1", "Аркады");
        Game game2 = store.publishGame("Игра2", "Стратегии");
        Game game3 = store.publishGame("Игра3", "Аркады");

        Player player = new Player("Вася");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 2);
        player.play(game3, 3);
        player.play(game1, 2);

        int expected = 8;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test
    public void shouildThrowRunTimeException() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Игра1", "Аркады");
        Game game2 = store.publishGame("Игра2", "Стратегии");
        Game game3 = store.publishGame("Игра3", "Аркады");

        Player player = new Player("Вася");
        Player player1 =new Player("Иван");
        player.installGame(game1);
        player.installGame(game3);
        player1.installGame(game1);
        player1.installGame(game3);
        player.play(game1, 3);
        player1.play(game3, 2);
        player.play(game3, 3);
        player1.play(game1, 2);


        assertThrows(NotInstalGameException.class, () -> {

            player.play(game2, 3);

        });
    }
    @Test
    public void mostPlayerByGenreGamePlayed() {
        GameStore store = new GameStore();
        Player player = new Player("Ura");
        Game game1 = store.publishGame("Игра1", "Аркады");
        Game game2 = store.publishGame("Игра2", "Стратегии");
        Game game3 = store.publishGame("Игра3", "Аркады");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 6);
        player.play( game2, 5);
        player.play(game3, 3);

        Game expected = game1;
        Game actual = player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }
    @Test
    public void shouldMostPlayerByGenreNoInstall() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Игра1", "Аркады");
        Game game2 = store.publishGame("Игра2", "Стратегии");
        Game game3 = store.publishGame("Игра3", "RPG");

        Player player = new Player("Вася");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 3);
        player.play(game2, 2);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("RPG");
        assertEquals(expected, actual);
    }

}
