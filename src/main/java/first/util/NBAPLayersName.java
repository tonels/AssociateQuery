package first.util;

import java.util.Random;

public class NBAPLayersName {

	public static String getName() {
		
		Random random = new Random(System.currentTimeMillis());
		
		/*名字*/
		String[] firstName = { "Allen ", "Anderson ", "Anthony ", "Arenas ", "Ariza ", "Artest ", "Baker ", "Barbosa ", "Bass ", "Battier ", "Bell ", "Bosh ", "Brand ", "Brezec ", "Brown ", "Bryant ", "Butler ", "Paul ",
				"Bynum ", "Carter ", "Chandler ", "Collins ", "Crawford ", "George ", "Ginobili ", "Green ", "Haywood ", "Howard ", "Kidd ", "Martin ", "Miller ", "Murray ", "Nash ", "O'Neal ", "Nowitzki ", "Pierce ",
				"Curry ", "Davis ", "Dixon ", "Duncan ", "Julius ","Ewing ", "Fisher ", "Garnett ", "Gasol ", "Jackson ", "James ", "Johnson ", "Kaman ","Rose ","Swift ", "Thomas ", "Wade ", "Williams ", "Yao ", "Brown ", "O'Neal ", "Davis ", "Carter "};
		
		/* 姓氏 */
		String[] secondName = { "Michael", "Louis", "Erving", "Lucas", "Alan", "Ray", "Carmelo", "Carlos", "Brandon", "Tony", "Charlie", "Steve", "Dan", "Tim", "John", "Jermaine",
				"Kevin", "Bill", "Scottie", "Karl", "Hakeem", "Earvin", "Kobe", "Marcus", "Chris", "Vince", "Kelvin", "Tyson", "Jamal", "Baron", "Tim", "Andrew", "James ", "Dwyane", "Chris", "Dirk",
				"Wilt", "Moses", "Charles", "Isiah", "Jerry", "Oscar", "Pau", };
		
		int index1 = random.nextInt(firstName.length - 1);
		String first = firstName[index1]; // 获得一个随机的名字
		
		int index2 = random.nextInt(secondName.length - 1);
		String second = secondName[index2]; // 获得一个随机的姓氏
		
		String name = first + second;
		
		return name;
	}
}