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
        gui.drawText(new Position(30, 6), "  []=================================[]", "#E9FFDB");
        gui.drawText(new Position(30, 7), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 8), "  ||     I N S T R U C T I O N S     || ", "#E9FFDB");
        gui.drawText(new Position(30, 9), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 10), "  ||=================================||", "#E9FFDB");
        gui.drawText(new Position(30, 11), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 12), "  ||         GAMEPLAY CONTROLS:      ||", "#E9FFDB");
        gui.drawText(new Position(30, 13), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 14), "  ||    UP ARROW --> MOVE UPWARDS    ||", "#E9FFDB");
        gui.drawText(new Position(30, 15), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 16), "  ||  DOWN ARROW --> MOVE DOWNWARDS  ||", "#E9FFDB");
        gui.drawText(new Position(30, 17), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 18), "  ||   RIGHT ARROW --> MOVE RIGHT    ||", "#E9FFDB");
        gui.drawText(new Position(30, 19), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 20), "  ||    LEFT ARROW --> MOVE LEFT     ||", "#E9FFDB");
        gui.drawText(new Position(30, 21), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 22), "  ||=================================||", "#E9FFDB");
        gui.drawText(new Position(30, 23), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 24), "  ||        O B J E C T I V E        ||", "#E9FFDB");
        gui.drawText(new Position(30, 25), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 26), "  ||=================================||", "#E9FFDB");
        gui.drawText(new Position(30, 27), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 28), "  ||    You were brought into this   ||", "#E9FFDB");
        gui.drawText(new Position(30, 29), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 30), "  ||   world with one purpose only,  ||", "#E9FFDB");
        gui.drawText(new Position(30, 31), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 32), "  ||         eliminate robots.       ||", "#E9FFDB");
        gui.drawText(new Position(30, 33), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 34), "  ||---------------------------------||", "#E9FFDB");
        gui.drawText(new Position(30, 35), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 36), "  ||        Your objective is        ||", "#E9FFDB");
        gui.drawText(new Position(30, 37), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 38), "  ||     to kill as many enemies     ||", "#E9FFDB");
        gui.drawText(new Position(30, 39), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 40), "  ||          as possible, but       ||", "#E9FFDB");
        gui.drawText(new Position(30, 41), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 42), "  ||        it might cost your       ||", "#E9FFDB");
        gui.drawText(new Position(30, 43), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 44), "  ||               life.             ||", "#E9FFDB");
        gui.drawText(new Position(30, 45), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 46), "  ||=================================||", "#E9FFDB");
        gui.drawText(new Position(30, 47), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 48), "  ||   DO YOU ACCEPT THE CHALLENGE?  ||", "#E9FFDB");
        gui.drawText(new Position(30, 49), "  ||                                 ||", "#E9FFDB");
        gui.drawText(new Position(30, 50), "  []=================================[]", "#E9FFDB");
        gui.drawText(new Position(35, 55), "Press Enter to go back to Menu", "#FFFFFF");
    }
}
