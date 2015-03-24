package prj.betfair.api.betting.navigation;

import java.util.List;
public class BaseItem implements Item{
  private Item parent;
  private String name;
  private String type;
  private String id;
  private List<Item> children;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public List<Item> getChildren() {
    return this.children;
  }

  @Override
  public void setChildren(List<Item> children) {
    this.children = children;
  }

  @Override
  public Item getParent() {
    return parent;
  }

  @Override
  public void setParent(Item item) {
    parent = item;
  }
  
  @Override
  public String toString(){
    return name;
  }
}
