package Project01;
import Project01.Nation;
import Project01.People;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

/**
 * The class method used for instantiating a game.
 *
 * Members:
 *  allLivingNations (ArrayList<Nation>) - all Nation classes that are playing. Changes from round to round.
 *  worldLivingPopulation (ArrayList<People>) - all People classes that are playing. Changes from round to round.
 *
 * Dependencies:
 * java.utils (Random class; Date class)
 *
 */
public class PlayGame
{
    // Members
    ArrayList<Nation> allLivingNations = new ArrayList<Nation>();
    ArrayList<People> worldLivingPopulation = new ArrayList<People>();
    Random generator;

    /**
     * Constructor for PlayGame class.
     *
     * Instantiates a PlayGame class. Uses a Date class's getTime method to seed a Random generator.
     *
     */
    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
     * Clears the worldLivingPopulation ArrayList of People, then repopulates using each Nation's getNationPopulation
     *  method. Used for refreshing which Nations, and subsequently which Tribes and Peoples, can participate in
     *  encounters.
     *
     * Parameters:
     *  nations (ArrayList<Nation>) - Nations participating
     *
     * Notes:
     *  one of the better functions we've been given.
     */
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }

    /**
     * First calls the getWorldLivingPopulation method to clear the worldLivingPopulation ArrayList,
     * then clears the allLivingNations ArrayList.
     *
     * After, iterates through the Nation classes in nation ArrayList and repopulates allLivingNations with every Nation
     * that returns True when its isNationAlive method is called.
     *
     * Used to refresh which Nations are still playing.
     *
     * Parameters:
     *  nations (ArrayList<Nation>) - Nations with People that can participate in encounters
     */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++)
        {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }

    /**
     * First checks if two People instances are from different Nations to prevent Nations from encountering their own
     *  People.
     *
     * If they are, the generator randomly generates an amount of damage between 0 and 20 for each People to receive.
     *
     * Then, both People have a call made to their reduceLifePoints method to reduce their myLifePoints member by the
     * randomly generated amount.
     *
     * Parameters:
     *  p1 (People) - first combatant in an encounter
     *  p2 (People) - second combatant in an encounter.
     *
     * Notes:
     *  Does not yet support strategies.
     */
    public void encounter(People p1, People p2)
    {
        // FIXME: build strategy functionality
        if(p1.getNation() != p2.getNation())
        {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }

    /**
     * Iterates over all Nation's People eligible to participate in an encounter, or until only one Nation remains.
     *
     * Parameters:
     *  nations (ArrayList<Nation>)
     *
     * Returns:
     *  (Boolean) - returns if only one Nation remains (if there is a victor)
     *
     * Notes:
     *  not intuitive. needs restructuring. better ways to do many things.
     *  does not allow a player to encounter themselves.
     */
    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        // TODO: is worldLivingPopulation being updated correctly after encounters?
        // TODO: simplify, modularize
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            // ensure p1 and p2 are at different People indices
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);

    }

    /**
     * Returns the name of the last remaining nation in the allLivingNations array after the final encounter,
     * or the string "No Winner!" if the array is empty (indicating that no nations remain).
     *
     * Returns:
     *  winner (str) - the name of the winning Nation, if a Nation has won.
     *
     * Notes:
     *  can be greatly simplified
     */
    public String getWinner()
    {
        // TODO: simplify
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
