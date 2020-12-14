package com.audioappraiser.audioapp.model;

import java.util.Objects;
import javax.persistence.*;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String real_name;
    private Boolean is_private;

    public User() {
    }

    public User(String username, String real_name, Boolean is_private) {
        this.username = username;
        this.real_name = real_name;
//        this.password = password;
        this.is_private = is_private;
    }
}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) &&
//                Objects.equals(username, user.username) &&
//                Objects.equals(real_name, user.real_name) &&
////                Objects.equals(password, user.password) &&
//                Objects.equals(is_private, user.is_private);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, username, real_name, is_private);
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername(){
//        return username;
//    }
//
//    public void  setUsername(String username){
//        this.username = username;
//    }
//
//    public String getReal_name(){
//        return real_name;
//    }
//
//    public void setReal_name(String real_name){
//        this.real_name = real_name;
//    }
//
//    public Boolean getIs_private(){
//        return is_private;
//    }
//
//    public void setIs_private(Boolean is_private){
//        this.is_private = is_private;
//    }
//
////    @Override
//    public String ToString(){
//        return "username:" + this.username +
//                ", real_name:" + this.real_name +
//                ", is_private:" + this.is_private.toString();
//    }
//}
