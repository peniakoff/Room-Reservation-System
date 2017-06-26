package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Paint;

/**
 * Created by Tomasz on 26.06.2017.
 */
public class Utils {

    public static void nameChecker(JFXTextField field) {
        if (field.getText().matches(".+\\s.+")) {
            field.setFocusColor(Paint.valueOf("#4caf50"));
        } else {
            field.setFocusColor(Paint.valueOf("#F44336"));
        }
    }

}
