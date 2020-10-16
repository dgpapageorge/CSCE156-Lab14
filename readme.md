# Computer Science II
## Lab 14.0 - Stacks & Queues

An introduction stack and queue data structures.

This is a lab used in Computer Science II (CSCE 156, CSCE 156H) in the 
[Department of Computer Science & Engineering](https://cse.unl.edu) at the 
[University of Nebraska-Lincoln](https://unl.edu).

## Overview

### Resources

Prior to lab you should read/review the following resources.

1.  Review this laboratory handout prior to lab.

2.  Review the course material on stacks and queues

### Lab Objectives & Topics

Following the lab, you should be able to:

-   Understand how stacks and queues operate and how to use them

-   Know how to implement stacks and queues using a linked list data
    structure

-   Know how to use stack and queue data structures in an application

### Peer Programming Pair-Up

To encourage collaboration and a team environment, labs will be
structured in a *pair programming* setup.  At the start of
each lab, you may be randomly paired up with another student by
a lab instructor.  One of you will be designated the *driver* 
and the other the *navigator*.  

The navigator will be responsible for reading the instructions 
and telling the driver what is to be done.  The driver will be 
in charge of the keyboard and workstation.  Both driver and 
navigator are responsible for suggesting fixes and solutions 
*together*.  Neither the navigator nor the driver is "in charge."  
Beyond your immediate pairing, you are encouraged to help and 
interact and with other pairs in the lab.

Each week you should try to alternate: if you were a driver 
last week, be a navigator next, etc.  Resolve any issues (you 
were both drivers last week) within your pair.  Ask the lab 
instructor to resolve issues only when you cannot come to a 
consensus.  

Because of the peer programming setup of labs, it is absolutely 
essential that you complete any pre-lab activities and familiarize
yourself with the handouts prior to coming to lab.  Failure to do
so will negatively impact your ability to collaborate and work with 
others which may mean that you will not be able to complete the
lab.  

## 1. Getting Started

Clone this project code for this lab from GitHub in Eclipse using the
URL: <https://github.com/cbourke/CSCE156-Lab14>. Refer to Lab 1.0 for
instructions on how to clone a project from GitHub.

## 2. Stacks & Queues

### 2.1 Stacks & Postfix Notation

A *stack* is a LIFO (Last-In First-Out) data structure.  The two basic
operations are *push*: adding an element to the "top" of the stack and
*pop*: removing the element at the top of the stack.  Stacks, like many 
data structures, can be implemented using other data structures.  
In this lab, your stack implementation will utilize Java's `LinkedList` 
data structure.  You will use the linked list's methods to implement
the push, pop and other operations.  You will then use your stack
implementation to solve a problem involving *postfix notation*.

Postfix notation (also known as Reverse Polish Notation) is a
parenthesis-free way of writing arithmetic expressions where the
operator symbol is placed *after* its two operands. For example, 
the expression `(3 + 2)` would be written `3 2 +`. The result 
of this value multiplied by 4 could be written `3 2 + 4 *`. 
As another example, the expression `((3 + 2) * 4) / (5 - 1)` 
would be written in postfix notation as: `3 2 + 4 * 5 1 - /`.
Manually computing this would done as follows

```text
    3 2 + 4 * 5 1 - /
=>  5 4 * 5 1 - /
=>  20 5 1 - /
=>  20 4 /
=>  5
```

The advantage of postfix notation is that no precedence rules are
necessary as the order of operation is completely unambiguous. Many
calculators, mathematical tools, and other systems utilize this
notation. Evaluation of postfix expressions can be done using a stack
data structure.

### 2.2 Queues

Queue data structures, in contrast to Stacks, are a FIFO (First-In
First-Out) data structure. The basic operations are *enqueue*: add
an element to the end of the queue and *dequeue*: remove an element
from the front of the queue. Like stacks, they can easily be implemented
using a linked list. One application of queues is as a data buffer. 
In many applications, processing a stream of data is resource intensive. 
The data stream may be faster than an application can process it. 
Incoming data can be temporarily stored in a buffer (a queue) so that
it is not lost. The application then reads from the buffer and processes 
the data at its own rate, independent of the speed of the data stream.

## 3. Activities 

### 3.1 Postfix Math

In this activity you will implement a stack and use it to evaluate
a postfix expression.  Much of the code to read in the expression 
has been provided as well as some helper methods that you can use.

1.  Implement the four methods in the `Stack` class (which uses a
    `LinkedList` class).

2.  You should test your implementation by creating a small `main()`
    method and push/pop elements off your stack to see if you get 
    the expected behavior.

3.  Once your stack is implemented, modify the `evaluateExpression()` 
    method in the `PostfixEvaluator` class as described in the source code. 
    Test it with the following expressions to make sure it works.    
    
    | Expression          | Result |
    |---------------------|--------|
    | `3 4 + 2 * 7 /`     | `2`    |
    | `5 7 + 6 2 - *`     | `48`   |
    | `4 2 3 5 1 - + * +` | `18`   |
    | `4 5 7 2 + - *`     | `-16`  |
    
### 3.2 Queue

In this activity, you will implement and use a queue that acts as a data
buffer for a plain text file. The application reads an entire text file
and stores lines into your queue for later processing. The "processing" in
this case is a human user that reads the text file page-by-page (by
pressing enter). In addition, the text file is not well-formatted for
human readers as it contains very long lines. The application processes
these lines and displays them page-by-page with a predefined limit on
the number of characters per line so that it is more human-user
friendly.  

1.  Implement the four methods in the `Queue` class in terms of
    the `LinkedList`'s methods

2.  As before, you should test your implementation by creating a small
    `main()` method and enqueue/dequeue elements from your to see if you get the
    expected behavior.

3.  Once your queue is implemented, modify the class as specified in the
    source code to use your queue to process the text file.

## 3.3 JSON Validation

JSON (JavaScript Object Notation) is a data exchange format that uses 
key-value pairs and opening/closing curly brackets to indicate
sub-objects. A small example:

```json
{
  "employees": [
    { 
      "firstName":"John", 
      "lastName":"Doe" 
    }, 
    { 
      "firstName":"Anna", 
      "lastName":"Smith"
    }, 
    { 
      "firstName":"Peter", 
      "lastName":"Jones" 
    }
  ],
  "deptIds": [1, 5, 4, 21],
  "department": "sales",
  "budget": 120000.00
}
```

JSON validation involves determining if a particular string represents a
valid JSON formatted string. While not too complicated, full validation
does require several complex rules that need to be checked. For this
exercise, you will design and implement a JSON validator that will
simply check that the opening and closing curly brackets, `{ }` and square
brackets `[ ]` are *well-balanced*.  Brackets are well-balanced if for every 
opening bracket there is a corresponding closing bracket of the same 
type.  Also, brackets of different types must not overlap. For example, 
`{ [ } ]` would be invalid.

1.  Open the `JsonValidator` class.  Starter code has been provided that
    loads the contents of a json file.

2.  Determine what kind of data structure would be the most appropriate 
    to solve this problem and implement the `isValidJSON()` method.

3.  Test your program on the 5 JSON data files in the `data` directory.

## 4. Testing, Submitting & Grading

* Test your programs using the provided JUnit test suite(s).  Fix any
errors and completely debug your programs.
* Submit the following files through webhandin:
  * `TODO.java`
* Run the grader and verify the output to complete your lab.

## Advanced Activity (optional)

1. Java provides a `Deque` or *double ended queue* interface.  A deque 
   can be used for *either* LIFO or FIFO ordering.  Read the documentation:
   <https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Deque.html>
   and change all of your code to use Java's `Deque` instead of your
   `Stack` or `Queue` classes.

2.  Add support to your JSON validator program to aslo check that
    double-quote characters (used to denote strings) are well balanced.
    Note that inside a string square and curly brackets need *not* be
    balanced (and should be ignored). Moreover, double quotes may appear
    inside of strings as long as they are escaped: `\"`


