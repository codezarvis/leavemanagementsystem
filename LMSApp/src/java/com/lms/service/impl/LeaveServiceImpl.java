/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service.impl;

import com.lms.domain.sub.Leave;
import com.lms.service.LeaveService;
import com.lms.utils.hibernate.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class LeaveServiceImpl extends ServiceImpl implements LeaveService {

    private static Logger LOG = Logger.getLogger(LeaveServiceImpl.class);
    private static LeaveServiceImpl leaveServiceImpl = new LeaveServiceImpl();

    private LeaveServiceImpl() {
    }

    public static LeaveService getInstance() {
        return leaveServiceImpl;
    }

    public void create(Leave leave) {
        LOG.debug(leave);

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(leave);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("LeaveServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }
}
