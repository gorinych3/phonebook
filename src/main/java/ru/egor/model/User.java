package ru.egor.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "l_name")
    private String l_name;

    @Column(name = "address")
    private String address;

    @Column(name = "home_phone")
    private String home_phone;

    @Column(name = "m_phone")
    private String m_phone;

    @Column(name = "profession")
    private String profession;

    //создаем компонент уже после создания основной таблицы
    @Embedded
    private Car car;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
    private Set<UsersPet> usersPets;


    public User(){}

    public User(int id, String f_name, String l_name, String address, String home_phone, String m_phone, String profession) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.address = address;
        this.home_phone = home_phone;
        this.m_phone = m_phone;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<UsersPet> getUsersPets() {
        return usersPets;
    }

    public void setUsersPets(Set<UsersPet> usersPets) {
        this.usersPets = usersPets;
    }

    @Override
    public String toString() {
        return "User " + id +
                ":   First '" + f_name + '\'' +
                ", Last '" + l_name + '\'' +
                ", Address '" + address + '\'' +
                ", Phone '" + home_phone + '\'' +
                ", Mobile '" + m_phone + '\'' +
                ", Profession '" + profession + '\'' +
                ", Car " + car +
                ", Pets " + usersPets +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(f_name, user.f_name) &&
                Objects.equals(l_name, user.l_name) &&
                Objects.equals(address, user.address) &&
                Objects.equals(home_phone, user.home_phone) &&
                Objects.equals(m_phone, user.m_phone) &&
                Objects.equals(profession, user.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, f_name, l_name, address, home_phone, m_phone, profession);
    }
}
