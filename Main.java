package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {


    public static void main(String[] args)
    {
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
