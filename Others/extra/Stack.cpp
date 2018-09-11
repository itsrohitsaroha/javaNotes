//Program to implement : Stack

#include<iostream>
#define SIZE 10
using namespace std;

class Stack
{
    int data[SIZE];
    int top;
public:
    Stack();
    void push(int val);
    int pop();
    bool isFull()
    {
        return top == SIZE -1;
    }
    inline bool isEmpty();
    void display();
};

Stack :: Stack()
{
    top = -1;
}

void Stack :: push(int val)
{
    if(! isFull())
    {
        top++;
        data[top] = val;
    }
    else
        cout<<"\n Stack Overflow ";
}

int Stack :: pop()
{
    int val = 0;
    if(!isEmpty())
    {
        val = data[top];
        top--;
    }
    else
        cout<<"\n Stack Underflow ";
    return val;
}

void Stack :: display()
{
    int i;
    for(i = top; i>=0; i--)
        cout<<"\n"<<data[i];
}

bool Stack :: isEmpty()
{
    return top == -1;
}



void menu()
{
    Stack s;
    int val;
    int ch;
    do
    {
        cout<<"\n 1. push ";
        cout<<"\n 2. pop ";
        cout<<"\n 3. display ";
        cout<<"\n 4. exit ";
        cout<<"\n Enter a choice ";
        cin>>ch;

        switch(ch)
        {
        case 1:
            cout<<"\n Enter a value to push ";
            cin>>val;
            s.push(val);
            break;
        case 2:
            val = s.pop();
            cout<<"\n"<<val <<" removed";
            break;
        case 3:
            s.display();
            break;
        case 4:
            break;
        default :
            cout<<"\n Wrong Choice ";
            break;
        }//switch
    }while(ch != 4);
}

int main()
{
    menu();
    return 0;
}
