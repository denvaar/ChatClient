package ChatClient;

import java.io.*;
import javax.sound.sampled.*;
import java.util.HashMap;
import java.net.URL;
import java.net.URISyntaxException;

/*
    SoundListener

    This class has one method - play(String str). It takes a string and 
    tries to find the sound file resource in the "resources" folder. If
    it's found, then the sound is played, if not, an error is thrown.

    TODO: Add dialog boxes instead of console output for stack trace.

*/
public class SoundListener {

    private AudioInputStream audioStream;
    private Clip audioClip;

    public SoundListener() {
        this.audioStream = null;
        this.audioClip = null;
    }

    public void play(String str) {
        new Thread() {
            public void run() {
                URL url = SoundListener.class.getResource("resources/" + str + ".wav");
                try {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
                    Clip audioClip = AudioSystem.getClip();
                    audioClip.open(audioStream);
                    audioClip.start();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
                } catch (SecurityException e) {
                    e.printStackTrace();
                    return;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }.start();
    }
}
