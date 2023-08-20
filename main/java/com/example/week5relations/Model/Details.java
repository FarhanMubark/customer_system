package com.example.week5relations.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Details {
    @Id

    private Integer id;

    private String gender;
    private Integer age;
    private String email;

    @OneToOne
    @MapsId // take the id from customer model
    @JsonIgnore
    private Customer customer;
}
