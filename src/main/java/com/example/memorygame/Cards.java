package com.example.memorygame;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Cards {

    public String color;
    public String value;

  public Cards(String color, String value)
  {
        if(validateColor(color) && validateValue(value))
        {
            this.value=value;
            this.color=color;
        }
  }

  public static List<String> getValidColor()
  {
      return Arrays.asList("red", "green", "blue", "yellow");
  }
  public boolean validateColor(String color)
  {
      if(getValidColor().contains(color.toLowerCase()))
      {
          return true;
      }
      return false;
  }
    public static List<String> getValidValue()
    {
        return Arrays.asList("star", "square", "circle","triangle");
    }
    public boolean validateValue(String value)
    {
        if(getValidValue().contains(value.toLowerCase()))
        {
            return true;
        }
        return false;
    }

    public Image getImage()
    {
        String pathName = this.color+this.value;
        return new Image(Cards.class.getResourceAsStream("images/"+pathName+".png"));
    }

    public Image getBackOfCardImage()
    {
        return new Image(Cards.class.getResourceAsStream("images/Back.png"));
    }

}
