import java.util.*;


public class Fleet extends Army
{
   private int numBattleships, numDamagedBattleships, numCruisers, numSubmarines, numTransports, numInfantry, numArtillery, numTanks, numFighters;

   public Fleet(int inf, int art, int pla, int tan, int bat, int cru, int sub, int trans, Country cont, Territory loc)
   {
      super(inf, art, pla, tan, cont, loc);
      numBattleships = bat;
      numCruisers = cru;
      numSubmarines = sub;
      numTransports = trans;
   }

   public Fleet(int bat, int cru, int sub, int trans, Country cont, Territory loc)
   {
      super(0,0,0,0, cont, loc);
      numBattleships = bat;
      numCruisers = cru;
      numSubmarines = sub;
      numTransports = trans;
   }

   public Fleet(Country cont, Territory loc)
   {
      super(cont, loc);
      numBattleships = 0;
      numDamagedBattleships = 0;
      numCruisers = 0;
      numSubmarines = 0;
      numTransports = 0;
   }

   public int getShip(int x)
   {
      if(x == 4)
         return numBattleships;
      if(x == 5)
         return numCruisers;
      if(x == 6)
         return numSubmarines;
      if(x == 7)
         return numTransports;
      return super.getTroop(x);
   }
        
   public int getDamagedBattleships()
   {
      return numDamagedBattleships;
   }
        
   public void addDamagedBattleships(int x)
   {
      numDamagedBattleships += x;
      if(numDamagedBattleships > numBattleships)
         numDamagedBattleships = numBattleships;
      numBattleships -= x;
      if(numBattleships < 0)
         numBattleships = 0;
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
         numCruisers += amt;
      else if(type == 6)
         numSubmarines += amt;
      else if(type == 7)
         numTransports += amt;
   }

   public boolean isEmpty()
   {
      if(numTransports == 0 && numBattleships == 0 && numCruisers == 0 && numSubmarines == 0)
         return true;
      return false;
   }
      
   @Override
   public String toString()
   {
      // Austria-Hungary (8 battleships (3 damaged), 1 cruisers, 2 submarines, 5 transports)
      return super.getController().getName() + " (" + (numBattleships + numDamagedBattleships) + " battleships (" + numDamagedBattleships + " damaged, " + numBattleships + " healthy), " + numCruisers + " cruisers, " + numSubmarines + " submarines, " + numTransports + " transports)";
   }
}
