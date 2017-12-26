package ua.entity;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.request.dto.Request;
import ua.entity.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ua.service.validators.ValidationConstants.*;

@AllArgsConstructor
@ToString
@Entity
@Table(name = "_USER_")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private Boolean isEnabled;
    private String name;
    private String lastName;
    private String phoneNumber;
    @Column(name = "email", unique = true, nullable = false)
    @NotNull(message = NULL_MESSAGE, groups = Request.class)
    @Size(min = EMAIL_MIN_SIZE, max = EMAIL_MAX_SIZE, groups = Request.class)
    @Pattern(regexp = EMAIL_PATTERN, message = EMAIL_PATTERN_MESSAGE, groups = Request.class)
    private String email;
    private String address;
    private String password;
    private String mainPhoto;
    @JsonIgnore
    private LocalDateTime dateOfBirth;
    @Enumerated
    private Role role;
    @JsonIgnore
    @ManyToOne
    private Country userCountry;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "GROUP_FROM_USER", joinColumns = @JoinColumn(name = "ID_USER"), inverseJoinColumns = @JoinColumn(name = "ID_GROUP"))
    private List<Group> groupList;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "MUSIC_FROM_USER", joinColumns = @JoinColumn(name = "ID_USER"), inverseJoinColumns = @JoinColumn(name = "ID_MUSIC"))
    private List<Music> musicList;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PHOTO_FROM_USER", joinColumns = @JoinColumn(name = "ID_USER"), inverseJoinColumns = @JoinColumn(name = "ID_PHOTO"))
    private List<Photo> photoList;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "USER_MESSAGE", joinColumns = @JoinColumn(name = "ID_USER"), inverseJoinColumns = @JoinColumn(name = "ID_MESSAGE"))
    private List<Message> messageList;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> postList;

    public User() {
    }

    //повертатиме роль юзера,викликаэться спрингом
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
//        return new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(role.name())));

    }

    //Відповідає за логін юзера
    @Override
    public String getUsername() {
        return email;
        //return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public User setEnabled(Boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public User setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
        return this;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public Country getUserCountry() {
        return userCountry;
    }

    public User setUserCountry(Country userCountry) {
        this.userCountry = userCountry;
        return this;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public User setGroupList(List<Group> groupList) {
        this.groupList = groupList;
        return this;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public User setMusicList(List<Music> musicList) {
        this.musicList = musicList;
        return this;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public User setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
        return this;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public User setMessageList(List<Message> messageList) {
        this.messageList = messageList;
        return this;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public User setPostList(List<Post> postList) {
        this.postList = postList;
        return this;
    }
}
