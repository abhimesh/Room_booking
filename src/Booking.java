public class Booking {
    int roomId ;
    int userId;
    int startTime;
    int endTime;
    int bookingId;

    Booking(int roomId,int userId,int startTime,int endTime)
    {
        this.roomId=roomId;
        this.userId=userId;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public boolean bookRoom()
    {
        RoomManager roomManager=RoomManager.getInstance();
        userManager usermanager= userManager.getInstance();
        Room room=roomManager.getRoom(roomId);
        user user=usermanager.getuser(userId);
        if(room.bookRoom(startTime,endTime))
        {
            user.addBooking(new Booking(roomId,userId,startTime,endTime));
            usermanager.putinMap(user.getUserId(),user);
            roomManager.putInHashMap(room.getId(),room);
            return true;
        }

        else {user.addBooking(new Booking(roomId,userId,startTime,endTime));
            usermanager.putinMap(user.getUserId(),user);
            return false;}
    }


}
