package com.koles.androidgames.mrgreen;

import com.koles.androidgame.framework.impl.AndroidGame;
import com.koles.androidgame.framework.interfaces.Screen;

public class MrGreenGame extends AndroidGame {

    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
