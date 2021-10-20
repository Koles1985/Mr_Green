package com.koles.androidgames.mrgreen;

import com.koles.androidgame.framework.interfaces.Game;
import com.koles.androidgame.framework.interfaces.Graphics;
import com.koles.androidgame.framework.interfaces.Input;
import com.koles.androidgame.framework.interfaces.Input.TouchEvent;
import com.koles.androidgame.framework.interfaces.Screen;

import java.util.List;

public class HighscoreScreen extends Screen {
    private String[] lines = new String[5];

    public HighscoreScreen(Game game){
        super(game);
        for(int i = 0; i < 5; i++){
            //нужно использовать StringBuilder
            lines[i] = "" + (i + 1) + ". " + Settings.highscores[i];
        }
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();

        for(int i = 0; i < len; i++){
           TouchEvent event = touchEvents.get(i);
           if(event.type == TouchEvent.TOUCH_UP){
               if(event.x < 64 && event.y > 416){
                   game.setScreen(new MainMenuScreen(game));
                   if(Settings.soundEnabled){
                       Assets.click.play(1);
                   }
                   return;
               }//close if(event.x < 64 && event.y > 416)
           }//close if(event.type == TouchEvent.TOUCH_UP)
        }//close for
    }//close update()

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background, 0 , 0);
        g.drawPixmap(Assets.mainMenu, 64, 20, 0, 42, 196, 42);

        int y = 100;
        for (int i = 0; i < 5; i++){
            drawText(g, lines[i], 20, y);
            y += 50;
        }

        g.drawPixmap(Assets.buttons, 0, 416, 0, 64, 64,64 );
    }

    public void drawText(Graphics g, String line, int x, int y){
        int len = line.length();
        for(int i = 0; i < len; i++){
            char character = line.charAt(i);
            if(character == ' '){
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;

            if(character == '.'){
                srcX = 200;
                srcWidth = 10;
            }else{
                srcX = (character - '0') * 20;
                srcWidth += 20;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }//close for
    }//close drawText()

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
