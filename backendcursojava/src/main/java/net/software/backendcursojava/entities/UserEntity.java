package net.software.backendcursojava.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name ="users")
public class UserEntity implements Serializable {
   
    private static final long serialversionUID 1L;

    @Id
    @GeneratedValue
    Private Long id;

    @Column(nullable = false)
    private String userId;
   
    @Column(nullable = false, length = 50)
    private String firstName;
    
    @Column(nullable = false, length = 50)
    private String lastName;
    
    @Column(nullable = false, length =255)
    private String email;
    
    @Column(nullable = false)
    private String encryptedPassword;

    public static long getSerialversionuid() {
        return serialversionUID;
    }

    public Private getLong() {
        return Long;
    }

    public void setLong(Private l) {
        Long = l;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    
}
