package com.quindiflix.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuenta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCuenta;

  private String estadoServicio;
  private LocalDate fechaUltimoPago;

  @JsonIgnore
  @ToString.Exclude
  @OneToOne
  @JoinColumn(name = "id_usuario")
  private Usuario usuario;

  @JsonIgnore
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "id_plan")
  private Plan plan;

  @JsonIgnore
  @ToString.Exclude
  @OneToMany(mappedBy = "cuenta")
  private List<Perfil> perfiles;

  @JsonIgnore
  @ToString.Exclude
  @OneToMany(mappedBy = "cuenta")
  private List<Pago> pagos;
}
