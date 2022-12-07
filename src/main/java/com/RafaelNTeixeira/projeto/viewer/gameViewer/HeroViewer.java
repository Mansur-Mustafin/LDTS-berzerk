package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.viewer.gameViewer.ElementViewer;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        Position heroPosition = hero.getPosition();
        gui.drawHero(heroPosition);
    }
}
