
public class RunRamblersBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 TerrainMap tm = new TerrainMap("/Users/alexanderstreet/Downloads/COM1005_Assignment_2021/code/search3/tmc.pgm");
		
		//Goal State
	    RamblersSearch searcher = new RamblersSearch(tm, 10, 10);
	    
	    //Initial State
	    SearchState initState = (SearchState) new RamblersState(new Coords(7, 0), 0);

	    
	    String res_bb = searcher.runSearch(initState, "branchAndBound");
	    System.out.println(res_bb);
	}

}
