package my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Venue;

/**
 * This interface serves as a Spring Data JPA repository 
 * 	for the Venue entity.
 * 
 * It extends the JpaRepository interface, providing CRUD operations 
 * 	and other common database operations for AcademicStaff objects.
 * 
 * The repository is responsible for persisting 
 * 	and retrieving Venue data from the database.
 * 
 * 
 * @author atiqaidayu
 */
@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

}
