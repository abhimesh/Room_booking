import java.util.HashMap;

public class RoomManager {

    private RoomManager(){};
    private HashMap<Integer,Room> roomHashMap=new HashMap<>();
    static private RoomManager obj=null;
    public static RoomManager getInstance(){
        if(obj==null)
        {obj=new RoomManager();}
        return obj;
    }
    public Room getRoom(int id)
    {
        return roomHashMap.get(id);
    }
    public void putInHashMap(Room room)
    {

        roomHashMap.put(room.getId(), room);
    }
    public void putInHashMap(int roomId,Room room)
    {
        roomHashMap.put(roomId,room);
    }

    public HashMap<Integer, Room> getRoomHashMap() {
        return roomHashMap;
    }
}
