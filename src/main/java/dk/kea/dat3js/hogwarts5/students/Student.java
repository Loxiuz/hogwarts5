package dk.kea.dat3js.hogwarts5.students;

import dk.kea.dat3js.hogwarts5.PersonWithNames;
import dk.kea.dat3js.hogwarts5.house.House;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Student implements PersonWithNames {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String gender;
  @ManyToOne
  private House house;
  private Boolean prefect;
  private Integer schoolYear; // 1-7

  public Student() {
  }

  public Student(String firstName, String lastName, String gender, House house, Boolean prefect, int schoolYear) {
    this(firstName, null, lastName, gender, house, prefect, schoolYear);
  }

  public Student(String firstName, String middleName, String lastName, String gender, House house, Boolean prefect, int schoolYear) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.gender = gender;
    this.house = house;
    this.prefect = prefect;
    this.schoolYear = schoolYear;
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

  public String getGender() {return gender;}

  public void setGender(String gender) {this.gender = gender;}

  public House getHouse() {
    return house;
  }

  public void setHouse(House house) {
    this.house = house;
  }

  public Boolean isPrefect() {return prefect;}

  public void setPrefect(Boolean prefect) {this.prefect = prefect;}

  public Integer getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(Integer schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getFullName(){
    return firstName + " " + (middleName !=null ? middleName + " " : "") + lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getMiddleName(), student.getMiddleName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getHouse().getName(), student.getHouse().getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getHouse().getName());
  }
}
