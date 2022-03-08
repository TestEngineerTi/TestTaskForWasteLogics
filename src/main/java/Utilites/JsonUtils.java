package Utilites;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.fasterxml.jackson.module.mrbean.MrBeanModule;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static java.lang.String.format;

public class JsonUtils {
    private static final ObjectMapper MAPPER;

    //  Error message patterns
    private static final String CONFIG_READ_ERROR = "Unable to read configuration '%s'. \n Error details: %s";
    private static final String JSON_READ_ERROR = "Unable to read JSON file: '%s'. \n Error details: %s";
    private static final String OBJECT_WRITE_ERROR = "Unable to write JSON file for object: '%s'. \n Error details: %s";
    private static final String NULL_PATH_ERROR = "Path to the JSON file is NULL!";

    static {
        MAPPER = new ObjectMapper();
        MAPPER.registerModule(new MrBeanModule());
        MAPPER.registerModule(new AfterburnerModule());
        MAPPER.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T readConfigurationResource(String filePathName, Class<T> valueType) {
        try {
            var fileURL = JsonUtils.class.getClassLoader().getResource(filePathName);
            if (fileURL != null) {
                return MAPPER.readValue(fileURL, valueType);
            } else {
                throw new RuntimeException(format(CONFIG_READ_ERROR, filePathName, NULL_PATH_ERROR));
            }
        } catch (IOException e) {
            throw new RuntimeException(format(CONFIG_READ_ERROR, filePathName, e.getMessage()), e);
        }
    }
}
