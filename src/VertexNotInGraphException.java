/**
 * @author Alex Cherniak
 *this class represents an exception that is thrown when a vertex is missing on DirectedGrapg
 */
public class VertexNotInGraphException extends Exception
{
	public VertexNotInGraphException(String message)
	{
		super(message);
	}
}
