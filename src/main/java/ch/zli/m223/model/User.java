package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.*;
import javax.ws.rs.MatrixParam;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;
  
  @Column(nullable = false)
  private String password;

  // @Pattern(regexp = "^(.+)@(.+)$")
  @Column(nullable = false)
  private String email;


//   Getters
  public Long getId() {
    return id;
  }
  public String getUsername() {
    return username;
  }
  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public String getPassword() {
    return password;
  }
  public String getEmail() {
    return email;
  }
  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private Set<Booking> booking;

  
   @ManyToOne
   @JoinColumn(name = "roles")
   private Roles roles;


   @OneToMany(mappedBy = "user")
   @JsonIgnore
    private Set<Coffee> Coffee;
//   Setters
  public void setId(Long id) {
    this.id = id;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public void setfirstName(String firstName) {
    this.firstName = firstName;
  }
  public void setlastName(String lastName) {
    this.lastName = lastName;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setRoles(Roles roles) {
    this.roles = roles;
  }
  public Set<Booking> getBooking() {
    return booking;
  }
  public Roles getRoles() {
    return roles;
  }
  public Set<Coffee> getCoffee() {
    return Coffee;
  }
}
