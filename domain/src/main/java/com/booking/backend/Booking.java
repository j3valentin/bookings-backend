package com.booking.backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    private @Id @GeneratedValue Long id;

    private String passengerName;
    private String passengerContactNumber;
    private LocalTime pickupTime;
    private Instant asap;
    private Duration waitingTime;
    private Integer numberOfPassengers;
    private BigDecimal price;
    private Float rating;

    private @CreationTimestamp LocalDateTime createdOn;

    private @UpdateTimestamp LocalDateTime lastModifiedOn;

    @OneToMany
    private List<TripWaypoint> tripWayPoints = new ArrayList<>();
}
