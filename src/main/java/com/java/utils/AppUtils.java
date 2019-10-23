package com.java.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class AppUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //convert object to string
    public static String getJsonStr(Object o) {
        try {
            String jsonStr = MAPPER.writeValueAsString(o);
            return jsonStr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //convert string Json to object
    public static <T> T getObjectFromJson(String json, Class<T> classType) {
        try {
            T obj = MAPPER.readValue(json, classType);
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getObjectFromRequest(HttpServletRequest request, Class<T> classType) {
        try (InputStream is = request.getInputStream()) {
            String inputData = IOUtils.toString(is, "UTF-8");
            T obj = getObjectFromJson(inputData, classType);
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeResponseAsJson(HttpServletResponse response, int statusCode, Object responseData) {
        if (statusCode == 0) {
            response.setStatus(200);
        } else {
            response.setStatus(statusCode);
        }
        response.setContentType("json");

        String jsonResponse = getJsonStr(responseData);
        PrintWriter w = null;
        try {
            w = response.getWriter();
            w.write(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (w!=null)
            {
                w.close();
            }
        }
    }
}
