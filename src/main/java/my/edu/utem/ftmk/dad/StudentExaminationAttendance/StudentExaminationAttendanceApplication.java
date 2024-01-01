package my.edu.utem.ftmk.dad.StudentExaminationAttendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class serves as the entry point of 
 * 	Student Examination Attendance application
 * 
 * It uses the SpringBootApplication annotation, 
 * 	which combines three annotations: 
 * 	@Configuration, @EnableAutoConfiguration, and @ComponentScan.
 * 
 * 
 * The main method is the starting point of the application. 
 * 
 * It uses SpringApplication.run() to bootstrap 
 * 	and launch the Spring Boot application.
 * 
 * @author atiqaidayu
 */
@SpringBootApplication
public class StudentExaminationAttendanceApplication {

    public static void main(String[] args) {
        SpringApplication
        	.run(StudentExaminationAttendanceApplication.class, args);
    }

}
