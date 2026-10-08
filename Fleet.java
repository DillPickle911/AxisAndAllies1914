public class Fleet
{
  public class Fleet extends Army
{
    private int numBattleships, numDamagedBattleships, numCruisers, numSubmarines, numTransports;

    public Fleet(int inf, int art, int pla, int tan, int bat, int cru, int sub, int trans, Country cont, Territory loc)
    {
        super(inf, art, pla, tan, cont, loc);
        numBattleships = bat;
        numCruisers = cru;
        numSubmarines = sub;
        numTransports = trans;
    }

    public Fleet(Country cont, Territory loc)
    {
        super(cont, loc);
        numBattleships = 0;
        numCruisers = 0;
        numSubmarines = 0;
        numTransports = 0;
    }

    public int getShip(int x)
    {
        if(x == 4)
            return numBattleships;
        if(x == 5)
            return numDamagedBattleships;
        if(x == 6)
            return numCruisers;
        if(x == 7)
          return numSubmarines;
        if(x == 8)
            return numTransports;
        return super.getTroop(int x);
    }

    @Override
    public void addTroops(int type, int amt)
    {
        if(type == 0)
            numInfantry += amt;
        else if(type == 1)
            numArtillery += amt;
        else if(type == 2)
            numTanks += amt;
        else if(type == 3)
            numFighters += amt;
        else if(type == 4)
            numBattleships += amt;
        else if(type == 5)
          numDamagedBattleships += amt;
        else if(type == 6)
            numCruisers += amt;
        else if(type == 7)
            numSubmarines += amt;
        else if(type == 8)
            numTransports += amt;
    }
}
}
