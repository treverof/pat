package nowcoder;

import java.util.Scanner;

public class ArrayDiff {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
				if(a[i]>max)
					max = a[i];
				if(a[i]<min)
					min = a[i];
			}
			
						
			int arr[] = new int[max-min+1];
			int index = 0;
			int count = 0;
			for(int i=0;i<n;i++)
			{
				arr[a[i]-min] ++;
			}
			
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]==0)
					count++;
				else{
					if(index<count)
						index = count;
					count = 0;
				}
			}
			System.out.println(index+1);
		}
	}
}
