package SpringTravelAgency.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="OrderDate")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    @Column(name="date_of_arrive")
    private LocalDate dateOfArrive;

    @Column(name="departure_date")
    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public void addOrderToHotel(Hotel  theHotel){
        this.hotel=theHotel;
        theHotel.getOrderList().add(this);

    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public void addOrderToRoom(Room  theRoom){
        this.room=theRoom;
        theRoom.getOrderList().add(this);

    }

    public void addUserToOrder(User thUser){
        this.user=thUser;
        thUser.getOrderList().add(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Long getOrderId() {
        return orderId;
    }

    public LocalDate getDateOfArrive() {
        return dateOfArrive;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setOrderId(Long conditionId) {
        this.orderId = conditionId;
    }

    public void setDateOfArrive(LocalDate dateOfArrive) {
        this.dateOfArrive = dateOfArrive;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }



    @Override
    public String toString() {
        return "Order{" +
                "conditionId=" + orderId +
                ", dateOfArrive=" + dateOfArrive +
                ", departureDate=" + departureDate +
                '}';
    }
}
