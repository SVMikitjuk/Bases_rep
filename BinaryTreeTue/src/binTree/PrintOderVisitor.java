package binTree;

public class PrintOderVisitor implements iVisitor
{
	private String TreeString = "";
	
	@Override
	public void Visit(Node node)
	{
		TreeString += " " + node.getValue(); 
	}

	public String getTreeString()
	{
		return TreeString;
	}
}
