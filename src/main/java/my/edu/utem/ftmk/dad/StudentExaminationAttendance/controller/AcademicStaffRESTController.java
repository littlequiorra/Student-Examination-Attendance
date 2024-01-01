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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.model.AcademicStaff;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.repository.AcademicStaffRepository;

/**
 * Controller handling the REST API for AcademicStaff entity.
 * 
 * This class provides methods to perform CRUD operations 
 * 	for AcademicStaff data via REST endpoints.
 * 
 * @author atiqaidayu
 * 
 */
@RestController
@RequestMapping("/api/academicstaff")
public class AcademicStaffRESTController {

    @Autowired
    private AcademicStaffRepository academicStaffRepository;

    /**
     * Add a new record to the AcademicStaff table.
     *
     * @param academicStaff
     *  The AcademicStaff object to be added.
     *  
     * @return The AcademicStaff object that has been added to the table.
     * 
     */
    @PostMapping()
    public AcademicStaff 
    	addStaffDetails(@RequestBody AcademicStaff academicStaff) {
        	return academicStaffRepository.save(academicStaff);
    }

    /**
     * Delete a record from the AcademicStaff table
     *  based on the provided staffId.
     *
     * @param staffId The ID of the AcademicStaff record to be deleted.
     * 
     * @return An HTTP response entity 
     * 	representing the status of the deletion operation.
     * 
     */
    @DeleteMapping("{staffId}")
    public ResponseEntity<HttpStatus> 
    	deleteStaffDetails(@PathVariable long staffId) {
        	academicStaffRepository.deleteById(staffId);
        	return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieve a record from the AcademicStaff table 
     * 	based on the provided staffId.
     *
     * @param staffId 
     * The ID of the AcademicStaff record to be retrieved.
     * 
     * @return The AcademicStaff object corresponding to the provided staffId.
     * 
     */
    @GetMapping("{staffId}")
    public AcademicStaff viewStaffDetails(@PathVariable long staffId) {
        AcademicStaff academicStaff
        	= academicStaffRepository.findById(staffId).get();
        return academicStaff;
    }

    /**
     * Retrieve all records from the AcademicStaff table.
     *
     * @return A list of all AcademicStaff objects in the table.
     * 
     */
    @GetMapping
    public List<AcademicStaff> getStaffList() {
        return academicStaffRepository.findAll();
    }

    /**
     * Update a record in the AcademicStaff table.
     *
     * @param academicStaff 
     * The AcademicStaff object to be updated.
     * 
     * @return The AcademicStaff object that has been updated in the table.
     * 
     */
    @PutMapping()
    public AcademicStaff 
    	updateAcademicStaff(@RequestBody AcademicStaff academicStaff) {
        	return academicStaffRepository.save(academicStaff);
    }
}
