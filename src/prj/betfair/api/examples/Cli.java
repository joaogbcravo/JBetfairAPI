package prj.betfair.api.examples;

import java.io.BufferedReader;
import java.io.IOException;

public class Cli {
  private final BufferedReader in;
  public Cli(BufferedReader in) {
    this.in = in;
  }
  private String readLine() {
    String ret = null;
    try {
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
