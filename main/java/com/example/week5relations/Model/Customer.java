package com.example.week5relations.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

// @Data annotation contain required arg construct
@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @OneToOne(cascade = CascadeType.DETACH, mappedBy = "customer")  // one customer follow details, Detach
    @PrimaryKeyJoinColumn // detaild will connect with customer above
    private Details details;

}
