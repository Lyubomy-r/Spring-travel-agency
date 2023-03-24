package SpringTravelAgency.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Order")
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
    @JoinColumn(name="user_id")
    private User user;


    public void addOrderToRoom(Room  theRoom){
        this.room=theRoom;
        theRoom.getOrderList().add(this);

    }

    public void addUserToOrder(User thUser){
        this.user=thUser;
        thUser.getOrderList().add(this);
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

    public Room getRoom() {
        return room;
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

    public void setRoom(Room room) {
        this.room = room;
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
