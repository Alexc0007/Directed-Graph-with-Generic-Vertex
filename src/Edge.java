
/**
 * @author Alex Cherniak
 *this class represents an Edge on a graph that is using a generic type of Vertex
 *an edge is represented by 2 vertices
 */
public class Edge <Vertex extends Comparable<Vertex>>
{
	/**************************************************************************************************************
	 * instance variables
	 *************************************************************************************************************/
	private Vertex firstVertex; //represents the first vertex on the edge
	private Vertex secondVertex; //represents the second vertex on the edge
	
	/***************************************************************************************************************
	 * Constructors
	 **************************************************************************************************************/
	//constructor that builds an edge out of 2 vertices
	public Edge(Vertex a , Vertex b)
	{
		firstVertex = a;
		secondVertex = b;
	}
	
	/******************************************************************************************************************
	 * Getters Setters
	 *****************************************************************************************************************/
	public Vertex getFirstVertex()
	{
		return firstVertex;
	}
	public void setFirstVertex(Vertex vertex)
	{
		this.firstVertex = vertex;
	}
	public Vertex getSecondVertex()
	{
		return secondVertex;
	}
	public void setSecondVertex(Vertex vertex)
	{
		this.secondVertex = vertex;
	}
	
	/***********************************************************************************************************************
	 * Methods
	 ***********************************************************************************************************************/
	
	public String toString()
	{
		return "[" + firstVertex.toString() + "," + secondVertex.toString() + "]";
	}
}
