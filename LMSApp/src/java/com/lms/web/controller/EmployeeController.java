/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/employeeHome")
public class EmployeeController {

    @RequestMapping(method= RequestMethod.GET)
    public String showEmployeeHome(WebRequest request) {
        return "/employeeHome";
    }

}
