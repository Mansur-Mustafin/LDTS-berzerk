package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Health;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;

public class HeartViewer implements ElementViewer<Health> {
    @Override
    public void draw(Health health, GUI gui) {
        Position heroPosition = health.getPosition();
        gui.drawHeart(heroPosition);
    }
}
