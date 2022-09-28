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

  @ManyToOne
  @JoinColumn(name = "user")
  private User user;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public LocalDate getDate() {
    return date;
}

public void setDate(LocalDate date) {
    this.date = date;
}

public LocalDateTime getStartTime() {
    return startTime;
}

public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
}

public LocalDateTime getEndTime() {
    return endTime;
}

public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
}

public Place getPlace() {
    return place;
}

public void setPlace(Place place) {
    this.place = place;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}


}
