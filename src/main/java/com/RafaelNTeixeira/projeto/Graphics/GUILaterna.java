package com.RafaelNTeixeira.projeto.Graphics;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.MouseAction;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.MouseCaptureMode;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.googlecode.lanterna.input.MouseActionType.CLICK_RELEASE;

public class GUILaterna implements GUI {
    private final Screen screen;
    Set<Integer> pressedKeys = new HashSet<>();
    public GUILaterna(Screen screen) {
        this.screen = screen;
    }

    public GUILaterna(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();

        ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getButton());
                pressedKeys.add(e.getButton());
            }
        });
        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public void drawHero(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        //graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        //graphics.enableModifiers(SGR.BOLD);
        //graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        TextImage image = new BasicTextImage(40, 16);

        InputStream istream = ClassLoader.getSystemResourceAsStream("Elements/Hero.txt");
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);

        try {
            int i = 0;
            for (String line; (line = reader.readLine()) != null; i++) {
                System.out.println(line);
                int j = 0;
                for (char c: line.toCharArray()) {
                    image.setCharacterAt(j,i, new TextCharacter(c));
                    j++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        graphics.drawImage(new TerminalPosition(position.getX(), position.getY()), image);
    }

    @Override
    public void drawHeart(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()),"J");
    }
    @Override
    public void drawWall(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5C627F"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#5C627F"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "w");
    }

    @Override
    public void drawMonster(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()),"M");
    }

    @Override
    public void drawKing(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#A52D93"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()),"K");
    }

    @Override
    public void drawHeroBullet(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#A52D93"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()),"B");
    }

    @Override
    public void drawEnemyBullet(Position position){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()),"O");
    }


    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void clear(){
        screen.clear();
    }
    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }
    @Override
    public void close() throws IOException{
        screen.close();
    }

    public TextGraphics newTextGraphics(){
        return screen.newTextGraphics();
    }


    public KeyStroke getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null && !pressedKeys.isEmpty()){
            if(pressedKeys.contains(1)){
                pressedKeys.remove(1);
                return new KeyStroke(KeyType.ArrowLeft);
            }
            if(pressedKeys.contains(3)){
                pressedKeys.remove(3);
                return new KeyStroke(KeyType.ArrowRight);
            }
            if(pressedKeys.contains(5)){
                pressedKeys.remove(5);
                return new KeyStroke(KeyType.ArrowUp);
            }
            if(pressedKeys.contains(4)){
                pressedKeys.remove(4);
                return new KeyStroke(KeyType.ArrowDown);
            }
        }
        return keyStroke;
    }
}
