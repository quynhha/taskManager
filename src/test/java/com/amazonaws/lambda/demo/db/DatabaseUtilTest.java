package com.amazonaws.lambda.demo.db;

import org.junit.Assert;
import org.junit.Test;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */

public class DatabaseUtilTest {

    @Test
    public void testDatabaseUtil() {
        try {
			DatabaseUtil.connect();
			Assert.assertNotNull(DatabaseUtil.conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}