package my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Attendance;

/**
 * This interface serves as a Spring Data JPA repository 
 * 	for the Attendance entity.
 * 
 * It extends the JpaRepository interface, providing CRUD operations 
 * 	and other common database operations for AcademicStaff objects.
 * 
 * The repository is responsible for persisting 
 * 	and retrieving Attendance data from the database.
 * 
 * 
 * @author atiqaidayu
 * 
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
