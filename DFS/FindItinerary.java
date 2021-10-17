public class FindItinerary {
  // origin -> list of destinations
  HashMap<String, List<String>> flightMap = new HashMap<>();
  HashMap<String, boolean[]> visitBitmap = new HashMap<>();
  int flights = 0;
  List<String> result = null;


  public List<String> findItinerary(List<List<String>> tickets) {
    // Step 1). build the graph first
    for (List<String> ticket : tickets) {
      String origin = ticket.get(0);
      String dest = ticket.get(1);
      if (this.flightMap.containsKey(origin)) {
        List<String> destList = this.flightMap.get(origin);
        destList.add(dest);
      } else {
        List<String> destList = new LinkedList<String>();
        destList.add(dest);
        this.flightMap.put(origin, destList);
      }
    }

    // Step 2). order the destinations and init the visit bitmap
    for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet()) {
      Collections.sort(entry.getValue());
      this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
    }

    this.flights = tickets.size();
    LinkedList<String> route = new LinkedList<String>();
    route.add("JFK");

    // Step 3). backtracking
    this.backtracking("JFK", route);
    return this.result;
  }

  protected boolean backtracking(String origin, LinkedList<String> route) {
    if (route.size() == this.flights + 1) {
      this.result = (List<String>) route.clone();
      return true;
    }

    if (!this.flightMap.containsKey(origin))
      return false;

    int i = 0;
    boolean[] bitmap = this.visitBitmap.get(origin);

    for (String dest : this.flightMap.get(origin)) {
      if (!bitmap[i]) {
        bitmap[i] = true;
        route.add(dest);
        boolean ret = this.backtracking(dest, route);
        route.pollLast();
        bitmap[i] = false;

        if (ret)
          return true;
      }
      ++i;
    }

    return false;
  }    
}
/*abstract
You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:


Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:


Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.

*/