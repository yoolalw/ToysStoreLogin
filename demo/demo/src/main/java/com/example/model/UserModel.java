package com.example.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String user;

    @Column(nullable = false)
    private String password;

    public UserModel() {}

    public UserModel(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return user;
    }

    public void setUsername(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }
}
