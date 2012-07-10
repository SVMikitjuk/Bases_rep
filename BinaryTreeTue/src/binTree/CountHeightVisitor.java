package binTree;

public class CountHeightVisitor implements iVisitor
{
	private int count = 0;
	
	@Override
	public void Visit(Node node)
	{

	}

	public int getCount()
	{
		return count;
	}

	@Override
	public void Visit(Node node, String str)
	{
		
	}
}
