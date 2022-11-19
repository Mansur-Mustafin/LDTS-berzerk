package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.MenuController;
import com.RafaelNTeixeira.projeto.controller.pause.PauseController;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.pause.Pause;
import com.RafaelNTeixeira.projeto.viewer.MenuViewer;
import com.RafaelNTeixeira.projeto.viewer.PauseViewer;
import com.RafaelNTeixeira.projeto.viewer.Viewer;

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
