package my.edu.utem.ftmk.dad.StudentExaminationAttendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.AcademicStaff;

/**
 * This interface serves as a Spring Data JPA repository 
 * 	for the AcademicStaff entity.
 * 
 * It extends the JpaRepository interface, providing CRUD operations 
 * 	and other common database operations for AcademicStaff objects.
 * 
 * The repository is responsible for persisting 
 * 	and retrieving AcademicStaff data from the database.
 * 
 * 
 * @author atiqaidayu
 * 
 */
@Repository
public interface AcademicStaffRepository extends 
	JpaRepository<AcademicStaff, Long> {

}
