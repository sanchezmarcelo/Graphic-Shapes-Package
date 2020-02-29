import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.BinaryOperator;


public class Test {
	
  public static int addemup(int a, int b) {
	return a + b;
  }
	
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9); 
    System.out.println("original list of numbers : " + numbers); 

    // map example
    List<Integer> squares = numbers.stream().map(x -> x*x).collect(Collectors.toList()); 
    System.out.println("squared list of integers using map: " + squares); 

    // filter examples
    List<Integer> evens = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    System.out.println("list of even integers using filter: " + evens);

    List<String> strings = Arrays.asList("one", "two", "three", "four");
    String longString = strings.stream().reduce("The string: ", (a, b) -> a + b);
    System.out.println("concatenation of list of strings using reduce: " + longString);

    // reduce example
    int total = numbers.stream().reduce(0, (a, b) -> a + b);
    System.out.println("sum of list of integers using reduce: " + total);

    // example of naming a lambda expression
    BinaryOperator<Integer> add = (a, b) -> a + b;
    BinaryOperator<Integer> add2 = (a, b) -> addemup(a, b);  //function that returns function
    total = numbers.stream().reduce(0, add2);
    System.out.println("sum of list of integers using reduce: " + total);

    // example of using functions defined in a class as the arguments to
    // higher-order functions
    // the function is referenced using ::
    SomeFun sf = new SomeFun();
    total = numbers.stream().reduce(0, sf::plus);
    System.out.println("sum of list of integers using reduce: " + total);
    int product = numbers.stream().reduce(1, sf::times);
    System.out.println("product of list of integers using reduce: " + product);
  }

}

