//package com.booking.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "stadium")
//class Stadium {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @OneToMany(mappedBy = "sectors", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Sector> sectors;
//}
