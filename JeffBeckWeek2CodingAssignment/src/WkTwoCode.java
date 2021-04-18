
public class WkTwoCode {

	public static void main(String[] args) {
		//2.) Creating and assigning Boolean variables
		
		boolean isHotOutside = false;
		boolean isWeekday = true;
		boolean hasMoneyInPocket = false;
						
		//3.) Creating and assigning non-Boolean data type variables
		
		double costOfMilk = 2.17;
		double moneyInWallet = 53.28;
		int thirstLevel = 8; //how thirsty you are on a scale of 1-10
						
		//4.)  Creating variables using the Boolean variables and data types listed previously using the following criteria:
				//a.	shouldByIcecream – this should be true if it is hot outside and there is money in your pocket
				//b.	willGoSwimming – this should be true if it is hot outside and it is not a weekday
				//c.	isAGoodDay – this should be true if it is hot outside, there is money in your pocket, and it is not a weekday
				//d.	willBuyMilk – this should be true if it is hot outside, and thirstLevel is greater than or equal to 3, and moneyInWallet is greater than or equal to 2 times the cost of milk.
		
		boolean shouldByIcecream = isHotOutside && hasMoneyInPocket;	
		boolean willGoSwimming = isHotOutside && isWeekday;
		boolean isAGoodDay = isHotOutside && hasMoneyInPocket && isWeekday;
		boolean willBuyMilk = isHotOutside && thirstLevel >=3 && moneyInWallet >=(2*costOfMilk );
		
		System.out.println(shouldByIcecream);
		System.out.println(willGoSwimming);
		System.out.println(isAGoodDay);
		System.out.println(willBuyMilk);

	}

}
