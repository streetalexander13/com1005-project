import java.util.ArrayList;

public class RunRamblersAstart {

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		 TerrainMap tm = new TerrainMap("/Users/alexanderstreet/Downloads/COM1005_Assignment_2021/code/search3/diablo.pgm");
		
		//Goal State
	    RamblersSearch searcher = new RamblersSearch(tm, new Coords(87, 34));
	    
	    //Initial State
	    SearchState initState = (SearchState) new RamblersState(new Coords(200,87), 0, 0);

	    
	    String res_Astar = searcher.runSearch(initState, "AStar");
	    System.out.println(res_Astar);
	    final long endTime = System.currentTimeMillis();

	    System.out.println("Total execution time: " + (endTime - startTime));
	}

}
