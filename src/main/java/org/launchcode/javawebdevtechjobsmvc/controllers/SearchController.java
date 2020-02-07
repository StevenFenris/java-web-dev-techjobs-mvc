package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }
//    @RequestMapping(value = "")
//    public String searchSplash(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
//        ArrayList<Job> jobs = JobData.findAll();
//        model.addAttribute("title", "All Jobs");
//        model.addAttribute("jobs", jobs);
//        return "list-jobs";
//    }


    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @RequestMapping(value = "/results")
    public String searchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        ArrayList<Job> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + ": " + searchTerm);
        model.addAttribute("jobs", jobs);

        return "list-jobs";
    }

}
