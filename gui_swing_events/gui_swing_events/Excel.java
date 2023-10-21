/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Areaf and Maria
 */

package gui_swing_events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Creating an Excel class to perform calculations on a list of numbers.
public class Excel {

    private ArrayList<Double> numbers;
    
    // Constructor that accepts a list of numbers and sets it as an instance variable.
    public Excel(ArrayList<Double> numbers){
        // Initialize the 'numbers' list with the provided list.
        this.numbers = numbers;
    }
    // Constructor that accepts a string of space-separated numbers and parses them into a list of doubles.
    public Excel(String numberString){
        // Initialize 'numbers' list by splitting the input string and converting each element to a double.
        this.numbers = new ArrayList<>();
        
        String[] strNumArray = numberString.split(" ");
        
        List<String> strNumList = Arrays.asList(strNumArray);
        
        ArrayList<String> strNumArrayList = new ArrayList<>(strNumList);
        
        strNumArrayList.forEach(strNum ->{
            
            try{
                
                double num = Double.parseDouble(strNum.trim());
                this.numbers.add(num);
                
            }catch(Exception e){
                System.out.println("error" + e);
            }
        });
    }
    
    // Method to calculate the total sum of numbers in the 'numbers' list.
    public double findTotal(){ 
        // Initialize a variable to hold the sum and iterate through 'numbers' to calculate the total.
        double total = 0;
        
        for(double num: numbers){
            total += num;
        }
        return total;
    }
        
    // Method to calculate the average of the numbers in the 'numbers' list.
    public double findAvg(){ 
        // Check for an empty list to avoid division by zero, then calculate the average.
        if(numbers.isEmpty()){
            return 0; 
        }
        
        double avg = 0;
        
        avg = findTotal() / numbers.size();
        
        return avg;
    }
    
    // Method to find the maximum value in the 'numbers' list.
    public double findMax(){ 
        // Check for an empty list, then find the maximum value.
        if(numbers.isEmpty()){
            return 0;
        }
        
        double max = numbers.get(0);
        for(double num : numbers){
            if(num > max){
                max = num;
            }
        }
        
        return max;
    }
    // Method to find the minimum value in the 'numbers' list.
    public double findMin(){ 
        // Check for an empty list, then find the minimum value.
        if(numbers.isEmpty()){
            return 0; // handle empty list
        }
        
        double min = numbers.get(0);
        
        for(double num: numbers ){
            if(num < min){
                min = num;
            }
        }
        
        return min;
    }
}
