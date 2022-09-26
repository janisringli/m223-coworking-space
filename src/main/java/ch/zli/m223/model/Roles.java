package ch.zli.m223.model;


import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
  private String roleName;


  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName){
    this.roleName = roleName;
  }
    
}
