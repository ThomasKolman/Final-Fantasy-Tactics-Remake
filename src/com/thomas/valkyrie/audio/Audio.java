package com.thomas.valkyrie.audio;

import java.io.*;


import sun.audio.*;

import javafx.scene.media.MediaPlayer;
import javazoom.jl.player.*;
import javazoom.jl.decoder.JavaLayerException;


/**
 * Created by Thomas on 2016-01-14.
 */
public class Audio
{

    private static AudioPlayer MGP = AudioPlayer.player;
    private static ContinuousAudioDataStream loop = null;
    private static String path = "Yamaha-TG100-SquareLd-C5";

    private static MediaPlayer mediaPlayer;
    private static Player player;

    public static void loadWAVFile()
    {
        AudioStream BGM;
        AudioData MD;

        try
        {
            BGM = new AudioStream(new FileInputStream("res/" + path + ".wav" ));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }
        catch (IOException ex)
        {

        }
    }

    public static void playWAVFile()
    {
        MGP.start(loop);
    }

    public static void loadMP3File()
    {
        String bip = "ZHU - FADED";

        try
        {
            File file = new File("res/" + bip + ".mp3");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            player = new Player(bufferedInputStream);

        }
        catch (IOException ex)
        {

        }
        catch (JavaLayerException ex)
        {

        }
    }


    public static void playMP3File()
    {
        try
        {
            player.play();
        }
        catch (JavaLayerException ex)
        {

        }
    }
}
