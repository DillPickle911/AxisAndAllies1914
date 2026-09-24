public class Army
{
  private int numInfantry, numArtillery, numFighters, numTanks;
  private Country controller;
  private Territory location, preMoveLocation;

  public Army(int inf, int art, int pla, int tan, Country cont, Territory loc)
  {
    numInfantry = inf;
    numArtillery = art;
    numFighters = pla;
    numTanks = tan;
    controller = cont;
    location = loc;
    preMoveLocation = location;
  }

  public Army(Country cont, Territory loc, Territory ploc)
  {
    numInfantry = 0;
    numArtillery = 0;
    numFighters = 0;
    numTanks = 0;
    controller = cont;
    location = loc;
    preMoveLocation = ploc;
  }

  public int getInfantry()
  {
    return numInfantry;
  }
  
  public int getArtillery()
  {
    return numArtillery;
  }

  public int getFighters()
  {
    return numFighters;
  }

  public int getTanks()
  {
    return numTanks;
  }

  public Country getController()
  {
    return controller;
  }

  public Territory getLocation()
  {
    return location;
  }

  public Territory getPreMovementLocation()
  {
    return preMoveLocation;
  }

  public void addTroops(int type, int amt)
  {
    if(type == 0)
    {
      numInfantry += amt;
      if(numInfantry < 0)
        numInfantry = 0;
    }
    else if(type == 1)
    {
      numArtillery += amt;
      if(numArtillery < 0)
        numArtillery = 0;
    }
    else if(type == 2)
    {
      numTanks += amt;
      if(numTanks < 0)
        numTanks = 0;
    }
    else if(type == 3)
      numFighters += amt;
      if(numFighters < 0)
        numFighters = 0;
  }

  @Override
  public String toString()
  {
    return controller.getName() + " (" + numInfantry + " infantry, " + numArtillery + " artillery, " + numTanks + " tanks, " + numFighters + " fighters)";
  }
}
