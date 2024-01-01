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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Venue;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.repository.VenueRepository;

/**
 * REST Controller for handling HTTP requests related to Venue entities.
 * 
 * Provides endpoints for performing CRUD 
 * (Create, Read, Update, Delete) operations on Venue records.
 * 
 * @author irdinafarisya
 * 
 */
@RestController
@RequestMapping("/api/venue")
public class VenueRESTController {

    @Autowired
    private VenueRepository venueRepository;

    /**
     * Creates a new record in the table Venue.
     * 
     * @param venue 
     * The Venue object to be added to the database.
     * 
     * @return The Venue object after it's been saved to the database.
     * 
     */
    @PostMapping()
    public Venue addVenue(@RequestBody Venue venue) {
        return venueRepository.save(venue);
    }

    /**
     * Deletes a record from the table Venue based on the venueId provided.
     * 
     * @param venueId 
     * The unique identifier of the Venue to be deleted.
     * 
     * @return HTTP response status indicating the success of the deletion.
     * 
     */
    @DeleteMapping("{venueId}")
    public ResponseEntity<HttpStatus> removeVenue(@PathVariable long venueId) {
        venueRepository.deleteById(venueId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieves a record from the table Venue based on the venueId provided.
     * @param venueId 
     * The unique identifier of the Venue to be retrieved.
     * 
     * @return The Venue object corresponding to the given venueId.
     * 
     */
    @GetMapping("{venueId}")
    public Venue viewStudentDetails(@PathVariable long venueId) {
        Venue venue = venueRepository.findById(venueId).get();
        return venue;
    }

    /**
     * Retrieves all records from the table Venue.
     * @return A list containing all Venue objects present in the database.
     * 
     */
    @GetMapping
    public List<Venue> getVenueList() {
        return venueRepository.findAll();
    }

    /**
     * Updates a record in the table Venue.
     * @param venue 
     * The updated Venue object to be saved to the database.
     * 
     * @return The updated Venue object after it's been saved to the database.
     */
    @PutMapping()
    public Venue updateVenue(@RequestBody Venue venue) {
        return venueRepository.save(venue);
    }
}
