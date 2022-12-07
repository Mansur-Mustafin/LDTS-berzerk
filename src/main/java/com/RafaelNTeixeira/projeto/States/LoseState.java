package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.LoseController;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.LoseViewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class LoseState extends State<Lose>{
    public LoseState(Lose model) {
        super(model);
    }

    @Override
    protected Viewer<Lose> getViewer() {
        return new LoseViewer(getModel());
    }

    @Override
    protected Controller<Lose> getController() {
        return new LoseController(getModel());
    }
}
