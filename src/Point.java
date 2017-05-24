/**
 * @author Alex Cherniak
 *this class represents a Point in a graph - it will come in instead of the generic type Vertex on DirectedGraph
 */

public class Point implements Comparable<Point>
{
	/**************************************************************************************************************************
	 * Instance Variables
	 *************************************************************************************************************************/
	private int x;
	private int y;
	
	/***************************************************************************************************************************
	 * Constructors
	 **************************************************************************************************************************/
	//empty constructor that creates a point at (0,0)
	public Point()
	{
		x=0;
		y=0;
	}
	//constructor that creates a point with given x,y values
	public Point(int x , int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/***************************************************************************************************************************
	 * Methods
	 ***************************************************************************************************************************/
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	
	/*
	 * return a string representation on the Point
	 */
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}

	
	public int compareTo(Point point) 
	{
		if(point instanceof Point)
		{
			Point p = new Point(((Point) point).getX() , ((Point) point).getY());
			if(p.getX() == this.getX() && p.getY() == this.getY())
				return 0; //points are equal
		}
		return 1; //in any case that the points are not equal - return 1
	}
	
}
