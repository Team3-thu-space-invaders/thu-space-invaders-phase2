package engine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;


public class SoundManager {

    public enum Sound {
        bullet,
        ingame,
        attack,
        gameOver,
        hit,
        main,
        click,
        item1,
        item2,
        item3,
    }

    String ingame = "src/bgm/background.wav";
    Clip ingameClip = null;
    String main = "src/bgm/main.wav";
    Clip mainClip = null;
    String bullet = "src/bgm/ball.wav";
    String attack = "src/bgm/attack.wav";
    String gameOver = "src/bgm/gameOver.wav";
    String hit = "src/bgm/hit.wav";
    String click = "src/bgm/click.wav";
    String item1 = "src/bgm/item1.wav";

    String item2 = "src/bgm/item2.wav";

    String item3 = "src/bgm/item3.wav";

    public void startMusic(Sound what) {
        String bgm = null;
        switch (what) {
            case ingame:
                bgm = ingame;
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                    ingameClip = AudioSystem.getClip();
                    ingameClip.open(audioInputStream);
                    ingameClip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bgm = null;
                break;
            case main:
                bgm = main;
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                    mainClip = AudioSystem.getClip();
                    mainClip.open(audioInputStream);
                    mainClip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bgm = null;
                break;
            case bullet:
                bgm = bullet;
                break;
            case attack:
                bgm = attack;
                break;
            case gameOver:
                bgm = gameOver;
                break;
            case hit:
                bgm = hit;
                break;
            case click:
                bgm = click;
                break;
            case item1:
                bgm = item1;
                break;
            case item2:
                bgm = item2;
                break;
            case item3:
                bgm = item3;
                break;
            default:
                break;
        }
        if (bgm != null) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgm).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void stopMusic(Sound what) {
        switch (what) {
            case ingame:
                if (ingameClip != null) {
                    ingameClip.stop();
                    ingameClip = null;
                }
                break;
            case main:
                if (mainClip != null) {
                    mainClip.stop();
                    mainClip = null;
                }
                break;

            default:
                break;
        }
    }

    public boolean checkMusic(Sound what) {
        switch (what) {
            case ingame:
                if (ingameClip != null) {
                    return true;
                }
                break;
            case main:
                if (mainClip != null) {
                    return true;
                }
                break;

            default:
                return false;
        }
        return false;
    }
}
