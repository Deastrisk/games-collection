public class Friend {
    public String name;
    public int friendshipPoint;

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
}
