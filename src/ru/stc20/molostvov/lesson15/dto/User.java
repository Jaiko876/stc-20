package ru.stc20.molostvov.lesson15.dto;

public class User {
    private int id;
    private String name;
    private String birthday;
    private int login_ID;
    private String city;
    private String email;
    private String description;

    User(){}

    public User(String name, String birthday, String city, String email, String description) {
        this.name = name;
        this.birthday = birthday;
        this.city = city;
        this.email = email;
        this.description = description;
    }

    public User(int id, String name, String birthday, int login_ID, String city, String email, String description) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.login_ID = login_ID;
        this.city = city;
        this.email = email;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getLogin_ID() {
        return login_ID;
    }

    public void setLogin_ID(int login_ID) {
        this.login_ID = login_ID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", login_ID=" + login_ID +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
