package bex.training.team;

import com.psddev.dari.db.Record;

public class Team extends Record{

  @Required
  @Indexed
  private String name;

  private String description;

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;

  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }
}
