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

/**
 * Controller handling the web UI for Examination entity.
 * 
 * This class provides methods to display 
 * 	and interact with the web pages related to Examination data.
 * 
 * @author irdinafarisya
 */
@Controller
public class ExaminationMenuController {

    private String defaultURI = 
    		"http://localhost:8080/exam_attendance_db/api/examination";

    /**
     * Display the list of Examination entities on the web page.
     *
     * @param model
     *  The model to be used for rendering the view.
     * @return The name of the view template for displaying the Examination list
     * 
     */
    @GetMapping("/examination/list")
    public String getExamination(Model model) {

        // Get a list of examinations from the web service
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Examination[]> response 
        	= restTemplate.getForEntity(defaultURI, Examination[].class);

        //Parse JSON data to an array of objects
        Examination examination[] = response.getBody();

        List<Examination> examinationList = Arrays.asList(examination);

        model.addAttribute("examination", examinationList);

        // Return the name of the view template displaying the Examination list
        return "examination";
    }

    /**
     * This method will update or add an Examination entity.
     *
     * @param examination 
     * The Examination entity to be updated or added.
     * 
     * @return The URL to redirect to display the list of Examination entities.
     * 
     */
    @RequestMapping("/examination/save")
    public String updateExamination(@ModelAttribute Examination examination) {

        // Create a new RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create request body
        HttpEntity<Examination> request 
        	= new HttpEntity<Examination>(examination);

        String examinationResponse = "";

        if (examination.getExamId() > 0) {
            // This block updates an existing Examination entity
            // Send request as PUT
            restTemplate.put(defaultURI, request, Examination.class);
        } else {
            // This block adds a new Examination entity
            // Send request as POST
            examinationResponse 
            	= restTemplate.postForObject(defaultURI, request, String.class);
        }

        System.out.println(examinationResponse);

        // Redirect request to display the list of Examination entities
        return "redirect:/examination/list";
    }

    /**
     * This method retrieves an Examination entity to be updated
     *  or displayed for editing.
     *
     * @param examId 
     * 	The ID of the Examination entity to retrieve.
     * 
     * @param model  
     * 	The model to be used for rendering the view.
     * 
     * @return The name of the view template 
     * 	for displaying the Examination details/edit form.
     * 
     */
    @GetMapping("/examination/{examId}")
    public String getExamination(@PathVariable Integer examId, Model model) {

        String pageTitle = "New Examination";
        Examination examination = new Examination();

        // This block gets the Examination entity to be updated
        if (examId > 0) {
            // Generate new URI and append examId to it
            String uri = defaultURI + "/" + examId;

            // Get the Examination entity from the web service
            RestTemplate restTemplate = new RestTemplate();
            examination = restTemplate.getForObject(uri, Examination.class);

            // Give a new title to the page
            pageTitle = "Edit Examination";
        }

        // Attach values to pass to the front end
        model.addAttribute("examination", examination);
        model.addAttribute("pageTitle", pageTitle);

       // Return view template name displaying the Examination details/edit form
        return "examinationinfo";
    }

    /**
     * This method removes an Examination entity based on the provided examId.
     *
     * @param examId 
     * The ID of the Examination entity to be removed.
     * 
     * @return The URL to redirect to display the list of Examination entities.
     * 
     */
    @RequestMapping("/examination/delete/{examId}")
    public String removeExam(@PathVariable Integer examId) {

        // Generate new URI, similar to the mapping in ExaminationRESTController
        String uri = defaultURI + "/{examId}";

        // Send a DELETE request and attach the value or examId into URI
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, Map.of("examId", Integer.toString(examId)));

        // Redirect request to display the list of Examination entities
        return "redirect:/examination/list";
    }
}
