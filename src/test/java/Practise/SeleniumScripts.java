package Practise;

public class SeleniumScripts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			
		int a[][]= {{1,2,3,4,5,6},{2,3,4,5,6}};
		
		System.out.println("row ="+a.length);
		System.out.println("column ="+a[0].length);
		
			
		for(int i=0;i<a.length;i++) {
			
			
			for(int j=0;j<a[0].length;j++) {
				
				
				System.out.print(a[i][j]+ " ");
				
			}
			System.out.println();
			
			
			
			
	
			
			
			
		}
		}
		catch(Exception e) {
			
			
			System.out.println(e);
		}
		
	
		
	

	}

}
