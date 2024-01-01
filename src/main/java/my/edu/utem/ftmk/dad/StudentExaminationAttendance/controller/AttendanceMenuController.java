package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Examination;
import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Attendance;

/**
 * Controller handling the web UI for Attendance entity.
 * This class provides methods to display
 *  and interact with the web pages related to Attendance data.
 *  
 * @author atiqaidayu
 * 
 */
@Controller
public class AttendanceMenuController {

    private String defaultURI 
    	= "http://localhost:8080/exam_attendance_db/api/attendance";

    /**
     * Display the list of Attendance entities on the web page.
     *
     * @param model 
     * The model to be used for rendering the view.
     * 
     * @return The name of the view template for displaying the Attendance list.
     * 
     */
    @GetMapping("/attendance/list")
    public String getAttendance(Model model) {

        // Get a list of attendances from the web service
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Attendance[]> response 
        	= restTemplate.getForEntity(defaultURI, Attendance[].class);

        //Parse JSON data to an array of objects
        Attendance attendance[] = response.getBody();

        List<Attendance> attendanceList = Arrays.asList(attendance);

        model.addAttribute("attendance", attendanceList);

        // Return the name of the view template for displaying Attendance list
        return "attendance";
    }

    /**
     * This method will update or add an Attendance entity.
     *
     * @param attendance 
     * 	The Attendance entity to be updated or added.
     * 
     * @return The URL to redirect to display the list of Attendance entities.
     * 
     */
    @RequestMapping("/attendance/save")
    public String updateAttendance(@ModelAttribute Attendance attendance) {

        // Create a new RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create request body
        HttpEntity<Attendance> request = new HttpEntity<>(attendance);

        String attendanceResponse = "";

        if (attendance.getAttendId() > 0) {
            // This block updates an existing Attendance entity
            // Send request as PUT
            restTemplate.put(defaultURI, request, Attendance.class);
        } else {
            // This block adds a new Attendance entity
            // Send request as POST
            attendanceResponse 
            	= restTemplate.postForObject(defaultURI, request, String.class);
        }

        System.out.println(attendanceResponse);

        // Redirect request to display the list of Attendance entities
        return "redirect:/attendance/list";
    }

    /**
     * This method retrieves an Attendance entity to be updated 
     * 	or displayed for editing.
     *
     * @param attendId 
     * The ID of the Attendance entity to retrieve.
     * 
     * @param model   
     *  The model to be used for rendering the view.
     *  
     * @return The name of the view template 
     * 	for displaying the Attendance details/edit form.
     * 
     */
    @GetMapping("/attendance/{attendId}")
    public String getAttendance(@PathVariable Integer attendId, Model model) {

        String pageTitle = "Attendance Details";
        Attendance attendance = new Attendance();

        // This block gets the Attendance entity to be updated
        if (attendId > 0) {
            // Generate new URI and append attendId to it
            String uri = defaultURI + "/" + attendId;

            // Get the Attendance entity from the web service
            RestTemplate restTemplate = new RestTemplate();
            attendance = restTemplate.getForObject(uri, Attendance.class);

            // Give a new title to the page
            pageTitle = "Edit Attendance Details";
        }
        	    // Get a list attendance from the webs
     			RestTemplate restTemplate = new RestTemplate();
     			ResponseEntity<Examination[]> response= 
     				restTemplate.getForEntity(
     				"http://localhost:8080/exam_attendance_db/api/examination",
     				Examination[].class);

        model.addAttribute("attendance", attendance);
        model.addAttribute("pageTitle", pageTitle);

        // Return the view template name displaying Attendance details/edit form
        return "attendanceinfo";
    }

    /**
     * This method removes an Attendance entity based on the provided attendId.
     *
     * @param attendId 
     * The ID of the Attendance entity to be removed.
     * 
     * @return The URL to redirect to display the list of Attendance entities.
     * 
     */
    @RequestMapping("/attendance/delete/{attendId}")
    public String removeAttendance(@PathVariable Integer attendId) {

        // Generate new URI, similar to the mapping in AttendanceRESTController
        String uri = defaultURI + "/{attendId}";

        // Send a DELETE request and attach the value or attendId into URI
        RestTemplate restTemplate = new RestTemplate();
        restTemplate
        	.delete(uri, Map.of("attendId", Integer.toString(attendId)));

        // Redirect request to display the list of Attendance entities
        return "redirect:/attendance/list";
    }
}
