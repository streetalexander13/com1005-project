public class RamblersSearch extends Search{

	  private TerrainMap map; //map we're searching
	  private Coords goal; //goal city
	
	public RamblersSearch(TerrainMap tm, Coords cord) {
		// TODO Auto-generated constructor stub
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