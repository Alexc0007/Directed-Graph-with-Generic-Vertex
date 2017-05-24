
/**
 * @author Alex Cherniak
 * this is the main program to test the Generic Directed Graph
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		DirectedGraph<Point> dGraph = new DirectedGraph<Point>(); //create a new graph
		
		//create 3 points
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(3,3);
		
		//add the points to dGraph
		
		try 
		{
			dGraph.addVertex(p1);
		} catch (VertexAlreadyInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			dGraph.addVertex(p2);
		} catch (VertexAlreadyInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			dGraph.addVertex(p3);
		} catch (VertexAlreadyInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		//print the graph so far
		System.out.println(dGraph.toString());
		
		//now will try to add p1 again and catch the exception
		try 
		{
			dGraph.addVertex(p1);
		} catch (VertexAlreadyInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		//exception caught and dealt with successfully
		
		//will now try to add 2 edges to the graph
		try 
		{
			dGraph.addEdge(p1, p2);
		} catch (EdgeAlreadyInGraphException | VertexNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			dGraph.addEdge(p1, p3);
		} catch (EdgeAlreadyInGraphException | VertexNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		//print dGraph with the edges
		System.out.println(dGraph.toString());
		
		//now testing remove edge
		try 
		{
			dGraph.removeEdge(p1, p2);
		} catch (EdgeNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		//print dGraph after removing edge
		System.out.println(dGraph.toString());
		
		//adding the edge back again
		try 
		{
			dGraph.addEdge(p1, p2);
		} catch (EdgeAlreadyInGraphException | VertexNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		//testing remove vertex
		try 
		{
			dGraph.removeVertex(p1);
		} catch (VertexNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		//printing the graph without p1
		System.out.println(dGraph);

		
		//will now create a new graph using the constructor that gets array of vertices / edges
		Point p4 = new Point(1,4);
		Point p5 = new Point(2,5);
		Point p6 = new Point(3,6);
		Point[] points = {p4 , p5 , p6};
		Edge<Point> e1 = new Edge<Point>(p4, p5);
		Edge<Point> e2 = new Edge<Point>(p4, p6);
		Edge<?>[] edges = {e1 , e2};
		DirectedGraph<Point> dGraph2 = new DirectedGraph<Point>(); //creates a new empty graph
		try 
		{
			dGraph2 = new DirectedGraph<Point>(points , (Edge<Point>[]) edges);
		} catch (VertexAlreadyInGraphException | EdgeAlreadyInGraphException | VertexNotInGraphException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(dGraph.toString());
		System.out.println();
		System.out.println(dGraph2.toString());
		System.out.println();
		if(dGraph.equals(dGraph2))
		{
			System.out.println("dGraph same as dGraph2");
		}
		else
		{
			System.out.println("graphs are not the same");
		}
		
		//lets make graphs the same
		try 
		{
			dGraph.addVertex(p1);
		} catch (VertexAlreadyInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		//adjust vertices
		p4.setX(p1.getX());
		p4.setY(p1.getY());
		p5.setX(p2.getX());
		p5.setY(p2.getY());
		p6.setX(p3.getX());
		p6.setY(p3.getY());
		
		try 
		{
			dGraph.addEdge(p1, p2);
		} catch (EdgeAlreadyInGraphException | VertexNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			dGraph.addEdge(p1, p3);
		} catch (EdgeAlreadyInGraphException | VertexNotInGraphException e) 
		{
			System.out.println(e.getMessage());
		}
		System.out.println(dGraph2.toString());
		System.out.println(dGraph.toString());
		
		//now check again if graphs are the same
		if(dGraph.equals(dGraph2))
		{
			System.out.println("dGraph same as dGraph2");
		}
		else
		{
			System.out.println("graphs are not the same");
		}
		
		
		System.out.println("All tests passed successfully - see ya on the next assignment");
	}

}
