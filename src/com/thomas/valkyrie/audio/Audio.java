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
    //For loading up .WAV file formats
    private static AudioPlayer MGP = AudioPlayer.player;
    private static ContinuousAudioDataStream loop = null;

    // For loading up .MP3 file formats
    private static Player player;

    public static void loadWAVFile(String path)
    {
        AudioStream BGM;
        AudioData MD;

        try
        {
            BGM = new AudioStream(new FileInputStream("res/" + path + ".wav" ));
            MD = BGM.getData();
            ContinuousAudioDataStream loop = new ContinuousAudioDataStream(MD);
        }
        catch (IOException ex)
        {

        }
    }

    public static void playWAVFile()
    {
        MGP.start(loop);
    }

    public static void loadMP3File(String path)
    {
        try
        {
            File file = new File("res/" + path + ".mp3");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            player = new Player(bufferedInputStream);

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (JavaLayerException ex)
        {
            ex.printStackTrace();
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
