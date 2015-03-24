package prj.betfair.api.betting.navigation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ItemDeserializer extends JsonDeserializer<Item> {

  private final SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss.SSS'Z'");

  @Override
  public Item deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
      JsonProcessingException {
    JsonNode rootNode = jp.getCodec().readTree(jp);
    Item rootItem = createItem(rootNode, null);
    Stack<JsonNode> stack = new Stack<JsonNode>();
    Stack<Item> itemStack = new Stack<Item>();
    Set<JsonNode> visited = new HashSet<JsonNode>();
    stack.push(rootNode);
    itemStack.push(rootItem);
    JsonNode tmpNode;
    Item tmpItem;
    while (!stack.isEmpty()) {
      tmpNode = stack.pop();
      tmpItem = itemStack.pop();
      if (visited.contains(tmpNode))
        continue;
      visited.add(tmpNode);
      if(tmpNode.get("children") == null)
        continue;
      for (Iterator<JsonNode> i = tmpNode.get("children").iterator(); i.hasNext();) {
        JsonNode n = i.next();
        stack.push(n);
        Item tmp = createItem(n, tmpItem);
        itemStack.push(tmp);
        tmpItem.getChildren().add(tmp);
      }

    }
    return rootItem;
  }

  private Item createItem(JsonNode node, Item parent) {
    String type = node.get("type").asText();
    Item item;
    if (type.equals("GROUP")) {
      item = createGroupItem(node);
    } else if (type.equals("EVENT_TYPE")) {
      item = createEventTypeItem(node);
    } else if (type.equals("EVENT")) {
      item = createEventItem(node);
    } else if (type.equals("MARKET")) {
      item = createMarketItem(node);
    } else if (type.equals("RACE")) {
      item = createRaceItem(node);
    } else {
      return null;
    }
    item.setParent(parent);
    return item;
  }

  private Item createEventItem(JsonNode node) {
    EventItem item = new EventItem();
    item.setId(node.get("id").asText());
    item.setName(node.get("name").asText());
    item.setType(node.get("type").asText());
    item.setCountryCode(node.get("countryCode").asText());
    item.setChildren(new ArrayList<Item>());
    return (Item) item;
  }

  private Item createEventTypeItem(JsonNode node) {
    EventTypeItem item = new EventTypeItem();
    item.setId(node.get("id").asText());
    item.setName(node.get("name").asText());
    item.setType(node.get("type").asText());
    item.setChildren(new ArrayList<Item>());
    return (Item) item;
  }

  private Item createGroupItem(JsonNode node) {
    GroupItem item = new GroupItem();
    item.setId(node.get("id").asText());
    item.setName(node.get("name").asText());
    item.setType(node.get("type").asText());
    item.setChildren(new ArrayList<Item>());
    return (Item) item;
  }

  private Item createRaceItem(JsonNode node) {
    RaceItem item = new RaceItem();
    item.setId(node.get("id").asText());
    item.setName(node.get("name").asText());
    item.setType(node.get("type").asText());
    item.setCountryCode(node.get("countryCode").asText());
    item.setVenue(node.get("venue").asText());
    try {
      item.setStartTime(formatter.parse(node.get("startTime").asText()));
    } catch (ParseException e) {
      System.out.println("ERROR: Failed to parse" + node.get("startTime").asText());
    }
    item.setChildren(new ArrayList<Item>());
    return (Item) item;
  }

  private Item createMarketItem(JsonNode node) {
    MarketItem item = new MarketItem();
    item.setId(node.get("id").asText());
    item.setName(node.get("name").asText());
    item.setType(node.get("type").asText());
    item.setExchangeId(node.get("exchangeId").asText());
    try {
      item.setMarketStartTime(formatter.parse(node.get("marketStartTime").asText()));
    } catch (ParseException e) {
      System.out.println("ERROR: Failed to parse" + node.get("marketStartTime").asText());
    }
    item.setMarketType(node.get("marketType").asText());
    item.setNumberOfWinners(node.get("numberOfWinners").asInt());
    item.setChildren(new ArrayList<Item>());
    return (Item) item;
  }



}
