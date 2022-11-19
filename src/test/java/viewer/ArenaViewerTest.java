package viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.RafaelNTeixeira.projeto.viewer.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class ArenaViewerTest {
    private Arena arena;
    private GameViewer arena_viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        arena = new Arena(50,50);
        arena_viewer = new GameViewer(arena);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void CheckWalls() throws IOException {
        List<Wall> walls = arena.getWalls();

        for (Wall wall : walls) {
            Mockito.verify(gui, Mockito.times(0)).drawWall(wall.getPosition());
        }
    }
}
