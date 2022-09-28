package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters")
  private String firstName;

  @Column(nullable = false)
  @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain letters")
  private String lastName;
  
  @Column(nullable = false)
  @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password can only contain letters and numbers")
  private String password;

  @Pattern(regexp = "^(.+)@(.+)$")
  @Column(nullable = false, unique = true)
  private String email;



  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private Set<Booking> booking;

  
   @ManyToOne
   @JoinColumn(name = "roles")
   private Roles roles;


   @OneToMany(mappedBy = "user")
   @JsonIgnore
    private Set<Coffee> coffee;


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public Set<Booking> getBooking() {
    return booking;
  }


  public void setBooking(Set<Booking> booking) {
    this.booking = booking;
  }


  public Roles getRoles() {
    return roles;
  }


  public void setRoles(Roles roles) {
    this.roles = roles;
  }


  public Set<Coffee> getCoffee() {
    return coffee;
  }


  public void setCoffee(Set<Coffee> coffee) {
    this.coffee = coffee;
  }

}
