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

import lombok.Data;

/**
 * Address entity.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(schema = SCHEMA, name = "trip_segment")
public class TripSegment {

  private static final String SEQUENCE_NAME = "trip_segment_tsid_seq";

  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer tsid;

  @JoinColumn(name = "tid", referencedColumnName = "tid")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Trip trip;

  @JoinColumn(name = "cid", referencedColumnName = "cid")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Card card;

  @JoinColumn(name = "uid", referencedColumnName = "uid")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private User user;

  @JoinColumn(name = "start", referencedColumnName = "sid")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Station start;

  @JoinColumn(name = "stop", referencedColumnName = "sid")
  @ManyToOne(cascade = CascadeType.PERSIST)
  private Station stop;

  private Double fare;

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
