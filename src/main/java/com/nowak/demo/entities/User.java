package com.nowak.demo.entities;




import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users")
public class User {

    private String email;
    private String password;
    private String phoneNumber;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="users_subs", joinColumns = @JoinColumn(name="user_email"), inverseJoinColumns = @JoinColumn(name="subs_id"))
    private Collection<Subscription> subscriptionCollection;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Subscription> getSubscriptionCollection() {
        return subscriptionCollection;
    }

    public void setSubscriptionCollection(Collection<Subscription> subscriptionCollection) {
        this.subscriptionCollection = subscriptionCollection;
    }
}
