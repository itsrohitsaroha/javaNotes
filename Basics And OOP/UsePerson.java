/*
Program to study the Object Creation Process
Refer the note below
See the diagram : Person.png
*/

class Person
{
 String name ;
 int age = 99;

 {
  System.out.println("NSIB1");
  //age = 0;
  name = "baby";
 }

 Person()//default constructor
 {
   System.out.println("Person()");
   name = "Anil";//default
   age += 5;//default

 }

 Person(String s, int a)//Parameterized constructor
 {
   System.out.println("Person(String, int)");
   name = s;//parameter
   age += a;//parameter

 }

 void display()
 {
  System.out.println(" [ " + name + ", " + age + " ] ");
 }

 {
  System.out.println("NSIB2");
  name = name.toUpperCase();
 }
}//person


class UsePerson
{
 public static void main(String args[])
 {
   System.out.println("--------------");
   Person p = new Person();
   System.out.println("--------------");
   Person p1 = new Person("Manoj", 11);
   System.out.println("--------------");

   p.display();
   p1.display();
 }
}

/*
In Java, object creation is a three step process.

1) Allocation of memory .
An object is a dynamically allocated as a 
composite block in heap memory. 
It is formed by a collection of non static 
data members of the class.

2) Execution of a non static initializer block.

Non Static Initializer Block
---------------------------
A block of code that belongs to the class.
It has no signature.
It is implicitly invoked for every object created.
It is used for object member initialization.

FYI
A class may have multiple non static initializer
blocks and all execute on creation of an object.
The order of their execution is the order of
their definition inside the class. The one defined
above would execute first.

3) Execution of constructor.

Constructor
-------------
A constructor is a special method of the class.
It has the same name as of the class and no return type specification.
It is implicitly invoked for every object created.
It is used for object member initialization.

Constructor Overloading is defining multiple 
constructors for the class, with unique set 
of parameters each.

FYI
-------
When a class doesnt define any non static
initializer block and/or any constructor then
compiler auto generates the missing one with
empty definition.
This is because their execution is a part of
object creation process.

*/