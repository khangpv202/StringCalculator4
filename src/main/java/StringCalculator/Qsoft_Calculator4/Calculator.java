package StringCalculator.Qsoft_Calculator4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public int add(String string) {
		// TODO Auto-generated method stub
		if(string.isEmpty())
			return 0;
		else{
			if(string.contains("//")){
				String regex = "";
				if(string.contains("[")){
					Pattern p = Pattern.compile("\\d");
					Matcher m = p.matcher(string);
					m.find();
					regex = string.substring(3, m.start()-2);
					string = string.substring(m.start(),string.length());
					string = string.replace(regex, ",");
				}else{
					regex = ""+string.charAt(2);
					Pattern p = Pattern.compile("\\d");
					Matcher m = p.matcher(string);
					m.find();
					string = string.substring(m.start(),string.length());
				}
			}
			return sum(string);
		}
	}
	//sum of number
	public int sum(String string){
		int result = 0;
		String regex = "[,;\n]";
		String []tmp = string.split(regex);
		for(String i:tmp){
			if(Integer.parseInt(i)<0) throw new IllegalArgumentException ("negatives not allowed");
			if(Integer.parseInt(i)<=1000)
				result+=Integer.parseInt(i);
		}
		return result;
	}

}
