package edu.utoronto.group0162.core.entity;

import static config.SystemDefaultProperty.SCHEMA;

import java.time.Instant;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Address entity.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "station")
public class Station {

  private static final String SEQUENCE_NAME = "station_sid_seq";

  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer sid;

  private Integer point;

  @Size(max = 50)
  @Column(length = 50)
  private String name;

  @JoinColumn(name = "rid", referencedColumnName = "rid")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Route route;

  @Column(name = "created_at")
  private Long createdAt;

  @Column(name = "modified_at")
  private Long modifiedAt;

  @PrePersist
  public void prePresist() {
    this.createdAt = Instant.now().getEpochSecond();
  }

  @PreUpdate
  public void preUpdate() {
    this.modifiedAt = Instant.now().getEpochSecond();
  }
}
