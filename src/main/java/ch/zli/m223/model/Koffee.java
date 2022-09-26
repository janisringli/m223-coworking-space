package ch.zli.m223.model;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Koffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
  private Float price;

  @Column(nullable = false)
  private LocalDateTime time;

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }
  public Float getPrice(){
    return price;
  }
  public void setPrice(Float price){
    this.price = price;
  }
  public LocalDateTime getTime(){
    return time;
  }
  public void setTime(LocalDateTime time){
    this.time = time;
  }
}
