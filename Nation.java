package Project01;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project01.Tribe;
import Project01.People;

public class Nation
{
    private int nationLifePoints;
    public static int nationCount = 0;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();


    /**
     * Instantiates a Nation with a given name and assigns a given lifePoints value to the Nation's nationLifePoints
     *  member.
     * Then, creates 4 Tribe members with 1/4th of the total nationLifePoints, and appends them to the tribes ArrayList.
     * Adds each Tribe's living People to the Nation's population and the adds this population to the livingPopulation.
     *
     * Parameters:
     *  name (String) - the name of the Nation.
     *  lifePoints (int) - when this value hits 0, the Nation is removed from the game and the Nation has lost.
     *
     * Notes:
     *  Number of tribes and allocation of nationLifePoints should be modularized. Currently is an arbitrary allocation.
     *  Assigning population to livingPopulation is also arbitrarily done.
     */
    public Nation(String name, int lifePoints)
    {
        nationCount++;
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 3; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 3));
        for(int i = 0; i < 4; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 4));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     * Returns:
     *  (Boolean) - class member nationLifePoints (int) is greater than 0. When False, a Nation has lost.
     */
    public Boolean isNationAlive() { return (nationLifePoints > 0); }

    /**
     * Clears and reloads People into livingPopulation Array List and recalculates nationLifePoints based upon the new
     *  livingPopulation's People. Used to refresh the People able to participate after an encounter.
     *
     * Returns:
     *  livingPopulation (ArrayList<People>) - class member, People that can participate in encounters next round
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }

    /**
     * Returns:
     *  nationName (String) - class member
     */
    public String getNationName()
    {
        return nationName;
    }

    /**
     * Prints whether the first Tribe member in the tribes ArrayList is alive, and if so, how many members it has.
     *
     * Notes:
     *  not currently used.
     */
    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    /**
     * Concatenates a newline character after the Nation's name, then each Tribe's name, a newline after each Tribe
     *  name, and a final newline character, then returns.
     *
     * Returns:
     *  result (String) - completed concatenation
     *
     */
    public String toString()
    {
        String result = "\0"; // keep this for now, might be necessary to += onto -- unfamiliar w/ this lang
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
