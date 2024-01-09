package com.example.memorygame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {

    @FXML
    private Label levelLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private FlowPane myFlowPane;

    @FXML
    private Label scoreLabel;
    private MemCard card1 = null, card2 = null;
    private int currLevel = 1;
    private int score = 0;
    private int nr_matched = 0;
    private ArrayList<MemCard> myCards;
    private int number_of_pairs = 2;
    private String mesaj = "Game in Progress";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playAgain();
    }
    public void initView()
    {
        for (int i = 0; i < myFlowPane.getChildren().size() && i < number_of_pairs * 2; i++) {
            ImageView imageView1 = (ImageView) myFlowPane.getChildren().get(i);
            imageView1.setImage(new Image(Cards.class.getResourceAsStream("images/Back.png")));
            imageView1.setUserData(i);
            imageView1.setOnMouseClicked(event -> {
                flipCard((int) imageView1.getUserData());
            });
        }
    }

    public void playAgain()
    {
        initView();
        play();
    }
   public void play() {
        card1 = null;
        card2 = null;

        myCards = new ArrayList<>();

        List<String> colors = Cards.getValidColor();
        List<String> values = Cards.getValidValue();
        Collections.shuffle(colors);
        Collections.shuffle(values);
        for (int i = 0; i < number_of_pairs && i < myFlowPane.getChildren().size() / 2; i++) {
            if(i<4){
                Cards cardDealt = new Cards(colors.get(i), values.get(i));
                myCards.add(new MemCard(cardDealt.color, cardDealt.value));
                myCards.add(new MemCard(cardDealt.color, cardDealt.value));
            }
            else
            {
                Cards cardDealt = new Cards(colors.get(0), values.get(1));
                myCards.add(new MemCard(cardDealt.color, cardDealt.value));
                myCards.add(new MemCard(cardDealt.color, cardDealt.value));
            }

        }
        Collections.shuffle(myCards);
        flipAllCards();
    }

    public void flipCard(int index) {
        updateScoreAndLevel();
        if (card1 == null && card2 == null)
            flipAllCards();
        ImageView imageView = (ImageView) myFlowPane.getChildren().get(index);
        if (card1 == null) {
            card1 = myCards.get(index);
            imageView.setImage(card1.getImage());
        } else if (card2 == null) {
            card2 = myCards.get(index);
            imageView.setImage(card2.getImage());
            if (card1.value.equals(card2.value) && card1.color.equals(card2.color)) {
                score += 100;
                card1.matched=true;
                card2.matched=true;
                nr_matched++;
            } else score -= 10;
            card1 = null;
            card2 = null;
        }
        advance();
    }

    private void flipAllCards() {
        updateScoreAndLevel();
        for (int i = 0; i < myCards.size(); i++) {
            ImageView imageView = (ImageView) myFlowPane.getChildren().get(i);
            MemCard card = myCards.get(i);

            if (card.matched)
                imageView.setImage(card.getImage());
            else
                imageView.setImage(card.getBackOfCardImage());
        }
    }

    private void updateScoreAndLevel() {
        scoreLabel.setText(Integer.toString(score));
        messageLabel.setText(mesaj);
        levelLabel.setText(Integer.toString(currLevel));
    }

    private void advance() {
        if (nr_matched == number_of_pairs) {
            currLevel++;
            nr_matched = 0;
            number_of_pairs++;
            if (number_of_pairs <= myFlowPane.getChildren().size()/2) {
                updateScoreAndLevel();
                playAgain();
            } else {
                mesaj = "Game Finished";
                updateScoreAndLevel();
            }
        }
    }
}
