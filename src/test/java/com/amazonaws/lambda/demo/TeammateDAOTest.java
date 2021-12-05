package com.amazonaws.lambda.demo;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.TeammateDAO;

public class TeammateDAOTest {

    @Test
    public void test() throws Exception {
        //Test Connection 
        TeammateDAO dao = new TeammateDAO();
        Assert.assertFalse(dao.conn.isClosed());

        //Test Search
        Assert.assertNotEquals(dao.addTeammateToProject("Akim", "Test"), 0);

        //Test Search For Team-mate
        Assert.assertNotEquals(dao.searchForTeammate("Akim", "Test"), 0);

        //Test Delete Team-mate
        Assert.assertTrue(dao.deleteTeammateFromProject("Akim", "Test"));
    }
}