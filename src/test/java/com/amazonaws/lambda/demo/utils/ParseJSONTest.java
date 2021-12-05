package com.amazonaws.lambda.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class ParseJSONTest {

    @Test
    public void test() throws Exception {
        String json = "{"projectName": "Test"}";
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());
        ParseJSON parser = new ParseJSON();
        Assert.assertEquals(parser.jsonParser(inputStream).get("projectName"), "Test");
    }
}