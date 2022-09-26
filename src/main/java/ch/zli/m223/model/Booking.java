package ch.zli.m223.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
  @JoinColumn(name = "place")
  private Place place;

// id
    public Long getId(){
        return id;
      }
      public void setId(Long id){
        this.id = id;
      }

    //   date
    public LocalDate getDate(){
        return date;
      }
      public void setDate(LocalDate date){
        this.date = date;
      }
    //   starttime
    public LocalDateTime getStartTime(){
        return startTime;
      }
      public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
      }
    //   endtime
      public LocalDateTime getEndTime(){
        return endTime;
      }
      public void setsetEndTime(LocalDateTime endTime){
        this.endTime = endTime;
      }
}
