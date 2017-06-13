package sample;

/**
 * Created by Tomasz on 13.06.2017.
 */
public class Room {

    private int id;
    private String number;
    private int seats;
    private int type;

    public Room(int id, String number, int seats, int type) {
        this.id = id;
        this.number = number;
        this.seats = seats;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
