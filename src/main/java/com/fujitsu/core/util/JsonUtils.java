package com.fujitsu.core.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fujitsu.core.constants.FrameworkConstants;
import com.fujitsu.core.enums.ConfigProperties;

/**
 * To construct the map by the reading the config values from JSON. Not used in this framework but can be leveraged
 * instead of property file based on the requirements
 *
 * @author Sumit Goyal
 * @version 1.0
 * @see PropertyUtils
 * @since 1.0
 */
public class JsonUtils {

    private static Map<String, String> CONFIGMAP;

    static {
        try {
            CONFIGMAP = new ObjectMapper ().readValue (new File (FrameworkConstants.JSONCONFIGFILEPATH),
                new TypeReference<HashMap<String, String>> () {
                });

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static String get (ConfigProperties key) throws Exception {
        if (Objects.isNull (key) || Objects.isNull (CONFIGMAP.get (key.name ()
            .toLowerCase ()))) {
            throw new Exception ("Property name " + key + " is not found. Please check config.properties");
        }
        return CONFIGMAP.get (key.name ()
            .toLowerCase ());
    }

    /**
     * Private constructor to avoid external instantiation
     */
    private JsonUtils () {

    }

}
