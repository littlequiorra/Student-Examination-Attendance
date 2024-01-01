package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Student;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.repository.StudentRepository;

/**
 * REST Controller handling REST API endpoints for Student operations.
 * 
 * Provides endpoints for performing CRUD 
 * (Create, Read, Update, Delete) operations on Student records.
 * 
 * @author atiqaidayu
 */
@RestController
@RequestMapping("/api/student")
public class StudentRESTController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Creates a new record in the Student table.
     *
     * @param student 
     * The Student object to be added to the database.
     * 
     * @return The newly created Student object.
     * 
     */
    @PostMapping()
    public Student addStudentDetails(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    /**
     * Deletes a record from the Student table based on the provided student ID.
     *
     * @param stdId 
     * The student ID to identify the record to be deleted.
     * 
     * @return HTTP status indicating the success or failure of the operation.
     */
    @DeleteMapping("{stdId}")
    public ResponseEntity<HttpStatus> 
    	deleteStudentDetails(@PathVariable String stdId) {
        	studentRepository.deleteById(stdId);
        	return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieves all records from the Student table.
     *
     * @return A list of Student objects 
     * representing all records in the database.
     * 
     */
    @GetMapping
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    /**
     * Updates an existing record in the Student table.
     *
     * @param student 
     * The Student object containing updated information.
     * 
     * @return The updated Student object
     *  after the changes are saved to the database.
     */
    @PutMapping()
    public Student updateStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
