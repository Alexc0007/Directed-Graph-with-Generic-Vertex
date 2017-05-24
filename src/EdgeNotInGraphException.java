/**
 * @author Alex Cherniak
 *this class represents an exception that is thrown when an edge is missing(but should be present) on DirectedGrapg
 */
public class EdgeNotInGraphException extends Exception
{
	public EdgeNotInGraphException(String message)
	{
		super(message);
	}
}
