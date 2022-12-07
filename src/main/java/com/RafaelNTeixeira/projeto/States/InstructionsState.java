package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.InstructionController;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.InstructionViewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;


public class InstructionsState extends State<Instruction> {
    public InstructionsState(Instruction model) {
        super(model);
    }

    @Override
    protected Viewer<Instruction> getViewer() {
        return new InstructionViewer(getModel());
    }

    @Override
    protected Controller<Instruction> getController() {
        return new InstructionController(getModel());
    }
}