package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Element;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        List<Wall> walls = getModel().getWalls();
        drawElements(gui, walls, new WallViewer());
        List<Monster> monsters = getModel().getMonsters();
        drawElements(gui, monsters, new MonsterViewer());
        List<King> kings = getModel().getKings();
        drawElements(gui, kings, new KingViewer());
        Hero hero = getModel().getHero();
        drawElement(gui, hero, new HeroViewer());

        gui.drawText(new Position(0, 0), Integer.toString(getModel().getScore()) , "#FFD700");
        for(int i = 0; i < getModel().getHero().getEnergy() ; i++ ){
            gui.drawHeart(new Position(8 + i, 0));
        }
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
