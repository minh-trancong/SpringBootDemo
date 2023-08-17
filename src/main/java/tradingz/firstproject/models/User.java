package tradingz.firstproject.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User implements Serializable {
    public User() {
    }
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;



    public Integer getUserID() {
        return this.id;
    }

    public void setUserID(Integer userID) {
        this.id = userID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}