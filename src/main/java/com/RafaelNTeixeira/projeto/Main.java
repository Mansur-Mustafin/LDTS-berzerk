package com.RafaelNTeixeira.projeto;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new Game(80, 30).run();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
    }
}
