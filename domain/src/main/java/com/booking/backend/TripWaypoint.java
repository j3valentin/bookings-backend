package com.booking.backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TripWaypoint {
    @Id
    @GeneratedValue
    private Long id;
    private String locality;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
