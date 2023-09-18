import java.util.HashMap;
import java.util.List;

public class userManager {
    private static int userId=0;
    private userManager(){};
    static private userManager obj=null;
    HashMap<Integer,user> hashMap=new HashMap<Integer, user>();
    static public userManager getInstance()
    {
        if(obj==null)
        {
            obj=new userManager();
        }
        return obj;
    }
    public  void putinMap(user user)
    {
        userId++;
        user.setUserId(userId);
        hashMap.put(userId,user);

    }
    public void putinMap(int userId,user user)
    {
        hashMap.replace(userId,user);
    }
    public user getuser(int id)
    {
        return hashMap.get(id);
    }
    List<Booking> allBookingByUser(int id)
    {
        userManager usermanager=getInstance();
        user user=usermanager.getuser(id);
        for(int i=0;i<user.getSuccessfulBooking().size();i++)
        {
            System.out.print(user.getSuccessfulBooking().get(i).roomId+" ");

            System.out.print(user.getSuccessfulBooking().get(i).startTime+" ");

            System.out.println(user.getSuccessfulBooking().get(i).endTime+" ");
        }
        return user.getSuccessfulBooking();
    }
}
