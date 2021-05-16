
public class RamblersSearch extends Search{

	  private TerrainMap map; 
	  private Coords goal; 
	
	public RamblersSearch(TerrainMap tm, Coords cord) {
		goal = cord;
		map = tm;
		
	}
	  public TerrainMap getMap(){
	    return map;
	  }
	  public Coords getGoal(){
	    return goal;
	  }


}
