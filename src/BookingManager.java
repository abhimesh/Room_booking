import java.awt.print.Book;
import java.util.*;

public class BookingManager {
    private BookingManager(){};
    static  int bookingId=0;
    private HashMap<Integer,Booking> BookingMap=new HashMap<>();
    RoomManager roomManager;
    private LockById lockById=new LockById();
    private static BookingManager obj=null;
    public static BookingManager getInstance()
    {
        if(obj==null)
        {
            obj=new BookingManager();
        }
        return obj;
    }
    public void putInMap(Booking booking)
    {
        bookingId++;
        booking.bookingId=bookingId;
        BookingMap.put(bookingId,booking);
    }

    public void putInMap(int bookingId,Booking booking)
    {
        BookingMap.put(bookingId,booking);
    }

    public void execute(int startTime,int endTime,int RoomId,int userId)
    {
        lockById.lock(Integer.toString(RoomId));
        Booking booking=new Booking(RoomId,userId,startTime,endTime);
        booking.bookRoom();
        putInMap(booking);
        lockById.unlock(Integer.toString(RoomId));
    }

    public void availableRoomInBuilding(String Building)
    {
        roomManager= RoomManager.getInstance();
        HashMap<Integer,Room>roomHashMap=roomManager.getRoomHashMap();
        for(Map.Entry<Integer,Room> entry : roomHashMap.entrySet())
        {
            if(Objects.equals(entry.getValue().getBuilding(), Building) && entry.getValue().isIsavailable())
            {System.out.println("Room with Room Id: "+entry.getValue().getId()+"is available");}
        }
    }
    public List<Room> avaiableRoomforATimeSlot(int startTime,int endTime)
    {
        roomManager= RoomManager.getInstance();
        HashMap<Integer,Room>roomHashMap=roomManager.getRoomHashMap();
        List<Room> RoomList=new ArrayList<>();
        for(Map.Entry<Integer,Room> entry : roomHashMap.entrySet())
        {
            Room room=entry.getValue();
            if(room.nonoverlapping(room.getStartTime(), room.getEndTime(), startTime,endTime))
            {
                System.out.println("Room with Room Id: "+room.getId()+"is available in"+ room.getBuilding());
                RoomList.add(room);
            }
        }
        return RoomList;
    }
}
