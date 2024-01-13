package com.example.memorygame;

import java.io.*;

public class ScoreReader {

    public static String readFromFile()
    {
        try {
            BufferedReader reader = new BufferedReader( new FileReader("score.txt"));
            String highscore = reader.readLine();
            reader.close();
            return highscore;

        }
        catch (IOException e)
        {
            System.out.println(e);
            return "Highscore err";
        }
    }

    public static void writeToFile(String highscore)
    {
        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter("score.txt"));
            writer.write(highscore);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
