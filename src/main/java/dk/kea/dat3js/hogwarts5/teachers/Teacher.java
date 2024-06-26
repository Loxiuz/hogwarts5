package dk.kea.dat3js.hogwarts5.teachers;

import dk.kea.dat3js.hogwarts5.PersonWithNames;
import dk.kea.dat3js.hogwarts5.house.House;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Teacher implements PersonWithNames {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  @ManyToOne
  private House house;
  private String mainSubject;
  private LocalDate employmentDate;

  public Teacher() {
  }

  public Teacher(String firstName, String lastName, House house, String mainSubject, LocalDate employmentDate) {
    this(firstName, null, lastName, house, mainSubject, employmentDate);
  }

  public Teacher(String firstName, String middleName, String lastName, House house, String mainSubject, LocalDate employmentDate) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.house = house;
    this.mainSubject = mainSubject;
    this.employmentDate = employmentDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = capitalize(firstName);
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    if (middleName != null && middleName.contains(" ")) {
      String[] names = middleName.split(" ");
      String[] capitalizedNames = Arrays.stream(names).map(this::capitalize).toArray(String[]::new);
      this.middleName = String.join(" ", capitalizedNames);
    }
    else {
      this.middleName = capitalize(middleName);
    }
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = capitalize(lastName);
  }

  public String getFullName(){
    return firstName + " " + (middleName !=null ? middleName + " " : "") + lastName;
  }

  public House getHouse() {
    return house;
  }

  public void setHouse(House house) {
    this.house = house;
  }

  public String getMainSubject() {
    return mainSubject;
  }

  public void setMainSubject(String mainSubject) {
    this.mainSubject = mainSubject;
  }

  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  public void setEmploymentDate(LocalDate employmentDate) {
    this.employmentDate = employmentDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Teacher teacher = (Teacher) o;
    return Objects.equals(getFirstName(), teacher.getFirstName()) && Objects.equals(getMiddleName(), teacher.getMiddleName()) && Objects.equals(getLastName(), teacher.getLastName()) && Objects.equals(getHouse().getName(), teacher.getHouse().getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getHouse().getName());
  }
}
