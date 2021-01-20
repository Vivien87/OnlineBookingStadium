//package com.booking.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table(name = "bookingHistory")
//public class BookingHistory {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    @OneToMany(mappedBy = "sectors", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
//    Set<Sector> sectors;
//    private int numberOfTickets;
//    private long summ;
//
//}
