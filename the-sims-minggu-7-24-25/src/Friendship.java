public class Friendship {
    private final HouseholdDetails householdDetails;
    public int friendshipPoints = -1;

    public Friendship(HouseholdDetails householdDetails) {
        this.householdDetails = householdDetails;
    }

    public boolean addFriend(long simAId, long simBId) {
        if (simAId == simBId) {
            throw new IllegalArgumentException("Cannot befriend yourself.");
        }

        Sims a = householdDetails.getSim(simAId);
        Sims b = householdDetails.getSim(simBId);

        a.addFriend(simBId);
        b.addFriend(simAId);
    }

    // public void removeFriend(long )

    public List
}
