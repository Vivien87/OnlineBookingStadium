``package com.booking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Table(name="customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date birthDate;
    private Long balance;
    private LocalDateTime created;
    private LocalDateTime updated;
    private LocalDateTime deleted;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = SectorType.class)
    private List<Customer> c = new ArrayList<>();

}
