package nowcoder;

import java.util.Scanner;

public class FindNum {
	public static void main(String args[])
	{
		int arr[][]  = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = arr.length-1;
		int y = 0;
		boolean flag = false;
		while(x>=0&&y<arr[0].length)
		{
			if(n<arr[x][y])
			x--;
			else if(n>arr[x][y])
				y++;
			else
			{
				flag = true;
				break;
			}
		}
		if(flag == true)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}
}
