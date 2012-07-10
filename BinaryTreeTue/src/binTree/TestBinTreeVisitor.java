package binTree;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestBinTreeVisitor
{
	public BinTreeVisitor tree;
	
	public void Init()
	{
		tree = new BinTreeVisitor();
		tree.add(5);
		tree.add(3);
		tree.add(10);
		tree.add(4);
	}
	
	@Test
	public void add()
	{
		Init();
		tree.add(6);
		String expected = tree.getTreeString();
		String actual = " 3 4 5 6 10";
		assertEquals(expected, actual);
	}

	@Test
	public void del()
	{
		Init();
		tree.remove(4);
		String expected = tree.getTreeString();
		String actual = " 3 5 10";
		assertEquals(expected, actual);
	}
	
	@Test
	
	public void find()
	{
		Init();
		int expected = tree.find(3);
		int actual = 3;
		assertEquals(expected, actual);
	}

	@Test
	public void MaxWidth()
	{
		Init();
		int expected = tree.getMaxWidth();
		int actual = 2;
		assertEquals(expected, actual);
	}
	@Test
	public void size()
	{
		Init();
		int expected = tree.getCount();
		int actual = 4;
		assertEquals(expected, actual);
	}
	@Test
	public void countList()
	{
		Init();
		int expected = tree.getCountList();
		int actual = 2;
		assertEquals(expected, actual);
	}
	@Test
	public void countNode()
	{
		Init();
		int expected = tree.getCountNode();
		int actual = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void printInOrder()
	{
		Init();
		String expected = tree.getTreeString();
		String actual = " 3 4 5 10";
		assertEquals(expected, actual);
	}
	
	@Test
	public void height()
	{
		Init();
		int expected = tree.height();
		int actual = 3;
		assertEquals(expected, actual);
	}
	@Test
	public void reverse()
	{
		Init();
		tree.reverse();
		String expected = tree.getTreeString();
		String actual = " 10 5 4 3";
		assertEquals(expected, actual);
	}
	
}
