package ch.zli.m223.model;


import java.util.Set;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
  private Long placeNumber;

  public Long getId(){
    return id;
  }
  public Long getPlaceNumber(){
    return placeNumber;
  }

  @OneToMany(mappedBy = "place")
  @JsonIgnore
  private Set<Booking> booking;

  public void setId(Long id){
    this.id = id;
  }
  public void setPlaceNumber(Long placeNumber){
    this.placeNumber = placeNumber;
  }
}
