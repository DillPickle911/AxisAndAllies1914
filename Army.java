public class Army
{
  private int numInfantry, numArtillery, numPlanes, numTanks;
  private Country controller;
  private Territory location;

  public Army(int inf, int art, int pla, int tan, Country cont, Territory loc)
  {
    numInfantry = inf;
    numArtillery = art;
    numPlanes = pla;
    numTanks = tan;
    controller = cont;
    location = loc;
  }

  
}
