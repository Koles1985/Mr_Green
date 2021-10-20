package com.koles.androidgames.model;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    public List<SnakePart> parts = new ArrayList<SnakePart>();
    public int direction;

    public Snake(){
        direction = UP;
        parts.add(new SnakePart(5,6));
        parts.add(new SnakePart(5,7));
        parts.add(new SnakePart(5,8));
    }

    public void turnRight(){
        direction += 1;
        if(direction > LEFT){
            direction = UP;
        }
    }

    public void turnLeft(){
        direction -= 1;
        if(direction < UP){
            direction = LEFT;
        }
    }

    public void eat(){
        SnakePart end = parts.get(parts.size() - 1);
        parts.add(new SnakePart(end.x, end.y));
    }

    public void advance(){
        SnakePart head = parts.get(0);
        int len = parts.size() - 1;
        for(int i = len; i > 0; i--){
            SnakePart before = parts.get(i - 1);
            SnakePart part = parts.get(i);
            part.x = before.x;
            part.y = before.y;
        }

        switch (direction){
            case UP:
                head.y--;
                break;
            case LEFT:
                head.x--;
                break;
            case DOWN:
                head.y++;
                break;
            case RIGHT:
                head.x++;
        }

        if(head.x < 0){
            head.x = 9;
        }
        if(head.x > 9){
            head.x = 0;
        }
        if(head.y < 0){
            head.y = 12;
        }
        if(head.y > 12){
            head.y = 0;
        }
    }

    public boolean checkBitten(){
        int len = parts.size();
        SnakePart head = parts.get(0);
        for(int i = 1; i < len; i++){
            if(head.x == parts.get(i).x && head.y == parts.get(i).y){
                return true;
            }//close if
        }//close for
        return false;
    }
}
