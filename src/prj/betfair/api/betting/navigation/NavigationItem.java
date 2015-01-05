package prj.betfair.api.betting.navigation;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NavigationItem extends ItemData {
  private NavigationItem parent;
  private ArrayList<NavigationItem> children;

  public NavigationItem() {};

  public ArrayList<NavigationItem> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<NavigationItem> children) {
    this.children = children;
    for (NavigationItem item : this.children) {
      item.setParent(this);
    }
  }

  @JsonIgnore
  public void setParent(NavigationItem parent) {
    this.parent = parent;
  }

  @JsonIgnore
  public NavigationItem getParent() {
    return parent;
  }

}
