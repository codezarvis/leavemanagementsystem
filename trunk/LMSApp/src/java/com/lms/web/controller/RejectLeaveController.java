/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/reject")
public class RejectLeaveController {

    private static Logger LOG = Logger.getLogger(RejectLeaveController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String rejectLeave(String employeeId, String from, String to, WebRequest request) {

        LOG.debug("In Reject Controller================");
        LOG.debug("FROM : " + from + "TO : " + to);
        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);
        List<StaffLeave> staffLeaveList = leaveService.findEmployees(employeeId);
        Staff staff = staffService.findByEmployeeId(employeeId);

        LOG.debug("Staff Leave Object : " + staffLeaveList);
        //LOG.debug("Staff Object : "+staff);
        RemarksService remarksService = (RemarksService) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS_SERVICE);


        for (StaffLeave sl : staffLeaveList) {
            if (sl.getEmployeeId().equals(employeeId) && sl.getLeaveStart().equals(from) && sl.getLeaveEnd().equals(to)) {
                Remarks remarks = (Remarks) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS);
                remarks.setEmployeeId(staff.getEmployeeId());
                remarks.setRemarks("Leave Rejected");
                remarks.setStatus("Rejected");
                remarksService.create(remarks);
                sl.setId(sl.getId());
                sl.setActive(2);

                leaveService.create(sl);
            }
        }

        staffLeaveList = leaveService.getAll();
        Map<String, String> map = new HashMap<String, String>();

        for (StaffLeave staffLeave : staffLeaveList) {
            map.put(staffLeave.getEmployeeId(), staffService.findByEmployeeId(staffLeave.getEmployeeId()).getFullName());
        }
        request.setAttribute("staffLeaveList", staffLeaveList, WebRequest.SCOPE_SESSION);
        request.setAttribute("map", map, WebRequest.SCOPE_SESSION);

        GsmWrite gsmWrite = new GsmWrite();
        try {
            gsmWrite.doIt(staff.getMobile(), "Your Leave is Rejected ");
        } catch (Exception exception) {
            LOG.debug(exception);
        }

        request.setAttribute("msg", "Process Completed !", WebRequest.SCOPE_REQUEST);
        return "/leaveView";
    }
}
