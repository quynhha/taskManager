package com.amazonaws.lambda.demo.utils;

import org.junit.Assert;
import org.junit.Test;

public class JSONUtilsTest {
    @Test
    public void test() {
        JSONUtils utils = new JSONUtils();
        Assert.assertNotNull(utils.getResponseJson());
    }
}