package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.WinController;
import com.RafaelNTeixeira.projeto.model.menu.Win;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.Viewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.WinViewer;

public class WinState extends State<Win>{
    public WinState(Win model) {
        super(model);
    }

    @Override
    protected Viewer<Win> getViewer() {return new WinViewer(getModel());}

    @Override
    protected Controller<Win> getController() {return new WinController(getModel());}
}
