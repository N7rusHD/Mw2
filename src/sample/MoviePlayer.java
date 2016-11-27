package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MoviePlayer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.show();
        primaryStage.setScene(new Scene(root, 640, 480, Color.BLACK));

        Media media = new Media("file:///C:/Users/n7rus/IdeaProjects/MoviePlayer/trailers/trailer1.mp4");
        final MediaPlayer player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        //System.out.println("media.wigth: " +media.getWidh());
        root.getChildren().add(view);
        //Scene scene = new Scene(root, 400, 400, Color.BLACK);
        //stage.setScene(scene);
        //stage.show();
        player.play();
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                primaryStage.setMinWidth(w);
                primaryStage.setMinHeight(h);
            }

        });
    }
}

