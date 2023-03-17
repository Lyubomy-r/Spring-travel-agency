package SpringTravelAgency.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="hotel_id")
    private Long hotelId;

    @Column(name="name_hotel")
    private String nameHotel;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "hotel")
    List<Room> rooms;

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
}
