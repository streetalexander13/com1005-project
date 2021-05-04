import java.util.ArrayList;

public class RamblersState extends SearchState{
	
	private Coords cords;
	private int estimatedCost;
	
	
	public RamblersState(Coords cord, int lc, int est) {
		cords = cord;
		//System.out.println("Cords -  X :" + cords.getx() + " Y : " + cords.gety());
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
	    	//System.out.println(heightc + "-" + heightd + "-" + cost +"--"+ scord.getx() + "--" + scord.gety() + "--" + estimateCostCal(scord.gety(), scord.getx(), searcher));
	      succs.add((SearchState) new RamblersState(scord, cost, estimateCostCal(scord.gety(), scord.getx(), searcher)));
	    }
	    //System.out.println(succs);
	    return succs;
	}

	@Override
	boolean sameState(SearchState n2) {
	    RamblersState ms2 = (RamblersState) n2;
	    return (this.toString().compareTo(ms2.toString()) == 0);
	}
	
	 public Coords getCords() {
		// TODO Auto-generated method stub
		return cords;
	}
	 
	 
	 public int estimateCostCal(int y, int x, Search searcher){
		 RamblersSearch rsearcher = (RamblersSearch) searcher;
		 Coords tar = rsearcher.getGoal();
		 int cost = tar.getx() - x;
		 cost = (cost < 0 ? -cost : cost);
		 cost = cost + (tar.gety()-y);
		 cost = (cost < 0 ? -cost : cost);
		 return cost;
	 }
	 
	  public String toString() {
		    return ("Cords -  X :" + cords.getx() + " Y : " + cords.gety());
		  }


}
