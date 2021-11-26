package com.work.space.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @Column(name = "phone")
    @NotNull
    private Long phone;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "patronymic")
    private String patronymic;
   @Column(name = "address_id")
    private Integer address_id;
   @Column(name = "company_id")
    private Integer company_id;
   @Column(name = "employment_id")
    private Integer employment_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "address_id",insertable = false,updatable = false)
    private Address address;

    @JoinColumn(name = "company_id",insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employment_id",insertable = false,updatable = false)
    private Employment employment;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = { "user_id", "role" }, name = "uk_user_roles") })
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    @JoinColumn(name = "user_id") // https://stackoverflow.com/a/62848296/548473
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OrderBy
    private Set<Role> roles;

    public User() {

    }

    public User(int id, Long phone, String email, String firstName, String secondName, String patronymic,
                Integer address_id,Integer company_id, Integer employment_id,
                Role role, Role... roles){
        super(id);
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address_id = address_id;
        this.company_id = company_id;
        this.employment_id = employment_id;
        this.roles = EnumSet.of(role, roles);
    }

    public User(Long phone, String email, String firstName, String secondName, String patronymic,
                Integer address_id,Integer company_id, Integer employment_id,
                Set<Role> roles) {
        System.out.println("!!!!!!User->");
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address_id = address_id;
        this.company_id = company_id;
        this.employment_id = employment_id;
        this.roles = roles;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isEnabled() {
        return true;
    }

    public Set<Role> getRoles() {
        System.out.println("getRoles->" + roles);
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Address getAddress() {
        System.out.println("getAddress " + address);
        return address;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public Integer getEmployment_id() {
        return employment_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public void setEmployment_id(Integer employment_id) {
        this.employment_id = employment_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone=" + phone +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address_id=" + address_id +
                ", company_id=" + company_id +
                ", employment_id=" + employment_id +
                ", address=" + address +
                ", company=" + company +
                ", employment=" + employment +
                ", roles=" + roles +
                '}';
    }
}
