package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet>{
    @Override
    public void draw(Bullet bullet, GUI gui) {
        if(bullet.isHeroBullet()){
            gui.drawHeroBullet(bullet.getPosition());
        }else{
            gui.drawEnemyBullet(bullet.getPosition());
        }
    }
}
