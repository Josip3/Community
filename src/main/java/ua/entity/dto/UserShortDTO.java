package ua.entity.dto;

import ua.entity.enums.Role;

import java.time.LocalDateTime;

public class UserShortDTO {

    protected Integer id;
    protected Integer age;
    protected Boolean isEnabled;
    protected String name;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected String address;
    protected String password;
    protected String mainPhoto;
    protected LocalDateTime dateOfBirth;
    protected Role role;

    public Integer getId() {
        return id;
    }

    public UserShortDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserShortDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public UserShortDTO setEnabled(Boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserShortDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserShortDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserShortDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserShortDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserShortDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserShortDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public UserShortDTO setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
        return this;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public UserShortDTO setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserShortDTO setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "UserShortDTO{" +
                "id=" + id +
                ", age=" + age +
                ", isEnabled=" + isEnabled +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", mainPhoto='" + mainPhoto + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", role=" + role +
                '}';
    }
}
