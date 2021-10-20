package com.koles.androidgames.mrgreen;

import com.koles.androidgame.framework.interfaces.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Settings {

    public static boolean soundEnabled = false;
    public static int[] highscores = {100, 80, 60, 40, 20};

    public static void load(FileIO files){
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(
                    files.readFile(".mrgreen")));
            soundEnabled = Boolean.parseBoolean(in.readLine());
            for(int i = 0; i < 5; i++){
                highscores[i] = Integer.parseInt(in.readLine());
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(NumberFormatException e){
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void save(FileIO files){
        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile(".mrgreen")));
            out.write(Boolean.toString(soundEnabled));
            for(int i = 0; i < 5; i++){
                out.write(Integer.toString(highscores[i]));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(out != null){
                try{
                    out.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addScore(int score){
        for(int i = 0; i < 5; i++){
            if(highscores[i] < score){
                for(int j = 4; j > i; j--){
                    highscores[j] = highscores[j - 1];
                    highscores[i] = score;
                    break;
                }
            }
        }
    }
}
