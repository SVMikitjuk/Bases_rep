package binTree;

public class NodeLink
{
	int value;
	Link left = new Link(); 
	Link right = new Link();
	
	public NodeLink(int value)
	{
		this.value = value;
	} 
	public int getValue() {
	    return value;
	}
}
