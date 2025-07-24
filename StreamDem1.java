package com.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream; 
  
class StreamDem1 
{ 
  public static void main(String args[]) 
  { 
  
    // create a list of integers 
    List<Integer> number = Arrays.asList(2,3,4,5); 
  
    List<Integer> input=new ArrayList<>();
    input.add(1);
    input.add(10);
    input.add(5);
    input.add(20);
    List<Integer> evenList = input.stream().filter((x) -> x%2==0).collect(Collectors.toList());
    System.out.println("even numbers ="+evenList);
    
    long  evencount = input.stream().filter(x -> x%2==0).count();
    System.out.println("No. of even numbers="+evencount);
    
    // demonstration of map method 
    List<Integer> square = number.stream().map(x -> x*x).
                          collect(Collectors.toList()); 
   // System.out.println(square);
    
   /* Stream<Integer> stream= number.stream();
    Stream<Integer> sq=stream.map(x->x*x);
    List<Integer> res=sq.collect(Collectors.toList());*/
    
  
    // create a list of String 
    List<String> names = 
                Arrays.asList("Reflection","Collection","Stream"); 
  
    // demonstration of filter method 
		List<String> result = names.stream().filter(s -> s.startsWith("S")). 
                          collect(Collectors.toList()); 
    System.out.println(result); 
  
    // demonstration of sorted method 
    List<String> show = 
            names.stream().sorted().collect(Collectors.toList()); 
    System.out.println(show); 
    
    // create a list of integers 
    List<Integer> numbers = Arrays.asList(2,3,4,5,2); 
  
    // collect method returns a set 
    Set<Integer> squareSet = 
         numbers.stream().map(x->x*x).collect(Collectors.toSet()); 
    System.out.println(squareSet); 
  
    // demonstration of forEach method 
    number.stream().map(x->x*x).forEach(y->System.out.println(y)); 
  
    
  } 
} 



