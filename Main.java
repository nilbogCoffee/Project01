package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {

    /**
     * Instantiates a PlayGame class between different Nation classes with 1000 life points each.
     * Then, plays 40 rounds, and determines after if there is a winner before printing.
     *
     */
    public static void main(String[] args)
    {
        // TODO: modularize this value to a base amount to be used by all nations
        int gameLifePoints = 5000;
        ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
        PlayGame game = new PlayGame();
        // TODO: reformat...
        nations.add(new Nation("Idiots", (gameLifePoints / 3))); //Probably delete these nations eventually
        nations.add(new Nation("Minions", (gameLifePoints) / 3));
        nations.add(new Nation("Wolves", (gameLifePoints) / 3)); //Kimberly Wolf's Tribe
        nations.add(new Nation("Bogfrogs", (gameLifePoints) / 3)); // Eric Gorski's Nation
        // TODO
        // TODO: attn shane, add your nation here and then delete this TODO and the 2 encapsulating it
        // TODO
        int gameLifePoints = 3000;
        ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
        PlayGame game = new PlayGame();
        nations.add(new Nation("Idiots", (gameLifePoints / 3))); //Probably delete these nations eventually
        nations.add(new Nation("Minions", (gameLifePoints) / 3));

        nations.add(new Nation("Wolves", (gameLifePoints) / 3)); //Kimberly Wolf's Tribe
        // could add and delete nations. return number of nations + 1 from add and number of nations -1 from remove.
        for(int i = 0; i < 40; i++)
        {
           System.out.println("Round number: " + i);
           if (game.playOneRound(nations))
           {
               System.out.println("There is a winner!");
               break; // game over
           }
        }

        System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}
