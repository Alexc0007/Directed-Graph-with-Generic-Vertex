/**
 * @author Alex Cherniak
 *this class represents an exception that is thrown when an edge is already exists on DirectedGrapg
 */
public class EdgeAlreadyInGraphException extends Exception
{
	public EdgeAlreadyInGraphException(String message)
	{
		super(message);
	}
}
