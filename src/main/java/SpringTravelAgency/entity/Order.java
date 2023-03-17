package SpringTravelAgency.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long orderId;

    @Column(name="date_of_arrive")
    private Date dateOfArrive;

    @Column(name="departure_date")
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;


    public Long getOrderId() {
        return orderId;
    }

    public Date getDateOfArrive() {
        return dateOfArrive;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setOrderId(Long conditionId) {
        this.orderId = conditionId;
    }

    public void setDateOfArrive(Date dateOfArrive) {
        this.dateOfArrive = dateOfArrive;
    }

    public void setDepartureDate(Date departureDate) {
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
