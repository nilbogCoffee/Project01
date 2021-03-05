package Project01;

import Project01.PeopleType;

public class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;


    /**
     * Constructor for People class.
     *
     * Parameters:
     *  nation (String) - which Nation the People instance belongs to
     *  tribe (String) - which Tribe the People instance belongs to
     *  person (PeopleType) - designates the People's PeopleType enum as warrior, wizard, healer, etc.
     *  lifePoints (int) - how much damage a People can take before being removed from play
     *
     * Returns:
     *  People
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     * Returns:
     *  me (PeopleType) - class member, designates whether is warrior, wizard, healer, etc
     *
     * Notes:
     *  not yet used.
     */
    public PeopleType getType() { return me; }

    /**
     * Returns:
     *  myTribe (String) - class member, designates which tribe the People belongs to. Corresponds to tribeName member
     *                         in Tribe class
     *
     * Notes:
     *  not yet used.
     */
    public String getTribe() { return myTribe; }

    /**
     * Returns:
     *  myNation (String) - class member, designates which nation the People belongs to. Corresponds to nationName
     *                          member in both Nation and Tribe class.
     */
    public String getNation()
    { return myNation; }

    /**
     * Returns:
     *  (Boolean) - if class member myLifePoints (int) greater than zero. Used to decide whether or not the People
     *                  should be removed from play
     */
    public Boolean isPersonAlive() { return (myLifePoints > 0); }

    /**
     * Returns:
     *  myLifePoints (int) - class member, amount of total damage a People can take in all encounters before being
     *                          removed from play.
     */
    public int getLifePoints() { return myLifePoints; }

    /**
     * Not yet implemented.
     *
     * Parameters:
     *  otherPerson (People)
     *
     * Notes:
     *  not yet implemented nor used.
     */
    public void encounterStrategy(People otherPerson)
    {
        // TODO: implement later
        if(myNation == otherPerson.getNation())
        {
            // There will be an ugly confrontation
            // Groups attack groups. Group can be an individual or several individuals from any set of tribes
            // if a group has enough lifePoints it can capture its opponent and make it part of the group.
            // Captured opponents do not fight or heal very well. The healers can heal people from same nation
            // normally.
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }


    /**
     * Deals the damage from an encounter to a People's life points.
     *
     * Parameters:
     *  points (int) - amount of damage to subtract from a People's life points after an encounter
     *
     * Notes:
     *  not yet used.
     */
    // TODO: simplify
    public void reduceLifePoints(int points) { myLifePoints = myLifePoints - points; }


    /**
     * Returns:
     *  result (String) - information about a People's nation, tribe, type, and current health, separated by tabs
     */
    public String toString()
    {
        // TODO: simplify
        String result = new String(
                myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints
        );
        return result;
    }
}

