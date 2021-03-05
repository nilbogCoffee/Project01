package Project01;

public enum PeopleType
{
    healer ("Heely"),
    warrior ("Solder"),
    wizzard  ("Tricky");

    private String description;

    /**
     * Sets the enum's description member to the provided types String.
     *
     * Parameters:
     *  types (String)
     */
    PeopleType (String types) { description = types; }

    /**
     * Returns:
     *  description (String)
     */
    public String getDescription() { return description; }
}
