package viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.viewer.HeroViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HeroViewerTest {
    private GUI gui;
    private HeroViewer viewer;
    private Hero hero;

    @Test
    void drawHero() {
        hero = new Hero(10, 10);
        viewer = new HeroViewer();
        gui = Mockito.mock(GUI.class);
        viewer.draw(hero, gui);

        Mockito.verify(gui, Mockito.times(1)).drawHero(hero.getPosition());
    }
}
