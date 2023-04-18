package SpringTravelAgency.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name="Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Long roomId;
    @NotNull(message ="is required")
    @Column(name="number_room")
    private Integer numberRoom;
    @NotEmpty(message ="is required")
    @Column(name="type")
    private String type;
    @NotNull(message ="is required")
    @Min(0)
    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "room")
    private List<Order> orderList;



    public void addOrderToRoom(Order theOrder){
        this.orderList.add(theOrder);
        theOrder.setRoom(this);
    }

    public void addHotelToRoom(Hotel theHotel){
        this.hotel=theHotel;
        theHotel.getRooms().add(this);
    }


    public Long getRoomId(){
        return this.roomId;
    }

    public void setRoomId(Long theRoomId){
        this.roomId=theRoomId;
    }

    public Integer getNumberRoom(){
        return this.numberRoom;
    }

    public void setNumberRoom(Integer theNumberRoom){
        this.numberRoom=theNumberRoom;
    }

    public String getType(){
        return this.type;
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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
