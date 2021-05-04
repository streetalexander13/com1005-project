import java.util.ArrayList;

public class RunRamblersAstart {

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		 TerrainMap tm = new TerrainMap("/Users/alexanderstreet/Downloads/COM1005_Assignment_2021/code/search3/diablo.pgm");
		
		//Goal State
	    RamblersSearch searcher = new RamblersSearch(tm, new Coords(240, 240));
	    
	    //Initial State
	    SearchState initState = (SearchState) new RamblersState(new Coords(0, 0), 0, 0);

	    
	    String res_bb = searcher.runSearch(initState, "AStar");
	    System.out.println(res_bb);
	    SearchNode n =  searcher.currentNode; 
	    ArrayList<Coords> array = new ArrayList<>();
	    while (n.getParent() != null) {
	    	array.add(((RamblersState) n.get_State()).getCords());
	        n = n.getParent();
	      }
	    tm.showPath(array);
	    tm.writeTMap("lage.pgm");
	    System.out.println("Writed to file");
	    final long endTime = System.currentTimeMillis();

	    System.out.println("Total execution time: " + (endTime - startTime));
	}

}
