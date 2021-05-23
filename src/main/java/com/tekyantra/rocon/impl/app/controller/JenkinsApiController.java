package com.tekyantra.rocon.impl.app.controller;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/rocon")
public class JenkinsApiController {

    @GetMapping("/build")
    public String buildJob() {
        try {
            JenkinsServer jenkins = new JenkinsServer(
                    new URI("http://localhost:8081"),
                    "admin", "111f1aa1170cd9cb582d26cd818d2f87d3");
            Map<String, Job> jobs = jenkins.getJobs();
            JobWithDetails job = jobs.get("build-rocon-services-impl").details();
            job.build();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "Success";
    }


}

