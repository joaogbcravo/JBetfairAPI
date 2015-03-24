package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import prj.betfair.api.betting.navigation.Item;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NavigationItemTest {
  @Test
  public void test() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();

    Item item =
        mapper.readValue(new File("./src/test/resources/navigationData.txt"), Item.class);
    assertEquals(item.getName(), "ROOT");
    assertEquals(item.getChildren().size(), 2);
    assertEquals(item.getChildren().get(0).getName(), "Soccer");
    assertEquals(item.getChildren().get(0).getType(), "EVENT_TYPE");
    assertEquals(item.getChildren().get(0).getId(), "1");
    assertEquals(item.getChildren().get(0).getChildren().get(0).getType(), "RACE");
    assertEquals(item.getChildren().get(0).getChildren().get(0).getChildren().get(0).getType(),
        "MARKET");
  }
}
