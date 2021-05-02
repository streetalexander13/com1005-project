
public class RamblersSearch extends Search{

	  private TerrainMap map; //map we're searching
	  private int xGoal; //goal city
	  private int yGoal; //goal city
	
	public RamblersSearch(TerrainMap tm, int x, int y) {
		// TODO Auto-generated constructor stub
		xGoal = x;
		yGoal = y;
		map = tm;
		
		
	}
	  public TerrainMap getMap(){
	    return map;
	  }
	  public Coords getGoal(){
	    return (new Coords(5, 8));
	  }


}
