package com.RafaelNTeixeira.projeto.model.sounds;

public class SoundControl {

    private SoundTrack soundTrack;
    private SoundTrack shooting;
    private SoundTrack menuMusic;
    private SoundTrack heroDeath;
    private SoundTrack enemyDeath;
    private SoundTrack changeTab;
    private static SoundControl soundControl;

    private SoundControl() {
        soundTrack = new SoundTrack("/src/main/resources/Sounds/soundTrack.wav");
        shooting = new SoundTrack("/src/main/resources/Sounds/Shooting.wav");
        menuMusic = new SoundTrack("/src/main/resources/Sounds/MenuMusic.wav");
        heroDeath = new SoundTrack("/src/main/resources/Sounds/HeroDeath.wav");
        enemyDeath = new SoundTrack("/src/main/resources/Sounds/EnemyDeath.wav");
        changeTab = new SoundTrack("/src/main/resources/Sounds/ChangeTab.wav");
    }

    public void setSoundTrack(SoundTrack soundTrack) {this.soundTrack = soundTrack;}

    public void setShooting(SoundTrack shooting) {this.shooting = shooting;}

    public void setMenuMusic(SoundTrack menuMusic) {this.menuMusic = menuMusic;}

    public void setHeroDeath(SoundTrack heroDeath) {this.heroDeath = heroDeath;}

    public void setEnemyDeath(SoundTrack enemyDeath) {this.enemyDeath = enemyDeath;}

    public void setChangeTab(SoundTrack changeTab) {this.changeTab = changeTab;}

    public static SoundControl getInstance(){
        if (soundControl == null) {
            soundControl = new SoundControl();
        }
        return soundControl;
    }

    public void start(Sound sound) {
        switch (sound){
            case SOUNDTRACK: soundTrack.playLoop();
            case SHOOTING: shooting.play();
            case MENUMUSIC: menuMusic.playLoop();
            case HERODEATH: heroDeath.play();
            case ENEMYDEATH: enemyDeath.play();
            case CHANGETAB: changeTab.play();
        }
    }

    public void stop(Sound sound){
        switch (sound){
            case SOUNDTRACK: soundTrack.stop();
            case MENUMUSIC: menuMusic.stop();
        }
    }

    public void stopAll(){
        soundTrack.stop();
        shooting.stop();
        menuMusic.stop();
        heroDeath.stop();
        enemyDeath.stop();
        changeTab.stop();
    }
}
