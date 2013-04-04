/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.Leave;
import com.lms.domain.sub.Staff;
import com.lms.service.LeaveService;
import com.lms.service.StaffService;
import com.lms.utils.ioc.AppContext;
import com.lms.web.forms.LeaveForm;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/leave")
public class ApplyLeaveController {

    private static Logger LOG = Logger.getLogger(ApplyLeaveController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showLeaveForm(@ModelAttribute LeaveForm leaveForm, WebRequest request) {

        return "/leave";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String applyLeave(@ModelAttribute LeaveForm leaveForm) {

        String response = null;

        final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        int diffInDays = 0;
        try {

            LOG.debug(leaveForm.getFromDate());
            Date fromDate = simpleDateFormat.parse(leaveForm.getFromDate());
            Date toDate = simpleDateFormat.parse(leaveForm.getToDate());
            diffInDays = (int) ((fromDate.getTime() - toDate.getTime()) / DAY_IN_MILLIS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);

        Staff staff = staffService.findByEmployeeId(leaveForm.getEmployeeId());

        if (staff.getGender().equalsIgnoreCase("F")) {
            // TO DO
        } else {

            if (diffInDays > 2) {
                response = "You Must Apply Only Two Days of Leave in Current Month !";
                return response;
            }
        }

        LOG.debug("Number of Days Applied for Leaves : " + diffInDays);
        LOG.debug(leaveForm);
        //Leave leave = (Leave) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE);
        Leave leave = new Leave();
        leave.setEmployeeId(leaveForm.getEmployeeId());
        leave.setFromDate(leave.getFromDate());
        leave.setToDate(leaveForm.getToDate());
        leave.setLeaveType(leaveForm.getLeaveType());
        leave.setReasonsForLeave(leaveForm.getReasonsforLeave());
        leave.setAddress(leaveForm.getContactAddress());
        leave.setMobile(leaveForm.getMobile());
        leave.setLeaveCount(String.valueOf(diffInDays));

        LOG.debug("Leave in Controller : "+leave);

        leaveService.create(leave);
        response = "Leave Application is sent to Admin !";
        return response;
    }
}
