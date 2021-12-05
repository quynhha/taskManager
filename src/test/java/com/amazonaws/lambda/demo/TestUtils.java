package com.amazonaws.lambda.demo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.utils.ParseJSON;

public class TestUtils {

    @Test
    public void test() throws Exception {
        String json = "{"projectName": "Test"}";
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());
        ParseJSON parser = new ParseJSON();
        Assert.assertEquals(parser.jsonParser(inputStream).get("projectName"), "Test");
    }
}