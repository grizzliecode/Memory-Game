package com.example.memorygame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemCardTest {
    MemCard card = new MemCard(MemCard.getValidColor().get(0),MemCard.getValidValue().get(1));

    @Test
    @DisplayName("Card can have only four colors")
    void verifyColors()
    {
        Assertions.assertThat(card.color).isIn(Cards.getValidColor());
    }

    @Test
    @DisplayName("Card can have only four values")
    void verifyValues()
    {
        Assertions.assertThat(card.value).isIn(Cards.getValidValue());
    }

    @Test
    @DisplayName("Card should be initially unmatched")
    void verifyMatch()
    {
        assertFalse(card.matched);
    }
}