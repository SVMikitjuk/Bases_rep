package binTree;

public class CountVisitor implements iVisitor
{
	private int count = 0;
	
	@Override
	public void Visit(Node node)
	{
		++count;
	}

	public int getCount()
	{
		return count;
	}
}
