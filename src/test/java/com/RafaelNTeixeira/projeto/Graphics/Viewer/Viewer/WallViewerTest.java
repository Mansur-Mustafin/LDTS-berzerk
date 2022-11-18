package com.RafaelNTeixeira.projeto.Graphics.Viewer.Viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.RafaelNTeixeira.projeto.viewer.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WallViewerTest {
    private GUI gui;
    private GameViewer wall_viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        arena = new Arena(50, 50);
        wall_viewer = new GameViewer(arena);
    }

    @Test
    void CheckWalls() throws IOException {
        List<Wall> walls = arena.getWalls();

        for (Wall wall : walls) {
            Mockito.verify(gui, Mockito.times(0)).drawWall(wall.getPosition());
        }
    }
}
