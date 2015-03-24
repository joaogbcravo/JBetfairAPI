package prj.betfair.api.betting.navigation;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@JsonDeserialize(using = ItemDeserializer.class)
public interface Item {
  public Item getParent();
  
  public String getName();

  public String getType();

  public String getId();
  
  public void setParent(Item item);

  public void setName(String name);

  public void setType(String type);

  public void setId(String id);
  
  public List<Item> getChildren();
  
  public void setChildren(List<Item> children);
}
