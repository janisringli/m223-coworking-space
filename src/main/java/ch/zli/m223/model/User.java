package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

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

  @Column(nullable = false)
  private String email;


//   Getters
  public Long getId() {
    return id;
  }
  public String getUsername() {
    return username;
  }
  public String getfirstName(){
    return firstName;
  }
  public String getlastName(){
    return lastName;
  }
  public String getPassword() {
    return password;
  }
  public String getEmail() {
    return email;
  }

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
}
