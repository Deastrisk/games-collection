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

    public void addFriendshipPoint(long idA, long idB, int amount) {
        if (this.idA == idA && this.idB == idB) {
            friendshipPoints += amount;
        }
    }

    public String getFriendshipStatus() {
        if (friendshipPoints == 100) 
            return "Best Friend";
        else if (friendshipPoints >= 75) 
            return "Good Friend";
        else if (friendshipPoints >= 50) 
            return "Friend";
        else 
            return "Acquaintance";
    }
}
