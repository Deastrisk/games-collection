public class Friendship {
    private final HouseholdDetails householdDetails;
    public int friendshipPoints = -1;
    public long idA;
    public long idB;

    public Friendship(HouseholdDetails householdDetails) {
        this.householdDetails = householdDetails;
    }

    public void addFriend(long simAId, long simBId) {
        if (simAId == simBId) {
            throw new IllegalArgumentException("Cannot befriend yourself.");
        }

        Sims a = householdDetails.getSim(simAId);
        Sims b = householdDetails.getSim(simBId);

        a.addFriend(simBId);
        b.addFriend(simAId);
        this.idA = simAId;
        this.idB = simBId;
        friendshipPoints = 10;
        householdDetails.friendships.add(this);
    }

    public void addFriendshipPoint(Sims p, Sims o, int amount) {
        // for (Friendship friendship : householdDetails.friendships) {
        if (idA == p.getId() && idB == o.getId()) {
            friendshipPoints += amount;
        }
        // }
    } 
}
