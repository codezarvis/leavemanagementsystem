/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;

import com.lms.domain.sub.Leave;

/**
 *
 * @author Sudarsan
 */
public interface LeaveService extends Service {

    void create(Leave leave);
}
