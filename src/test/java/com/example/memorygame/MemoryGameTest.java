package com.example.memorygame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemoryGameTest extends ApplicationTest {

    ModuleLayer.Controller myController;
    Pane mainroot;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MemoryGame.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.myController = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }

    @Before
    public void setUp () throws Exception {

    }

    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    @Test
    void testScore ()
    {
        var scoreLabel = lookup("scoreLabel");
        org.testfx.assertions.api.Assertions.assertThat(scoreLabel).isNotNull();
    }
}