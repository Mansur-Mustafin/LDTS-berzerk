package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;

public class InstructionViewer extends Viewer<Instruction> {
    public InstructionViewer(Instruction instruction) {
        super(instruction);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0, 0), "[]=============================[]", "#E9FFDB");
        gui.drawText(new Position(0, 1), "||   I N S T R U C T I O N S   || ", "#E9FFDB");
        gui.drawText(new Position(0, 2), "||=============================||", "#E9FFDB");
        gui.drawText(new Position(0, 3), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 4), "||       gameplay CONTROLS:    ||", "#E9FFDB");
        gui.drawText(new Position(0, 5), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 6), "||  UP ARROW --> mOVE UPWARDS  ||", "#E9FFDB");
        gui.drawText(new Position(0, 7), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 8), "||DOWN ARROW --> mOVE DOWNWARDS||", "#E9FFDB");
        gui.drawText(new Position(0, 9), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 10), "|| RIGHT ARROW --> mOVE RIGHT  ||", "#E9FFDB");
        gui.drawText(new Position(0, 11), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 12), "||  LEFT ARROW --> mOVE LEFT   ||", "#E9FFDB");
        gui.drawText(new Position(0, 13), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 14), "||=============================||", "#E9FFDB");


        gui.drawText(new Position(2, 20), "Press Enter to go back to menu", "#FFFFFF");
    }
}
