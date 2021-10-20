package com.koles.androidgames.mrgreen;

import com.koles.androidgame.framework.interfaces.Game;
import com.koles.androidgame.framework.interfaces.Graphics;
import com.koles.androidgame.framework.interfaces.Input;
import com.koles.androidgame.framework.interfaces.Input.TouchEvent;
import com.koles.androidgame.framework.interfaces.Screen;

import java.util.List;

public class HelpScreen2 extends Screen {
    public HelpScreen2(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();

        for(int i = 0; i < len; i++){
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 256 && event.y > 416) {
                    game.setScreen(new HelpScreen3(game));
                    if (Settings.soundEnabled) {
                        Assets.click.play(1);
                    }
                    return;
                }//close if(event.x > 256 && event.y > 416)
            }//close if(event.type == TouchEvent.TOUCH_UP)
        }//close for
    }//close update()

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.help2, 64, 100);
        g.drawPixmap(Assets.buttons, 256, 415, 64, 64, 64, 64);
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
