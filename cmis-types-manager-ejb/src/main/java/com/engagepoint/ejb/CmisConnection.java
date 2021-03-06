package com.engagepoint.ejb;

import com.engagepoint.exception.AppException;
import com.engagepoint.pojo.UserInfo;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.exceptions.CmisBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.util.List;
import java.util.Map;

/**
 * User: AlexDenisenko
 * Date: 29.11.13
 * Time: 11:37
 */
@Singleton
@LocalBean
public class CmisConnection {
    private static final Logger LOGGER = LoggerFactory.getLogger(CmisConnection.class);
    private SessionFactory sessionFactory = SessionFactoryImpl.newInstance();

    public Session getSession(UserInfo userInfo) throws AppException {
        Map<String, String> parameters = userInfo.getAtomPubParameters();
        Session session;
        try {
            session = sessionFactory.createSession(parameters);
        } catch (CmisBaseException e) {
            LOGGER.error(e.getMessage(), e);
            throw new AppException(e.getMessage());
        }
        return session;
    }

    public List<Repository> getRepositories(UserInfo userInfo) throws AppException {
        Map<String, String> parameters = userInfo.getAtomPubParameters();
        List<Repository> repositoryList;
        try {
            repositoryList = sessionFactory.getRepositories(parameters);
        } catch (CmisBaseException e) {
            LOGGER.error(e.getMessage(), e);
            throw new AppException(e.getMessage());
        }
        return repositoryList;
    }

    @Deprecated
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
