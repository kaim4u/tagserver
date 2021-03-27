package org.deneb.poc.server.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home(Model model) {

        return "index";
    }
	
	@GetMapping(value = "/facebook", produces = MediaType.TEXT_HTML_VALUE)
    public String facebook(Model model) {
        
        return "facebook";
    }
	
	@GetMapping(value = "/amazon", produces = MediaType.TEXT_HTML_VALUE)
    public String amazon(Model model) {
        
        return "amazon";
    }
}
