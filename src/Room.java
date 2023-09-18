import java.util.Calendar;

public class Room {
    private String building;
    private int floor;
    private int id;
    private boolean isavailable;
    private int startTime;
    private int endTime;
    Room(String building,int floor,int id)
    {
        this.building=building;
        this.floor=floor;
        this.id=id;
        isavailable=true;
        startTime=-1;
        endTime=-1;
    }

    public boolean nonoverlapping(int startTime1,int endTime1,int startTime2,int endTime2)
    {
        if(endTime2<startTime1)
        {return true;}
        else if(startTime2>endTime1)
        {return true;}
        return false;
    }
    public boolean bookRoom(int startTime,int endTime)
    {
        if(endTime-startTime>12)
        {return false;}
        if(isavailable)
        {this.startTime=startTime;
        this.endTime=endTime;
        isavailable=false;
        return true;}
        else {
            if(nonoverlapping(startTime,endTime,this.startTime,this.endTime))
            {
                this.startTime=startTime;
                this.endTime=endTime;
                isavailable=false;
                return true;
            }
            else {
                System.out.println("Room cannot be booked");
                return false;
            }
        }
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuilding() {
        return building;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isIsavailable() {
        int a=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(a>=startTime&&a<=endTime)
        {return false;}
        return true;

    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
