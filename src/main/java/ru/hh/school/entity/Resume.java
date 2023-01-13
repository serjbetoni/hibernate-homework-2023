package ru.hh.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "resume")
public class Resume {
  @Id
  @GeneratedValue(generator = "resumeIdSeq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "resumeIdSeq", sequenceName = "resume_id_seq", allocationSize = 10)
  private Integer id;

  @Column
  private String description;

  public Integer getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Resume(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Resume resume = (Resume) o;
    return id.equals(resume.getId()) && description.equals(resume.getDescription());
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + description.hashCode();
    return result;
  }

}
