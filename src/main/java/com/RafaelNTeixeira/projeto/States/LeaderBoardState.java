package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.LeaderViewer;
import com.RafaelNTeixeira.projeto.viewer.menuViewer.Viewer;


public class LeaderBoardState extends State<Leader>{
    public LeaderBoardState(Leader model) {
        super(model);
    }

    @Override
    protected Viewer<Leader> getViewer() {
        return new LeaderViewer(getModel());
    }

    @Override
    protected Controller<Leader> getController() {
        return new LeaderController(getModel());
    }
}
