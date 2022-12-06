package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet>{
    @Override
    public void draw(Bullet bullet, GUI gui) {
        boolean heroBullet = bullet.isHeroBullet();
        Position bulletPosition = bullet.getPosition();

        if(heroBullet){
            gui.drawHeroBullet(bulletPosition);
        }else{
            gui.drawEnemyBullet(bulletPosition);
        }
    }
}
