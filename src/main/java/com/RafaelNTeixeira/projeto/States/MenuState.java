package com.RafaelNTeixeira.projeto.States;


import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.MenuController;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.MenuViewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
