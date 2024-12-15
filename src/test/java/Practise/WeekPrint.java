package Practise;

import org.testng.annotations.Test;

public class WeekPrint {
	
	@Test
	public void weekDayPrint() {
		
		
		for(int i=1;i<=7;i++) {
			
			if(i==1) {
				
				System.out.println("Monday");
			}
			else if(i==2){
				
				System.out.println("Tuesday");
			}
else if(i==3){
				
				System.out.println("Wednesday");
			}
else if(i==4){
	
	System.out.println("Thursday");
}
else if(i==5){
	
	System.out.println("friday");
}
else if(i==6){
	
	System.out.println("saturday");
}
else{
	
	System.out.println("sunday");
}
			
			
			
		}
		
		
	}

}
