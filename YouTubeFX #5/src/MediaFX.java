import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.awt.event.ActionListener;

import javax.media.ControllerListener;

import javax.swing.*;


public class MediaFX extends Application {

	MediaPlayer mediaplayer;


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}   //</editor-fold>
         /* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Menu().setVisible(true);
			}
		});
		Button btn_play, btn_pause, btn_stop;

		btn_play = new Button("Start");
		btn_pause = new Button("Pause");
		btn_stop = new Button("Stop");

		btn_play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mediaplayer.play();

			}
		});
		btn_pause.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mediaplayer.pause();
			}
		});
		btn_stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				mediaplayer.stop();
			}
		});

		Media musicFile = new Media(
				"file:///C:/Users/Wovch/Desktop/Player/lumen_-_dukh_vremeni_(zaycev.net).mp3");

		Media videoFile = new Media(
				"file:///C:/Users/Wovch/Desktop/Player/1.mp4");

		mediaplayer = new MediaPlayer(musicFile);
		// mediaplayer.setAutoPlay(true);
		mediaplayer.setVolume(0.5);

		MediaView mediaView = new MediaView(mediaplayer);
		VBox root = new VBox();
		root.getChildren().addAll(btn_play,btn_pause,btn_stop,mediaView);

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);

		stage.show();
	}

}
