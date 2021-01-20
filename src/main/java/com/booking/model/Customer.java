//package com.booking.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Set;
//
//@NoArgsConstructor
//@Getter
//@Setter
//@Table(name="customer")
//@Entity
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private String name;
//    private int age;
//    private long balance;
//    @OneToMany(mappedBy = "BookingHistory", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
//    private Set<BookingHistory> histories;
//    private Date bookingDate;
//
//}
