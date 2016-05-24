/**
 * Created by Alexander on 14.05.2016.
 */
import java.awt.Dimension;
import javax.swing.*;
import javax.media.bean.playerbean.MediaPlayer;

class VideoExample extends JFrame{
    MediaPlayer player;//наш плеер

    public VideoExample(String path){
        super("Простой видео плеер");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(640,480));//устанавливаем размер окна

        player = new MediaPlayer();
//path - путь к файлу
        player.setMediaLocation("file:///" + path);
        player.setPlaybackLoop(false);//Повтор видео
        player.prefetch ();//предварительная обработка плеера (без неё плеер не появится)
//добавляем на фрейм
        add(player);
//player.start (); - сразу запустить плеер

        setVisible(true);
    }

    public static void main(String []args){
        VideoExample ve = new VideoExample("C:\\lumen_-_dukh_vremeni_(zaycev.net).mp3");
    }
}
