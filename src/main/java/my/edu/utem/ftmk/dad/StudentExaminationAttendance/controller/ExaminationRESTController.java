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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Examination;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.repository.ExaminationRepository;

/**
 * REST Controller handling the Examination entity.
 * 
 * This class provides API endpoints 
 * to perform CRUD operations on the Examination entity.
 * 
 * @author irdinafarisya
 */
@RestController
@RequestMapping("/api/examination")
public class ExaminationRESTController {

    @Autowired
    private ExaminationRepository examRepository;

    /**
     * Creates a new record in the Examination table.
     *
     * @param exam 
     * The Examination entity to be added.
     * 
     * @return The created Examination entity.
     * 
     */
    @PostMapping()
    public Examination addExam(@RequestBody Examination exam) {
        return examRepository.save(exam);
    }

    /**
     * Remove a record from the Examination table 
     * 	based on the provided examination ID.
     *
     * @param examId 
     * The ID of the Examination to be removed.
     * 
     * @return ResponseEntity with HttpStatus.OK if the operation is successful
     * 
     */
    @DeleteMapping("{examId}")
    public ResponseEntity<HttpStatus> removeExam(@PathVariable long examId) {
        examRepository.deleteById(examId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieves a record from the Examination table 
     * 	based on the provided examination ID.
     *
     * @param examId 
     * 	The ID of the Examination to retrieve.
     * 
     * @return The Examination entity with the provided ID.
     * 
     */
    @GetMapping("{examId}")
    public Examination viewExamDetails(@PathVariable long examId) {
        Examination exam = examRepository.findById(examId).get();
        return exam;
    }

    /**
     * Retrieves all records from the Examination table.
     *
     * @return A list of all Examination entities in the database.
     * 
     */
    @GetMapping
    public List<Examination> getExamination() {
        return examRepository.findAll();
    }

    /**
     * Updates a record in the Examination table.
     *
     * @param exam 
     * The updated Examination entity.
     * 
     * @return The updated Examination entity.
     * 
     */
    @PutMapping()
    public Examination updateExam(@RequestBody Examination exam) {
        return examRepository.save(exam);
    }
}
