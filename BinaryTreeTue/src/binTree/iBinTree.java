package binTree;

interface iBinTree
{
	void add(int value);
	public void remove(int val);
	
	public String printInOrder();
	
	int height();
	int getMaxWidth();

	int find(int val);
	void reverse();
	
	int getCountNode();
	int getCountList();
	int getCount();
}
