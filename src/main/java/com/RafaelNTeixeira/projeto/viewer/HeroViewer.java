package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero>{
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
