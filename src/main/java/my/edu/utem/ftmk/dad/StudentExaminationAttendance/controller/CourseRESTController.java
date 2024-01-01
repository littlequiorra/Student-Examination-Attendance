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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Course;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.repository.CourseRepository;

/**
 * REST controller handling Course entity operations.
 * This class provides endpoints
 *  to perform CRUD operations on Course entities via HTTP requests.
 *  
 * @author atiqaidayu
 * 
 */
@RestController
@RequestMapping("/api/course")
public class CourseRESTController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	/**
	 * Endpoint to create a new record in the Course table.
	 *
	 * @param course 
	 * The Course entity to be added.
	 * 
	 * @return The saved Course entity with the generated ID.
	 * 
	 */
	@PostMapping()
	public Course addCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	/**
	 * Endpoint to delete a record from the Course table based on the courseId
	 *
	 * @param courseId 
	 * The ID of the Course entity to be removed.
	 * 
	 * @return HTTP status OK if successful.
	 * 
	 */
	@DeleteMapping("{courseId}")
	public ResponseEntity<HttpStatus> 
		removeCourse(@PathVariable long courseId)	{
			courseRepository.deleteById(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Endpoint to retrieve a record from the Course table based on the courseId
	 *
	 * @param courseId 
	 * The ID of the Course entity to be retrieved.
	 * 
	 * @return The Course entity with the specified courseId.
	 * 
	 */
	@GetMapping("{courseId}")
	public Course viewCourseDetails(@PathVariable long courseId) {	
		Course course = courseRepository.findById(courseId).get();
		return course;
	}
	
	/**
	 * Endpoint to update a record in the Course table.
	 *
	 * @param course 
	 * The Course entity with updated data.
	 * 
	 * @return The updated Course entity.
	 */
	@PutMapping()
	public Course updateCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
    
	/**
	 * Endpoint to get all records from the Course table.
	 *
	 * @return A list of all Course entities.
	 * 
	 */
	@GetMapping
	public List<Course> getAllCourses() {
	    return courseRepository.findAll();
	}

}
