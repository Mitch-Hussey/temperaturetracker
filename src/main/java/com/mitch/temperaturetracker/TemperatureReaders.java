package com.mitch.temperaturetracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureReaders {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		dataInput();
	}
	
	public static void dataInput() throws IOException, InterruptedException {
		
		//while(true){
			//Thread.sleep(1000); //sleep in milliseconds
		
			Runtime rt = Runtime.getRuntime();
			//Process getDataProcess = rt.exec("cat w1_slave");
			Process getDataProcess = rt.exec("ipconfig");
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(getDataProcess.getInputStream()));
		
			String line =null;
			String output = "";
			while ((line = reader.readLine()) != null){
				output = output + line;
			}
			
			String input = "2d 00 4b 46 ff ff 08 10 fe : crc=fe YES \n2d 00 4b 46 ff ff 08 10 fe t=22250";
			
			String[] arraySplitOutput = input.split("\n"); //change to "output"
			
			String tempValue = arraySplitOutput[1].substring(arraySplitOutput[1].lastIndexOf("=")+1);
			
			String finalValue = tempValue.substring(0, 2) + "." + tempValue.substring(2);
			
			Double temp = Double.parseDouble(finalValue);		
			
			System.out.println(temp);
			
			reader.close();
		}			
	//}
	
}
