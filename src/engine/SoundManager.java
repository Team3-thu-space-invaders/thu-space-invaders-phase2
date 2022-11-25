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
        getItem
    }

    String ingame = "Bgm/background.wav";
    Clip ingameClip = null;

    String main = "Bgm/main.wav";

    Clip mainClip = null;
    String bullet = "Bgm/ball.wav";
    String attack = "Bgm/attack.wav";
    String gameOver = "Bgm/gameOver.wav";
    String hit = "Bgm/hit.wav";
    String click = "Bgm/click.wav";
    String getItem = "Bgm/getItem.wav";

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
            case getItem:
                bgm = getItem;
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
