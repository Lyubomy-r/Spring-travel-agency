package SpringTravelAgency.entity;



import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="room_id")
    private Long roomId;

    @Column(name="number_room")
    private String numberRoom;

    @Column(name="type")
    private String type;

    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private List<Order> orderList;

    public Long getRoomId(){
        return this.roomId;
    }

    public void setRoomId(Long theRoomId){
        this.roomId=theRoomId;
    }

    public String getNumberRoom(){
        return this.numberRoom;
    }

    public void setNumberRoom(String theNumberRoom){
        this.numberRoom=theNumberRoom;
    }

    public Double getType(){
        return this.price;
    }

    public void setPrice(Double thePrice){
        this.price=thePrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", numberRoom='" + numberRoom + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                +'}';
    }
}
