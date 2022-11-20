package viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.RafaelNTeixeira.projeto.viewer.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class ArenaViewerTest {
    private Arena arena;
    private Hero hero;
    private GameViewer arena_viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        arena = new Arena(50,50);
        arena_viewer = new GameViewer(arena);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void CheckDrawAllEntities() {
        List<Wall> walls = arena.getWalls();
        List<Monster> monsters = arena.getMonsters();
        hero = arena.getHero();
        List<King> kings = arena.getKings();

        for (Wall wall : walls) {
            Mockito.verify(gui, Mockito.times(0)).drawWall(wall.getPosition());
        }

        for (Monster monster : monsters) {
            Mockito.verify(gui, Mockito.times(0)).drawMonster(monster.getPosition());
        }

        for (King king : kings) {
            Mockito.verify(gui, Mockito.times(0)).drawKing(king.getPosition());
        }

        Mockito.verify(gui, Mockito.times(0)).drawHero(hero.getPosition());
    }
}
