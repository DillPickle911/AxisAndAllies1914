public class Army
{
  private int numInfantry, numArtillery, numPlanes, numTanks;
  private Country controller;
  private Territory location, preMoveLocation;

  public Army(int inf, int art, int pla, int tan, Country cont, Territory loc)
  {
    numInfantry = inf;
    numArtillery = art;
    numPlanes = pla;
    numTanks = tan;
    controller = cont;
    location = loc;
    preMoveLocation = location;
  }

  public int getInfantry()
  {
    return numInfantry;
  }
  
  public int getArtillery()
  {
    return numArtillery;
  }

  public int getPlanes()
  {
    return numPlanes;
  }

  public int getTanks()
  {
    return numTanks();
  }

  public void addTroops(int type, int amt)
  {
    if(type == 0)
      numInfantry += amt;
    else if(type == 1)
      numArtillery += amt;
    else if(type == 2)
      numTanks += amt;
    else if(type == 3)
      numPlanes += amt;
  }

  public Country getController()
  {
    return controller;
  }
}
