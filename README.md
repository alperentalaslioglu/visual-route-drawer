# Route-GUI-Drawer
This is a Java GUI design for routing problems' visualizations. 

I used this GUI drawer for Industrial Engineering project. This is a perfect visualizer for travel sales problems or
some kind of depot-ending routing problems.

You should give coordinates as a data.txt file

example data.txt
51 // First line is number of nodes included depot
35	35 // Depot coordinate
41	49 // node1
35	17 // node2
55	45 // node3
55	20 // node4
15	30 // node5
25	30 // node6
20	50 // node7
10	43 // node8
55	60 // node9
30	60 // node9
20	65 // node10

You should give routes as a ArrayList.

Example route: 

		ArrayList route2 = new ArrayList();
		route2.add(1);
		route2.add(26);
		route2.add(41);
		route2.add(5);
		route2.add(38);		
		routes[1] = route2;

 Structure of route :
 route[0] = { 1 , 26 , 41 , 5 , 38 }
 A vehicle starts route from depot then firstly go node 1 then 26 then 41 then 5 then 38 at the end from 38 it comes back to depot.So route[0] means 0 -> 1 -> 26 -> 41 -> 5 -> 38 -> 0
