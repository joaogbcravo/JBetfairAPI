package prj.betfair.api.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Cli {
  private final BufferedReader in;
  public Cli() {
    in = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public void printOptions(List<?> options) {
    printOptions(options.toArray());
  }
  
  public void printOptions(Object[] options) {
    int i = 0;
    System.out.println("----------------");
    for(Object option : options) {
      System.out.println("["+ ++i +"] " + option);
    }
    System.out.println("----------------");
    System.out.println("[0] BACK");
    System.out.println("----------------");
    System.out.println();
  }
  
  private String readLine() {
    String ret = null;
    try {
      System.out.print("$>");
      ret = in.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(-1);
    }
    return ret;
  }
  
  public String readString() {
    return readLine();
  }
  
  public Integer readInteger() {
    String s = readLine();
    Integer ret = null;
    try{
    ret = Integer.parseInt(s);
    } catch(NumberFormatException e) {
      System.out.println("Number entered not an integer!");
    }
    return ret;
  }
  
  public Double readDouble() {
    String s = readLine();
    Double ret = null;
    try{
    ret = Double.parseDouble(s);
    } catch(NumberFormatException e) {
      System.out.println("Number entered not a double!");
    }
    return ret;
  }
  
  public Long readLong() {
    String s = readLine();
    Long ret = null;
    try{
    ret = Long.parseLong(s);
    } catch(NumberFormatException e) {
      System.out.println("Number entered not a long!");
    }
    return ret;    
  }
  
  public void println(String s) {
    System.out.println(s);
  }
  
  public void print(String s) {
    System.out.print(s);
  }
}
