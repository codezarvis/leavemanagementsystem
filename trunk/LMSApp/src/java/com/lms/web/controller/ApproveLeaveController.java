/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.Remarks;
import com.lms.domain.sub.StaffLeave;
import com.lms.domain.sub.Staff;
import com.lms.service.LeaveService;
import com.lms.service.StaffService;
import com.lms.service.RemarksService;
import com.lms.utils.ioc.AppContext;
import com.lms.utils.ioc.GsmWrite;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/approve")
public class ApproveLeaveController {

    private static Logger LOG = Logger.getLogger(ApproveLeaveController.class);
    @RequestMapping(method=RequestMethod.GET)
    public String approveLeave(String employeeId, WebRequest request) {

        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);
        StaffLeave staffLeave = leaveService.findByEmployeeId(employeeId);
        Staff staff = staffService.findByEmployeeId(employeeId);

        LOG.debug("Staff Object : "+staff);
        RemarksService remarksService = (RemarksService) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS_SERVICE);
        
        Remarks remarks = (Remarks) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS);
        remarks.setEmployeeId(staff.getEmployeeId());
        remarks.setRemarks("Leave Approved");
        remarks.setStatus("Approved");
        //remarks.setType(staffLeave.getType());

        
        
        LOG.debug("Employee Id : "+employeeId);

        remarksService.create(remarks);

        GsmWrite  gsmWrite = new GsmWrite();
        gsmWrite.write("91"+staff.getMobile(), "Your Leave is Approved !");
        
        return "Approval Completed !";
    }
}
