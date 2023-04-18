package SpringTravelAgency.entity;


import SpringTravelAgency.entity.enumpack.Role;
import SpringTravelAgency.entity.enumpack.Status;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @NotEmpty(message ="is required")
    @Pattern(regexp="^[a-zA-Z]{3,30}",message="Write a correct First Name. Use only chars. Not more than 30.")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message ="is required")
    @Pattern(regexp="^[a-zA-Z]{3,30}",message="Write a correct First Name. Use only chars. Not more than 30.")
    @Column(name="last_name")
    private String lastName;
    @NotEmpty(message ="is required")
    @Email(message = "Please enter a valid email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    @Column(name="email")
    private String email;

    @NotEmpty(message ="is required")
    @Column(name="password")
    private String password;

    @Column(name="role")

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name="status")

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
    private List<Order> orderList;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
