package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.AddLeaderController;
import com.RafaelNTeixeira.projeto.model.menu.AddLeader;
import com.RafaelNTeixeira.projeto.viewer.AddLeaderViewer;
import com.RafaelNTeixeira.projeto.viewer.Viewer;

public class AddLeaderState extends State<AddLeader>{
    public AddLeaderState(AddLeader model) {
        super(model);
    }

    @Override
    protected Viewer<AddLeader> getViewer() {
        return new AddLeaderViewer(getModel());
    }

    @Override
    protected Controller<AddLeader> getController() {
        return new AddLeaderController(getModel());
    }
}

