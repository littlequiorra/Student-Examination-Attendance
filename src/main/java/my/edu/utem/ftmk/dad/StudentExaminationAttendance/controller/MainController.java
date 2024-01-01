package my.edu.utem.ftmk.dad.StudentExaminationAttendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller handling the main page of the application.
 * This class is responsible for routing the user to the main view.
 * 
 * @author atiqaidayu
 * 
 */
@Controller
public class MainController {

    /**
     * Retrieves the main view of the application.
     * This method maps the "/main" URL path to the "main" view template.
     *
     * @return The name of the view template to be displayed.
     * 
     */
    @GetMapping("/main")
    public String getMain() {
        return "main";
    }
}
