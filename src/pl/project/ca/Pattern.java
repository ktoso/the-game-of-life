package pl.project.ca;

public class Pattern {

  private String   name;
  private String[] pattern;

  /**
   * class to handle patterns
   */

  public String getName() {
    return name;
  }

  void setName(String nazwa) {
    this.name = nazwa;
  }

  public String[] getPattern() {
    return pattern;
  }

  public void setPattern(String[] wzorzec) {
    this.pattern = wzorzec;
  }

  public Pattern(String nazwa, String[] wzorzec) {
    this.name = nazwa;
    this.pattern = wzorzec;
  }

  public String toString() {
    return name;
  }

  //loads the example Pattern
  public static Pattern[] setPattern() {
    Pattern[] pattern = new Pattern[1];
    pattern[0] = new Pattern("Worm", new String[]{"0#0", "0##", "#0#"});
    return pattern;
  }
}