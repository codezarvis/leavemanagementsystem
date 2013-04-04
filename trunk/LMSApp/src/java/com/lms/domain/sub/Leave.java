/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.domain.sub;

import com.lms.domain.Domain;
import java.util.UUID;

/**
 *
 * @author Sudarsan
 */
public class Leave extends Domain implements java.io.Serializable{

    private String employeeId;
    private String fromDate;
    private String toDate;
    private String leaveType;
    private String reasonsForLeave;
    private String address;
    private String mobile;
    private String leaveCount;

    public Leave() {
        setGuid(UUID.randomUUID().toString());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(String leaveCount) {
        this.leaveCount = leaveCount;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getReasonsForLeave() {
        return reasonsForLeave;
    }

    public void setReasonsForLeave(String reasonsForLeave) {
        this.reasonsForLeave = reasonsForLeave;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder();
        toStringBuilder.append(super.toString());
        toStringBuilder.append("\n");
        toStringBuilder.append("\nemployeeId: ");
        toStringBuilder.append(employeeId);
        toStringBuilder.append("\nfromDate: ");
        toStringBuilder.append(fromDate);
        toStringBuilder.append("\ntoDate: ");
        toStringBuilder.append(toDate);
        toStringBuilder.append("\nleaveType: ");
        toStringBuilder.append(leaveType);
        toStringBuilder.append("\nreasonsForLeave: ");
        toStringBuilder.append(reasonsForLeave);
        toStringBuilder.append("\naddress: ");
        toStringBuilder.append(address);
        toStringBuilder.append("\nmobile: ");
        toStringBuilder.append(mobile);
        toStringBuilder.append("\nleaveCount: ");
        toStringBuilder.append(leaveCount);
        return toStringBuilder.toString();
    }
    

    
   



}
