package com.example.airportflightsystem.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flight")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "departure airline can't be null")
    @Column(name="departure_airline")
    private  String departureAirline;

    @NotNull(message = "arrival airline can't be null")
    @Column(name="arrival_airline")
    private String arrivalAirline;

    @NotNull(message = "price can not be null")
    @Column(name="price")
    private Integer price;

    @NotNull(message = "departure date can't be null")
    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "getting_back_date")
    private Date gettingBackDate;
    @JsonGetter("flightType")
    public String getFlightType() {
        return this.gettingBackDate == null ? "Tek Yönlü" : "Çift Yönlü";
    }

}
