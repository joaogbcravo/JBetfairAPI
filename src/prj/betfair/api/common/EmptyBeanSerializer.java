package prj.betfair.api.common;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;

public class EmptyBeanSerializer extends JsonSerializer<Object>{

  @Override
  public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
      throws IOException, JsonProcessingException {
    arg2.getConfig().without(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    arg1.writeStartObject();
    arg1.writeEndObject();    
  }

}
