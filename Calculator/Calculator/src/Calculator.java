import java.awt.event.ActionEvent;

public class Calculator {
	
	String result;
	String command;
	public Calculator(String re, String cmd) {
		result = re;
		command = cmd;
	}
	//add"+"
	public String opAdd(String re) {
		double num1 = Double.parseDouble(result);
		double num2 = Double.parseDouble(command);
		num1 += num2;
		result = "" + num1;
		return result;
	}
	//subtract"-"
	public String opSubtract(String re) {
		double num1 = Double.parseDouble(result);
		double num2 = Double.parseDouble(command);
		num1 -= num2;
		result = "" + num1;
		return result;
	}
	//multiply"*"
	public String opMultiply(String re) {
		double num1 = Double.parseDouble(result);
		double num2 = Double.parseDouble(command);
		num1 *= num2;
		result = "" + num1;
		return result;
	}
	//divide"/"
	public String opDivide(String re) {
		double num1 = Double.parseDouble(result);
		double num2 = Double.parseDouble(command);
		num1 /= num2;
		result = "" + num1;
		return result;
	}
	public String opEquals() {
		return result;
	}
}
