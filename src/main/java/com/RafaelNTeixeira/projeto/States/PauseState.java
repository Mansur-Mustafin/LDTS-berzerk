package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.PauseController;
import com.RafaelNTeixeira.projeto.model.menu.Pause;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.PauseViewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.Viewer;

public class PauseState extends State<Pause>{
    public PauseState(Pause model) {
        super(model);
    }

    @Override
    protected Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    protected Controller<Pause> getController() {
        return new PauseController(getModel());
    }
}
