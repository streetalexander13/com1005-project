import java.util.ArrayList;

public class RamblersState extends SearchState{
	
	private Coords cords;
	private int estimatedCost;
	
	
	public RamblersState(Coords cord, int lc, int est) {
		cords = cord;
		localCost=lc;
		estimatedCost = est;
		
	}
	public int getestRemCost() {
		    return estimatedCost;
	}

	@Override
	boolean goalPredicate(Search searcher) {
		RamblersSearch rsearcher = (RamblersSearch) searcher;
	    Coords tar = rsearcher.getGoal(); // get target city
	    if (cords.getx() == tar.getx() && cords.gety() == tar.gety()) {
	    	return true;
	    }else {
	    	return false;
	    }
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		RamblersSearch msearcher = (RamblersSearch) searcher;
	    TerrainMap map = msearcher.getMap();
	    ArrayList<Coords> path = new ArrayList<>();
	    if (cords.getx()+1  < map.getWidth()) {
	    	path.add(new Coords(cords.gety(), cords.getx() + 1));
	    }
	    if (cords.gety()+1 < map.getDepth()) {
	    	path.add(new Coords(cords.gety() + 1, cords.getx()));
	    }
	    if (cords.getx() > 0) {
	    	path.add(new Coords(cords.gety(), cords.getx() - 1));
	    }
	    if (cords.gety() > 0) {
	    	path.add(new Coords(cords.gety() -1 , cords.getx()));
	    }

	    ArrayList<SearchState> succs = new ArrayList<SearchState>();

	    for (Coords l : path) {
	    	
	    	Coords scord = l;
	    	int heightc = map.getTmap()[cords.gety()][cords.getx()];
	    	int heightd = map.getTmap()[l.gety()][l.getx()];
	    	int cost = (heightd - heightc);
	 
	    	if (heightd <= heightc) {
	    		cost = 0;
	    	}
	       	cost = (cost < 0 ? -cost : cost);
	       	cost = cost + 1;
	      succs.add((SearchState) new RamblersState(scord, cost, estimateCostCal(scord.gety(), scord.getx(), searcher, map, heightd)));
	    }
	    return succs;
	}

	@Override
	boolean sameState(SearchState n2) {
	    RamblersState ms2 = (RamblersState) n2;
	    return (this.toString().compareTo(ms2.toString()) == 0);
	}
	
	 public Coords getCords() {
		return cords;
	}
	 
	 
	 public int estimateCostCal(int y, int x, Search searcher, TerrainMap map, int heightd){
		 RamblersSearch rsearcher = (RamblersSearch) searcher;
		 Coords tar = rsearcher.getGoal();
		 
		 //Add below line for use of height metric
		 //int cost = map.getTmap()[tar.gety()][tar.getx()] - heightd;
		 //cost = (cost < 0 ? -cost : cost);
		 
		 
		 int cost = (x-tar.getx());
		 cost = (cost < 0 ? -cost : cost);
		 cost = cost +  (y-tar.gety());
		 cost = (cost < 0 ? -cost : cost);
		 
		 //Use below line to use euclidian distance
		 //int cost =  (int) Math.sqrt(Math.pow((y-tar.gety()), 2) + Math.pow((x-tar.getx()), 2));
		 
		 return cost;
	 }
	 
	  public String toString() {
		    return ("Cords -  X :" + cords.getx() + " Y : " + cords.gety());
		  }


}
