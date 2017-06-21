package sample;

import java.util.Date;

/**
 * Created by Tomasz on 21.06.2017.
 */
public class Reservation {

    private int id;
    private int user_id;
    private int room_id;
    private Date start_time;
    private Date end_time;
    private Date reservation_time;

    public Reservation(int id, int user_id, int room_id, Date start_time, Date end_time, Date reservation_time) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.reservation_time = reservation_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getReservation_time() {
        return reservation_time;
    }

    public void setReservation_time(Date reservation_time) {
        this.reservation_time = reservation_time;
    }

    @Override
    public String toString() {
        return start_time + "," + end_time + "," + reservation_time;
    }
}
