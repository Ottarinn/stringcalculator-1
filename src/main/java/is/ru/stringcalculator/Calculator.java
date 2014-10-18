package is.ru.stringcalculator;
import java.util.ArrayList;
public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.startsWith("//")){
			return sum(splitCustomDelimiter(text));
		}
		else if (text.contains(",") && text.contains("\n")){
			return sum(splitNumbersonnewlineorcommas(text));
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("\n")){
			return sum(splitNumbersonnewline(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}

	private static String[] splitNumbersonnewline(String numbers){
	    return numbers.split("\n");
	}

	private static String[] splitNumbersonnewlineorcommas(String numbers){
	    return numbers.split("\n|\\,");
	}

	private static String[] splitCustomDelimiter(String numbers){
		String temp = numbers.substring(numbers.indexOf('\n') + 1, numbers.length());
		String newTemp = temp.replaceAll("[^0-9&^-]+", ",");
		return newTemp.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;

 	    ArrayList<String> ottar = new ArrayList<String>();
        for(String number : numbers)
	        {
	        	if (toInt(number) < 0)
		        	{
		        		ottar.add(number);
		        	}
	        	else if (toInt(number) > 0 && toInt(number) < 1000)
	        		{
	        			total += toInt(number);
	        		}
	        }		
	        if(!ottar.isEmpty())
		        {
					String minustolur = "";
					for(String neg : ottar) 
					{
						minustolur += neg + ",";
					}
					throw new RuntimeException("Negatives not allowed: " + minustolur);
				}
		return total;
    }


}