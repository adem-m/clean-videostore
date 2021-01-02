

# clean-videostore

## Author
MRIZAK Adem  
3AL1 - ESGI

## Statistics
Different code smells detected : **7**  
Different refactoring techniques used : **8**

## Description

#### Movie.java
|CODE SMELLS|REFACTORING TECHNIQUES|BENEFITS|    
|--|--|--|    
|Dead code|Delete unused code|Reduced code size|    
|Primitive obsession|Replace data value with enumeration|More readable code|    
|Non-final attributes|Make them final|Avoid future errors|

#### Rental.java
|CODE SMELLS|REFACTORING TECHNIQUES|BENEFITS|    
|--|--|--|    
|Non-final attributes|Make them final|Avoid future errors|  
|Dead code|Delete unused code|Reduced code size|

#### Customer.java
|CODE SMELLS|REFACTORING TECHNIQUES|BENEFITS|    
|--|--|--|    
|Non-final attributes|Make them final|Avoid future errors|  
|Bad type|Change type|Less code for the same result|  
|Primitive obsession|Replace data value with object|More maintainable code|  
|Bad variable name|Change variable name|Clearer code|  
|Long method|Extract method|More understandable and maintainable code|  
|Large class|Extract class|Shorter classes, more readable code|

## Additional information
Customer class has been split in 3 subclasses:

- Customer
- Statement
- AmountComputer

Each class has its test class.
The rental vector has been changed to a rental list.
I removed the original test class and divided its methods in several classes.
I tried to make methods as short as possible. The biggest one is 17 lines long.
I used STATIC_VARIABLES instead of "magic numbers" to make the code more readable.
I also tried to make the code maintainable and evolutive.
