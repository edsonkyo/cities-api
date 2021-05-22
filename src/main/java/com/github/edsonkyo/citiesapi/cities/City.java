package com.github.edsonkyo.citiesapi.cities;

import javax.persistence.*;

import com.github.edsonkyo.citiesapi.countries.Country;
import com.github.edsonkyo.citiesapi.states.State;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;


@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State state;

    private Integer ibge;

    // 1st
//    @Column(name = "lat_lon")
//    private String geolocation;

    // 2nd
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public City() {
    }

    public City(final Long id, final String name, final State state, final Integer ibge,
                final String geolocation, final Point location) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.ibge = ibge;
//        this.geolocation = geolocation;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getIbge() {
        return ibge;
    }

//    public String getGeolocation() {
//        return geolocation;
//    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Point getLocation() {
        return location;
    }

}