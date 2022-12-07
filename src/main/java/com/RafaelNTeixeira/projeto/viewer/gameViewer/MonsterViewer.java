package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.viewer.gameViewer.ElementViewer;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        Position monsterPosition = monster.getPosition();
        gui.drawMonster(monsterPosition);
    }
}
