package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
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
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }


}