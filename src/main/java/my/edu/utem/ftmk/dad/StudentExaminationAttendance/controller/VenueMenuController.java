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

import my.edu.utem.ftmk.dad.StudentExaminationAttendance.model.Venue;

/**
 * Controller handling web requests 
 * related to Venue operations in the user interface.
 * 
 * @author irdinafarisya
 * 
 */
@Controller
public class VenueMenuController {

    // URI for Venue REST API endpoint
    private String defaultURI = 
    		"http://localhost:8080/exam_attendance_db/api/venue";

    /**
     * Retrieves a list of venues from the web service
     * and displays them in the "venue" view.
     *
     * @param model 
     * The Model object to pass data to the view.
     * 
     * @return The name of the view to render.
     * 
     */
    @GetMapping("/venue/list")
    public String getVenue(Model model) {

        // Get a list of venues from the web service
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Venue[]> response =
                restTemplate.getForEntity(defaultURI, Venue[].class);

        // Parse JSON data into an array of Venue objects
        Venue[] venues = response.getBody();

        List<Venue> venueList = Arrays.asList(venues);

        model.addAttribute("venue", venueList);

        return "venue";
    }

    /**
     * Saves a venue by either updating an existing venue or adding a new one.
     *
     * @param venue 
     * The Venue object to be saved or updated.
     * 
     * @return The name of the view to render.
     * 
     */
    @RequestMapping("/venue/save")
    public String updateVenue(@ModelAttribute Venue venue) {

        // Create a new RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create HTTP request body
        HttpEntity<Venue> request = new HttpEntity<>(venue);

        if (venue.getVenueId() > 0) {
            // Update an existing venue
            restTemplate.put(defaultURI, request, Venue.class);
        } else {
            // Add a new venue
            restTemplate.postForObject(defaultURI, request, String.class);
        }

        // Redirect request to display the list of venues
        return "redirect:/venue/list";
    }

    /**
     * Retrieves a venue to be updated or creates a new venue.
     *
     * @param venueId 
     * The unique identifier of the Venue to be retrieved or updated.
     * 
     * @param model   
     * The Model object to pass data to the view.
     * 
     * @return The name of the view to render.
     * 
     */
    @GetMapping("/venue/{venueId}")
    public String getVenue(@PathVariable Integer venueId, Model model) {

        String pageTitle = "New Venue";
        Venue venue = new Venue();

        // Get a venue to be updated, if venueId > 0
        if (venueId > 0) {
            // Generate new URI and append venueId to it
            String uri = defaultURI + "/" + venueId;

            // Get a venue from the web service
            RestTemplate restTemplate = new RestTemplate();
            venue = restTemplate.getForObject(uri, Venue.class);

            // Give a new title to the page
            pageTitle = "Edit Venue";
        }

        // Attach values to pass to the front end
        model.addAttribute("venue", venue);
        model.addAttribute("pageTitle", pageTitle);

        return "venueinfo";
    }

    /**
     * Deletes a venue with the specified venueId.
     *
     * @param venueId 
     * The unique identifier of the Venue to be deleted.
     * 
     * @return The name of the view to render.
     * 
     */
    @RequestMapping("/venue/delete/{venueId}")
    public String removeVenue(@PathVariable Integer venueId) {

        // Generate new URI, similar to the mapping in VenueRESTController
        String uri = defaultURI + "/{venueId}";

        // Send a DELETE request and attach the value of venueId into the URI
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, Map.of("venueId", Integer.toString(venueId)));

        return "redirect:/venue/list";
    }
}
