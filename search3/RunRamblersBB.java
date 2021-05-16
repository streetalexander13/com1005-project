import java.util.ArrayList;

public class RunRamblersBB {

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		TerrainMap tm = new TerrainMap("diablo.pgm");
		
		//Goal State
	    RamblersSearch searcher = new RamblersSearch(tm, new Coords(87, 34));
	    
	    //Initial State
	    SearchState initState = (SearchState) new RamblersState(new Coords(200, 87), 0);

	    
	    String res_bb = searcher.runSearch(initState, "branchAndBound");
	    System.out.println(res_bb);
	   
	    
	    //Below code is to print result in new pgm file, Although current node in search has to be set to public 
	    //SearchNode n =  searcher.currentNode; 
	    //ArrayList<Coords> array = new ArrayList<>();
	    //while (n.getParent() != null) {
	    //	array.add(((RamblersState) n.get_State()).getCords());
	    //   n = n.getParent();
	    //  }
	    //tm.showPath(array);
	    //tm.writeTMap("PathAccross.pgm");
	    //System.out.println("Wrote to file");
	    
	    
	    final long endTime = System.currentTimeMillis();
	    System.out.println("Total execution time: " + (endTime - startTime));
	}

}