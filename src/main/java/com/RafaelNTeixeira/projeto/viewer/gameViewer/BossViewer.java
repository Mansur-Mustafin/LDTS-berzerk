package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Boss;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;

public class BossViewer implements ElementViewer<Boss> {
    @Override
    public void draw(Boss boss, GUI gui) {
        Position bossPosition = boss.getPosition();
        gui.drawBoss(bossPosition);
    }
}