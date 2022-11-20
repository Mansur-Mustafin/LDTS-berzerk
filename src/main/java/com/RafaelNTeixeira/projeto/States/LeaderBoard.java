package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController;
import com.RafaelNTeixeira.projeto.controller.menu.LoseController;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.viewer.LeaderViewer;
import com.RafaelNTeixeira.projeto.viewer.LoseViewer;
import com.RafaelNTeixeira.projeto.viewer.Viewer;


public class LeaderBoard extends State<Leader>{
    public LeaderBoard(Leader model) {
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
