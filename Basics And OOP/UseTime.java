/*
Program to study : Encapsultation, class, object and this reference.
Read the note below.
Refer : class, object and this.png
*/

class Time//entity
{
 //data members (non static)
 int h, m, s;

 //methods
 void setTime(int a, int b, int c)
 //void setTime(Time this, int a, int b, int c)
 {
  int h;//local variable takes the same name as of a member variable, causes the use to map with the local and shadowing of the member.

  this.h = a;//to overcome shadowing
  m = b;//this.m = b;
  s = c;//this.s = c;
 }

 void displayTime()
 {
  System.out.println(h +":" + m + ":" + s);
 }
}//Time

class UseTime
{
 public static void main(String args[])
 {
  //Use a class
  Time t = new Time(); 
  Time t1 = new Time();   

  t.setTime(1,2,3); //setTime(t,1,2,3);

  t.displayTime();// displayTime(t);
 }//main
}//UseTime


/*
Java is an Object Oriented Programming
language.
Applications that are developed using OOP
paradigm implement following concepts:
* Encapsulation
* Polymorphim
* Inheritance
* Abstraction

Encapsulation
----------------
Encapsulation is binding operations (code) and
attributes (data) of an entity into one unit.

The unit, so formed is termed as a class.

class
------
A class is a unit that combines methods (operations)
and data (attributes) of an entity.

A class forms a secondary datatype in Java.
It (class) may be used in 3 ways:
1) Instantation
2) Inhertiance
3) Through static members

Instantiation
----------------
An object is an instance of a class.
It can store and process data.

Its storage ability is defined by the non static
data members of the class.

Its processing ability is defined by the non
static methods of the class.

Call to non static methods
--------------------------
For invokation, a non static method requires
a caller object.

By compilation the reference to caller object
is passed as a hidden parameter to the method.

Even (by compilation) the non static method
signature is redesigned to receive reference
to the caller object.

Ahead the reference to the caller object is
implicitly used to access other members.

this
-------
this is a system defined formal parameter for
non static methods of the class.
It is a reference of type current class.
It is initialized by the caller object of the method.
It is used to access other members.
It is a constant (final) reference, cannot be made to refer to other objects.

*/