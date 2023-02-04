package Animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {

    TranslateTransition shaker;

    public Shake (Node node) {
        shaker = new TranslateTransition(Duration.millis(70),node);
        shaker.setFromX(0f);
        shaker.setByX(12f);
        shaker.setCycleCount(3);
        shaker.setAutoReverse(true);
    }

    public void playAnimation () {
        shaker.playFromStart();
    }
}
