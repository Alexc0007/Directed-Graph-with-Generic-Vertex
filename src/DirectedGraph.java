import java.util.ArrayList;

/**
 * @author Alex Cherniak
 * this class represents a Generic Directed Graph that is using a generic type vertex <Vertex>
 * vertices and edges are stored on arraylists
 *
 */
public class DirectedGraph <Vertex extends Comparable<Vertex>>
{
	/***********************************************************************************************************
	 * Instance Variables
	 **********************************************************************************************************/
	protected ArrayList<Vertex> vertices; //array list of characters to represent the vertices on the graph
	protected ArrayList<Edge<Vertex>> edges; //array list of edges to represent the edges on the graph
	
	/***********************************************************************************************************
	 * Constructors
	 ***********************************************************************************************************/
	//empty constructor - creates an empty graph
	public DirectedGraph()
	{
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge<Vertex>>();
	}
	
	//a constructor that gets an array of vertices and an array of edges and creates a graph out of them
		public DirectedGraph(Vertex[] verticesArray , Edge<Vertex>[] edgesArray) throws VertexAlreadyInGraphException, EdgeAlreadyInGraphException, VertexNotInGraphException
		{
			this.vertices = new ArrayList<Vertex>();
			this.edges = new ArrayList<Edge<Vertex>>();
			
			for(int i=0;i<verticesArray.length;i++) //loop over the vertices array and try to add all the vertices to the graph
			{
				this.addVertex(verticesArray[i]);
			}
			
			for (int i=0;i<edgesArray.length;i++) //now loop over the edges
			{
				this.addEdge(edgesArray[i].getFirstVertex() , edgesArray[i].getSecondVertex());
			}
		}
		
		
		/************************************************************************************************************
		 * Methods
		 * @throws VertexAlreadyInGraphException 
		 ************************************************************************************************************/
		
		/*
		 * add vertex method:
		 * will add a vertex to the graph if its not already in it
		 * will will throw an exception if the vertex is already in the graph
		 */
		public void addVertex(Vertex vertex) throws VertexAlreadyInGraphException
		{
			for(int i=0;i<vertices.size();i++) //loop over the array list
			{
				if(vertex.compareTo(vertices.get(i)) == 0) //means the vertex is already on the Graph
				{
					throw new VertexAlreadyInGraphException("Cant add " + vertex + " since its already in the graph");
				}
			}
			vertices.add(vertex); //no such vertex in the list - adding the vertex to the list
		}
		
		/*
		 * remove vertex method - will remove a vertex from the graph
		 * will throw an exception if was unable to remove the given vertex
		 */
		public void removeVertex(Vertex vertex) throws VertexNotInGraphException
		{
			for(int i=0;i<vertices.size();i++) //loop over the vertices arraylist
			{
				if(vertex.compareTo(vertices.get(i)) == 0) //if found the vertex on the vertices list will now look for edges connected to that vertex
				{
					for(int j=0;i<edges.size();j++) //loop over the edges array list - look for edges connected to the given vertex
					{
						if(vertex.compareTo((Vertex)edges.get(j).getFirstVertex()) == 0 || vertex.compareTo((Vertex) edges.get(j).getSecondVertex()) == 0)
						{
							edges.remove(j);
							j--; //go back a step in order to not miss any cells on the array list after removal
						}
					}
					vertices.remove(i);
					return;
				}
			}
			//if got here - means that vertex wasnt found on the graph
			throw new VertexNotInGraphException("Vertex " + vertex + " is not present in the graph"); //throw exception
		}
		
		/*
		 * vertex is present method - checks if a given vertex is already present on the graph
		 * will return true if found the vertex on the graph
		 * will return false if didnt find the vertex on the graph
		 */
		public boolean vertexIsPresent(Vertex vertex)
		{
			for(int i=0;i<vertices.size();i++) //loop over the vertices array
			{
				if(vertex.compareTo(vertices.get(i)) == 0) //vertex is equal to the vertex on index i on vertices array
				{
					return true;
				}
			}
			return false; //didnt find the vertex on the graph
		}
		
		/*
		 * edge is present method:
		 * will check if the given edge is present in the graph
		 * will return true if it does
		 * will return false if its not
		 */
		public boolean edgeIsPresent(Edge<Vertex> edge)
		{
			for(int i=0;i<edges.size();i++)//loop over the edges list
			{
				if(edge.getFirstVertex().compareTo(edges.get(i).getFirstVertex()) == 0 && edge.getSecondVertex().compareTo(edges.get(i).getSecondVertex()) == 0)
				{
					//found the given edge on the graph
					return true;
				}
			}
			return false;
		}
		
		/*
		 * addEdge method - will try to add the given edge to the graph
		 * will throw an exception if the edge is already on the graph
		 * will throw an exception if one of the vertices of the given edge is missing on the graph
		 */
		public void addEdge(Vertex v1 , Vertex v2) throws EdgeAlreadyInGraphException, VertexNotInGraphException
		{
			Edge<Vertex> edge = new Edge<Vertex>(v1, v2); //create an edge out of the 2 vertices that were given as arguments
			if(edgeIsPresent(edge))
				throw new EdgeAlreadyInGraphException("Edge " + edge + "is already on the grpah");
			if(vertexIsPresent(edge.getFirstVertex()) != true || vertexIsPresent(edge.getSecondVertex()) != true)
				throw new VertexNotInGraphException("Vertex " + edge.getFirstVertex() + " or " + edge.getSecondVertex() + " are missing from the graph");
			
			edges.add(edge); //everything is ok and edge can be added to the graph
		}
		
		/*
		 * remove edge method - will try to remove an edge that is created by the 2 given vertices
		 * will throw exception if the edge is not present on the graph
		 */
		public void removeEdge(Vertex v1 , Vertex v2) throws EdgeNotInGraphException
		{
			Edge<Vertex> edge = new Edge<Vertex>(v1, v2); //create an edge out of the 2 vertices that were given as arguments
			if(edgeIsPresent(edge) == false)
				throw new EdgeNotInGraphException("Edge " + edge + " is not present on the graph");
			for(int i=0;i<edges.size();i++)
			{
				if(edge.getFirstVertex().compareTo(edges.get(i).getFirstVertex()) == 0 && edge.getSecondVertex().compareTo(edges.get(i).getSecondVertex()) == 0)
				{
					//means that we found the required edge
					edges.remove(i); //remove the given edge from the edges list
				}
			}
		}
		
		
		/*
		 * equals method - will return true if this graph is equal to the given graph
		 * else will return false
		 */
		public boolean equals(Object graph)
		{
			DirectedGraph<Vertex> newGraph = new DirectedGraph<Vertex>(); //create an empty graph
			newGraph = (DirectedGraph<Vertex>)graph; //assign the given graph to be newGraph - so i could work with it
			for(int i=0;i<vertices.size();i++)
			{
				if(this.vertexIsPresent(newGraph.vertices.get(i)) == false) //check if there is a vertex in graph that is not a vertex in this
				{
					return false;
				}
				if(newGraph.vertexIsPresent(this.vertices.get(i)) == false) //check if there is a vertex in this that is not a vertex in graph
				{
					return false;
				}
			}
			//now moving to edges
			for(int i=0;i<edges.size();i++)
			{
				if(this.edgeIsPresent(newGraph.edges.get(i)) == false) //check if there is an edge in graph that is not in this
				{
					return false;
				}
				if(newGraph.edgeIsPresent(this.edges.get(i)) == false) //check if there is an edge in this that is not in graph
				{
					return false;
				}
			}
			//if got here - the graphs are equal
			return true;
		}
		
		/*
		 * toString - a string representation of the graph
		 */
		public String toString()
		{
			String vertices = "";
			String edges = "";
			for(int i=0;i<this.vertices.size();i++)
			{
				vertices = vertices + this.vertices.get(i).toString(); //add the vertex to the string vertices
				if(i < this.vertices.size()-1)
					vertices = vertices + ","; //add comma until we get to the last vertex
			}
			
			for(int i=0;i<this.edges.size();i++)
			{
				edges = edges + this.edges.get(i).toString();
				if(i < this.edges.size()-1)
					edges = edges + ",";
			}
			
			return "Vertices:" + "{" +  vertices + "}\n" + "Edges:" + "{" + edges + "}";
		}
		
		
		
}
