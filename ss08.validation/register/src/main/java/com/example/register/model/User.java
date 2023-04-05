package com.example.register.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name", nullable = false)
    @Size(min = 5, max = 45 ,message = "Độ dài tối thiểu từ 5 đến 45 ký tự")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @Size(min = 5, max = 45, message = "Độ dài tối thiểu từ 5 đến 45 ký tự")
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại không đủ 10 số")
    private String phoneNumber;
    @Min(value = 18 ,message = "Độ tuổi phải hơn 18 tuổi")
    @NotNull(message = "tuổi không được phép để trống")
    private Integer age;
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$" ,message = "Không đúng định dạng example@gmail")
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User(String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
