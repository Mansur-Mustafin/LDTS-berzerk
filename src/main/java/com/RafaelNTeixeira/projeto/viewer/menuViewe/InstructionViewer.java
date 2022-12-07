package com.RafaelNTeixeira.projeto.viewer.menuViewe;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class InstructionViewer extends Viewer<Instruction> {
    public InstructionViewer(Instruction instruction) {
        super(instruction);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0, 3), "[]=============================[]", "#E9FFDB");
        gui.drawText(new Position(0, 4), "||   I N S T R U C T I O N S   || ", "#E9FFDB");
        gui.drawText(new Position(0, 5), "||=============================||", "#E9FFDB");
        gui.drawText(new Position(0, 6), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 7), "||       gameplay CONTROLS:    ||", "#E9FFDB");
        gui.drawText(new Position(0, 8), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 9), "||      W --> mOVE UPWARDS     ||", "#E9FFDB");
        gui.drawText(new Position(0, 10), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 11), "||      S --> mOVE DOWNWARDS   ||", "#E9FFDB");
        gui.drawText(new Position(0, 12), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 13), "||      D --> mOVE RIGHT       ||", "#E9FFDB");
        gui.drawText(new Position(0, 14), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 15), "||      A --> mOVE LEFT        ||", "#E9FFDB");
        gui.drawText(new Position(0, 16), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 17), "[]=============================[]", "#E9FFDB");


        gui.drawText(new Position(2, 20), "Press Enter to go back to menu", "#FFFFFF");
    }
}