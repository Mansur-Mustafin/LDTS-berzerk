package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;
import com.RafaelNTeixeira.projeto.model.game.elements.Element;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        List<Wall> walls = getModel().getWalls();
        List<Monster> monsters = getModel().getMonsters();
        List<King> kings = getModel().getKings();
        List<Bullet> bullets = getModel().getBullets();
        Hero hero = getModel().getHero();
        
        drawElements(gui, walls, new WallViewer());
        drawElements(gui, monsters, new MonsterViewer());
        drawElements(gui, kings, new KingViewer());
        drawElements(gui, bullets, new BulletViewer());
        drawElement(gui, hero, new HeroViewer());


        int score = getModel().getScore();
        gui.drawText(new Position(0, 0), Integer.toString(score) , "#FFD700");
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
