package my.edu.utem.ftmk.dad.StudentExaminationAttendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class represents the Course entity in the database.
 * 
 * 
 * @author atiqaidayu
 * 
 */
@Entity
@Table(name = "course")
public class Course {

    // Primary key for the Course entity, auto-generated by the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseId")
    private int courseId;

    // Course code
    @Column(name = "CourseCode")
    private String code;

    // Course name
    @Column(name = "CourseName")
    private String name;

    // Many-to-one relationship with AcademicStaff entity 
    @ManyToOne
    @JoinColumn(name = "StaffId")
    private AcademicStaff lecturer;

    /**
     * Default constructor for the Course entity.
     * 
     */
    public Course() {
        // Initialize any necessary variables or perform other setup tasks
    }

    /**
     * Constructor with only courseId provided.
     * @param courseId The unique identifier for the course.
     * 
     */
    public Course(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Constructor with courseId, courseCode, and courseName provided.
     * 
     * @param courseId   
     * The unique identifier for the course.
     * 
     * @param code 
     * The code of the course.
     * 
     * @param name 
     * The name of the course.
     * 
     */
    public Course(int courseId, String code, String name) {
        this.courseId = courseId;
        this.code = code;
        this.name = name;
    }

    // Getter and Setter methods for class members.

    /**
     * Getter for the courseId.
     * @return The unique identifier for the course.
     * 
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Setter for the courseId.
     * @param courseId 
     * The unique identifier for the course.
     * 
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Getter for the courseCode.
     * @return The code of the course.
     * 
     */
    public String getCourseCode() {
        return code;
    }

    /**
     * Setter for the courseCode.
     * @param code 
     * The code of the course.
     * 
     */
    public void setCourseCode(String code) {
        this.code = code;
    }

    /**
     * Getter for the courseName.
     * @return The name of the course.
     * 
     */
    public String getCourseName() {
        return name;
    }

    /**
     * Setter for the courseName.
     * @param name 
     * The name of the course.
     * 
     */
    public void setCourseName(String name) {
        this.name = name;
    }

    /**
     * Getter for the associated AcademicStaff entity (Course lecturer).
     * @return The associated AcademicStaff entity (Course lecturer).
     * 
     */
    public AcademicStaff getLecturer() {
        return lecturer;
    }

    /**
     * Setter for the associated AcademicStaff entity (Course lecturer).
     * @param lecturer 
     * The AcademicStaff entity to associate with the course.
     * 
     */
    public void setLecturer(AcademicStaff lecturer) {
        this.lecturer = lecturer;
    }
}