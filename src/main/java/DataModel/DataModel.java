package DataModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataModel {
    private static final Logger LOG = LoggerFactory.getLogger(DataModel.class);

    @Override
    public String toString() {
        var ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOG.warn("Error while parsing a data model class {}! Object.toString() will be used instead.",
                    this.getClass().getName());
            return super.toString();
        }
    }
}
