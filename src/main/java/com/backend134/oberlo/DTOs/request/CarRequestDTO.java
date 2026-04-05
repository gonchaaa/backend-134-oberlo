package com.backend134.oberlo.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDTO {
    private String carName;
    private String description;
    private String imageUrl;
    private long price;
    private Integer year;
    private Long modelId;
}
