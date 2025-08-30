package com.backend134.oberlo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String carName;
    private String description;
    private String imageUrl;
    private Long price;
    private Integer year;
    @ManyToOne
    @JoinColumn(name ="models_id",nullable = false)
    private Models modelId;
}
