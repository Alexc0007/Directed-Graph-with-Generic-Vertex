/**
 * @author Alex Cherniak
 *this class represents an exception that is thrown when a vertex already exists on DirectedGrapg
 */
public class VertexAlreadyInGraphException extends Exception
{
	public VertexAlreadyInGraphException(String message)
	{
		super(message);
	}
}
