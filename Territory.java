import java.util.ArrayList;

public class Territory
{
   
   private String name;
   private String[] neighbors;
   private Country controller, originalController;
   private ArrayList<Army> centralPowers, alliedPowers;
   private boolean contested, isCity;
   private int ipc;
   
   public Territory(String n, Country c, boolean city, int i, String[] nei)
   {
      name = n;
      controller = c;
      originalController = c;
      centralPowers = new ArrayList<Army>();
      alliedPowers = new ArrayList<Army>();
      contested = false;
      isCity = city;
      ipc = i;
      neighbors = nei;
   }
   
   public String getName()
   {
      return name;
   }
   
   public Country getController()
   {
      return controller;
   }
   
   public void setController(Country c)
   {
      controller = c;
   }
   
   public Country getOriginalController()
   {
      return originalController;
   }

   public int getIPC()
   {
      return ipc;
   }
   
   public ArrayList<Army> getCentralPowers()
   {
      return centralPowers;
   }
   
   public String[] getNeighbors()
   {
      return neighbors;
   }
   
   public Army getCentralPower(Country c)
   {
      for(int i = 0; i < centralPowers.size(); i++)
      {
         if(centralPowers.get(i).getController().equals(c))
            return centralPowers.get(i);
      }      
      return null;
   }

   public ArrayList<Army> getAlliedPowers()
   {
      return alliedPowers;
   }
   
   public Army getAlliedPower(Country c)
   {
      for(int i = 0; i < alliedPowers.size(); i++)
      {
         if(alliedPowers.get(i).getController().equals(c))
            return alliedPowers.get(i);
      }      
      return null;
   }

   public void addTroops(Country c, int type, int amt)
   {
      boolean countryFound = false;
      if(c.isCentralPower())
      {
         for(int i = 0; i < centralPowers.size(); i++)
         {
            if(centralPowers.get(i).getController().equals(c))
            {
               centralPowers.get(i).addTroops(type, amt);
               countryFound = true;
            }
         }
         if(!countryFound)
         {
            centralPowers.add(new Army(c, this, this));
            centralPowers.get(centralPowers.size() - 1).addTroops(type, amt);
         }
      }
      else
      {
         for(int i = 0; i < alliedPowers.size(); i++)
         {
            if(alliedPowers.get(i).getController().equals(c))
            {
               alliedPowers.get(i).addTroops(type, amt);
               countryFound = true;
            }
         }
         if(!countryFound)
         {
            centralPowers.add(new Army(0, 0, 0, 0, c, this));
            centralPowers.get(centralPowers.size() - 1).addTroops(type, amt);
         }
      }
   }
   
   public boolean isContested()
   {
      return contested;
   }
   
   public void setContested(boolean c)
   {
      contested = c;
   }
   
   public boolean isCity()
   {
      return isCity;
   }
   
   @Override
   public String toString()
   {
      return ("Name: " + name + "\nController: " + controller.getName() + "\nOriginal Controller: " + originalController.getName() + "\nAllied Troops: " + alliedPowers.toString() + "\n Central Troops: " + centralPowers.toString() + "\nContested?: " + contested + "\nCity?: " + isCity);
   }
}
