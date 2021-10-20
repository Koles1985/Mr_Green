package com.koles.androidgames.mrgreen;

import com.koles.androidgame.framework.interfaces.Game;
import com.koles.androidgame.framework.interfaces.Graphics;
import com.koles.androidgame.framework.interfaces.Graphics.PixmapFormat;
import com.koles.androidgame.framework.interfaces.Screen;

public class LoadingScreen extends Screen {

    public LoadingScreen(Game game){
        super(game);
    }

    public void update(float deltaTime){
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background_game.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("button_map.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("paus.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("game_over.png", PixmapFormat.ARGB4444);
        Assets.headUp = g.newPixmap("head_up.png", PixmapFormat.ARGB4444);
        Assets.headRight = g.newPixmap("head_right.png", PixmapFormat.ARGB4444);
        Assets.headDown = g.newPixmap("head_down.png", PixmapFormat.ARGB4444);
        Assets.headLeft = g.newPixmap("head_left", PixmapFormat.ARGB4444);
        Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB4444);


        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.eat = game.getAudio().newSound("eat.ogg");
        Assets.canibal = game.getAudio().newSound("canibal.ogg");

        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
