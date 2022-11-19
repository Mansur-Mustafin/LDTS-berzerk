package viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.viewer.MonsterViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MonsterViewerTest {
    private GUI gui;
    private MonsterViewer monster_viewer;
    private Arena arena;

    @Test
    void drawMonsters() {
        gui = Mockito.mock(GUI.class);
        monster_viewer = new MonsterViewer();
        arena = new Arena(50,50);

        List<Monster> monsters = arena.getMonsters();
        for (Monster monster : monsters) {
            monster_viewer.draw(monster, gui);
        }

        for (Monster monster : monsters) {
            Mockito.verify(gui, Mockito.times(1)).drawMonster(monster.getPosition());
        }
    }
}
