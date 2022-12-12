package com.l12gr05.projeto.controller.game;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
