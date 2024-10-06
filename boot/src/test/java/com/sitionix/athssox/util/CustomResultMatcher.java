package com.sitionix.athssox.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.web.servlet.ResultMatcher;

public class CustomResultMatcher {

    public static ResultMatcher jsonEqualIgnore(final String expectedJson, final String... fieldsForIgnore) {
        return result -> {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            final JsonNode expectedNode = objectMapper.readTree(expectedJson);
            final JsonNode actualNode = objectMapper.readTree(result.getResponse().getContentAsString());

            removeField(expectedNode, fieldsForIgnore);
            removeField(actualNode, fieldsForIgnore);

            final String actualJson = objectMapper.writeValueAsString(actualNode);
            JSONAssert.assertEquals(expectedJson, actualJson, false);
        };
    }

    private static void removeField(final JsonNode jsonNode, final String... fieldsForIgnore) {
        if (jsonNode.isObject()) {
            final ObjectNode objectNode = (ObjectNode) jsonNode;

            for (final String fieldForIgnore: fieldsForIgnore) {
                objectNode.remove(fieldForIgnore);
            }
            jsonNode.fields().forEachRemaining(entry -> removeField(entry.getValue(), fieldsForIgnore));
        } else {
            jsonNode.elements().forEachRemaining(element -> removeField(element, fieldsForIgnore));
        }
    }
}
