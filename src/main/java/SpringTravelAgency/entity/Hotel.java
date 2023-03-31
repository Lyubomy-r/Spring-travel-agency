package SpringTravelAgency.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hotel_id")
    private Long hotelId;

    @Column(name="name_hotel")
    private String nameHotel;


    @Column(name="description")
    private String description;
    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "hotel")
    private List<Room> rooms;

    @OneToMany(cascade=CascadeType.ALL, mappedBy= "hotel")
    private  List<Order> orderList;

    public void addOrdersToHotel(Order theOrder){
        this.orderList.add(theOrder);
        theOrder.setHotel(this);
    }

    public void addOrdersToHotel(Room theRoom){
        this.rooms.add(theRoom);
        theRoom.setHotel(this);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Long getHotelId(){
        return this.hotelId;
    }

    public void setHotelId(Long theHotelId){
        this.hotelId=theHotelId;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String theNameHotel){
        this.nameHotel=theNameHotel;
    }

    public String getCountry(){
        return this.country;
    }

    public void setCountry(String theCountry){
        this.country=theCountry;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String theCity){
        this.city=theCity;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", nameHotel='" + nameHotel + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
