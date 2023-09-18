import java.util.ArrayList;
import java.util.List;

public class user {
    String name;
    int userId;
    private List<Booking> BookingList=new ArrayList<>();
    user(String name)
    {
        this.name=name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
    void addBooking(Booking booking)
    {
        BookingList.add(booking);
    }

    public List<Booking> getSuccessfulBooking() {
        return BookingList;
    }
}
