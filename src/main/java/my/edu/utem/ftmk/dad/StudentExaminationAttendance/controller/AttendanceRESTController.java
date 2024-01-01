package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Attendance;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance
		.repository.AttendanceRepository;

/**
 * REST controller handling Attendance entity operations.
 * 
 * This class provides endpoints to retrieve 
 * 	and create Attendance entities via HTTP requests.
 * 
 * @author atiqaidayu
 * 
 */
@RestController
@RequestMapping("/api/attendance")
public class AttendanceRESTController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	/**
	 * Retrieve a list of all Attendance records from the database.
	 * 
	 * @return A list of all Attendance entities.
	 * 
	 */
	@GetMapping
	public List<Attendance> getAttendanceList()	{	
    	return attendanceRepository.findAll();
	}
	
	/**
	 * Create a new Attendance record in the database.
	 * 
	 * @param attendance
	 *  The Attendance entity to be added.
	 *  
	 * @return The newly created Attendance entity.
	 * 
	 */
	@PostMapping
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		return attendanceRepository.save(attendance);
	}
}
