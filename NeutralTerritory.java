public class NeutralTerritory extends Territory
{
  private Country alignment;
  private boolean mobilized;

  public NeutralTerritory(Country a, boolean mob, String n, Country c)
  {
    super(n, c, false);
  }
}
