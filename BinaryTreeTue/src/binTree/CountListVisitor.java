package binTree;

public class CountListVisitor implements iVisitor
{
	private int count = 0;
	
	@Override
	public void Visit(Node node)
	{
		if (node.left == null && node.right == null)
		{
			++count;
		}
		
	}

	public int getCount()
	{
		return count;
	}
}
