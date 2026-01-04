public class Friend {
    public String name;
    public int friendshipPoint;

    public Friend(String name, int friendshipPoint) {
        this.name = name;
        this.friendshipPoint = friendshipPoint;
    }

    public String getFriendshipStatus() {
        if (friendshipPoint == 100) 
            return "Best Friend";
        else if (friendshipPoint >= 75) 
            return "Good Friend";
        else if (friendshipPoint >= 50) 
            return "Friend";
        else 
            return "Acquaintance";
    }

    // public void addFriendshipPoint(Sims p, Sims o) {
    //     for (Friend friend : p.friends) {
    //         if (friend.name == o.name) {

    //         }
    //     }
    // }
}
