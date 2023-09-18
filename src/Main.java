public class Main {
    public static void main(String[] args) {
        Room room1=new Room("alpha",1,123);
        Room room2=new Room("Beta",1,234);
        Room room3=new Room("Gaama",2,345);
        Room room4=new Room("Delta",3,456);
        Room room5=new Room("Delta",3,567);

        RoomManager roomManager=RoomManager.getInstance();
        roomManager.putInHashMap(room1);
        roomManager.putInHashMap(room2);
        roomManager.putInHashMap(room3);
        roomManager.putInHashMap(room4);
        roomManager.putInHashMap(room5);
        BookingManager bookingManager=BookingManager.getInstance();
        bookingManager.availableRoomInBuilding("Delta");
        userManager usermanager=userManager.getInstance();
        user user=new user("Abhimesh");
        usermanager.putinMap(user);
        bookingManager.execute(11,13,456,1);
        bookingManager.execute(12,14,456,1);
        bookingManager.availableRoomInBuilding("Delta");
        usermanager.allBookingByUser(1);
        bookingManager.avaiableRoomforATimeSlot(12,14);
    }
}