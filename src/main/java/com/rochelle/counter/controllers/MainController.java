package com.rochelle.counter.controllers;
//? Pair Programming -> Dominic Basa

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    //? Increment the counter on each visit to http://your_server/
    @RequestMapping("/")
    public String index(HttpSession session) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		    // Use setAttribute to initialize the count in session
            session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
            int currentCount = (Integer) session.getAttribute("count") + 1;
            session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}

    //? Show what the count is after it has been increased by 1
    @RequestMapping("/counter")
    public String counter(HttpSession session) {
        // If the count is not already in session
		if (session.getAttribute("count") == null) {
            // Use setAttribute to initialize the count in session
            session.setAttribute("count", 0);
        } else {
            int currentCount = (Integer) session.getAttribute("count");
            session.setAttribute("count", currentCount);
        }
        return "displayCount.jsp";
    }

    //? Increment the counter by 2
    @RequestMapping("/counterBy2")
    public String counterBy2(HttpSession session) {
        // If the count is not already in session
		if (session.getAttribute("count") == null) {
            // Use setAttribute to initialize the count in session
            session.setAttribute("count", 0);
        } else {
            int currentCount = (Integer) session.getAttribute("count") + 2;
            session.setAttribute("count", currentCount);
        }
        return "displayCountUpBy2.jsp";
    }

    //? Reset the counter back to 0
    @RequestMapping("/reset")
    public String reset(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

