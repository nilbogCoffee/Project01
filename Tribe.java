package Project01;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import Project01.People;
import Project01.PeopleType;

public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Constructs a Tribe class.
     *
     * Instantiates a PeopleType.warrior People member and a PeopleType.wizzard People member to
     *  class member members, then adds these People members to the livingMembers member.
     *
     * Parameters:
     *  nation (String) - which nation the Tribe belongs to
     *  tribe (String) - the name of the Tribe
     *  lifePoints (int) - collective life points between the Tribe's People members
     *
     * Returns:
     *  Tribe
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        // TODO: modularize, simplify, improve
        for(int i = 0; i < 3; i++) {
            if (i % 3 == 0)
                members.add(new People(nationName, tribeName, PeopleType.healer, tribeLifePoints / 3));
            else if (i % 3 == 1)
                members.add(new People(nationName, tribeName, PeopleType.warrior, tribeLifePoints / 3));
            else
                members.add(new People(nationName, tribeName, PeopleType.wizzard, tribeLifePoints / 3));
        }
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * Clears the livingMembers ArrayList and resets tribeLifePoints to 0.
     *
     * Then adds People members from the "members" ArrayList to the livingMembers ArrayList
     *  if their myLifePoints > 0 via the isPersonAlive method,
     *  and adds their myLifePoints to the previously-zeroed tribeLifePoints.
     *
     * Returns:
     *  livingMembers (ArrayList<People>) - class member, ArrayList of People members with myLifePoints (int) members
     *                                          greater than 0. Used to determine which People participate in subsequent
     *                                          encounters.
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        // TODO: improve
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                // TODO: if permitted, improve this to update the Nation's lifePoints dynamically here instead of in its
                //       own other function
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }

    // Unused as of Sprint 1
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/

    /**
     * Returns:
     *  (int) - length of class member livingMembers(ArrayList<People>)
     */
    public int getTribeSize() { return livingMembers.size(); }

    /**
     * Returns if class member tribeLifePoints(int) is greater than 0. Used to determine if a Tribe can participate
     *  in an encounter.
     *
     * Returns:
     *  bool
     */
    public Boolean isTribeAlive() { return (tribeLifePoints > 0); }

    /**
     * Returns:
     *  tribeLifePoints (int) - class member, collective number of life points among People in the Tribe that can
     *                              still participate in encounters.
     */
    public int getTribeLifePoints() { return tribeLifePoints; }

    /**
     * Returns:
     *  tribeName (String) - class member
     */
    public String getTribeName() { return tribeName; }

    /**
     * Appends the output from every class member "members"'s People to a string containing the null character,
     *  each output followed by a newline character.
     *
     * Returns:
     *  result (String) - String containing output from each tribe, separated/followed by newlines
     */
    public String toString()
    {
        // TODO: improve, simplify
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
