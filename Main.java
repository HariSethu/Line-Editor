/*
Kevin Gong & Hariharan Sethumadhavan
Line Editor
*/



import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


class Main {
  public static void main(String[] args) throws IOException, FileNotFoundException{
    //clears console
    System.out.print("\033[H\033[2J");
    System.out.flush();


    //declares all variables that we will use throughout the code
    String userInput = " ";
    String temp = "";
    Scanner input = new Scanner(System.in);
    DoublyLinkedList lines = new DoublyLinkedList();
    ArrayList<String> almamaterlist = new ArrayList<String>();//a clone of the linked list that will be used with file writer
    int currIndex = 0;//will be useful with adding and removing items int the arraylist
    DoublyLinkedNode currNode;//will guide the console with which the currentnode is

    //asks user what file to put in and checks if we have that file available
    System.out.print("Enter file name: ");
    String userFile = input.nextLine();
    while(!userFile.equals("almamater.txt") && !userFile.equals("almamaterHills.txt"))
      {
        System.out.println("Invalid File. Please input a new one: ");
        userFile = input.nextLine();
        
      }

    //declares a scanner of the userFile
    Scanner inFile = new Scanner(new File(userFile));

    //appends a line of the text file to both the linked list and the array list
    while(inFile.hasNext())
    {
      String currLine = inFile.nextLine();
      lines.insertAtTail(currLine);
      almamaterlist.add(currLine);
    }
    //will give a successfully opened message to show everything so far done
    System.out.println("\nOpened '" + userFile + "' succesfully\n");

    //table of all available commands that the user can do
    System.out.println("q: Quit");
    System.out.println("d: Delete current line and print out next");
    System.out.println("f: Displays next line");
    System.out.println("b: displays previous line");
    System.out.println("h: displays first line");      
    System.out.println("t: displays final line");
    System.out.println("i: inserts a line after current line and displays the new line");
    System.out.println("p: print x amount of lines from current file");
    currNode = lines.getHead();
    System.out.println("\n" + currNode.getData());

    //while the user does not want to quit, repeatedly ask them what they want to do
    while(!userInput.equals("q"))
    {
      System.out.print("Please input an option: ");
      userInput = input.nextLine();

      //delete the current line and displays the next
      if(userInput.equals("d"))
      {
        
        if(currNode.getNext() == null)//if there are no available lines to delete will notify user
        {
          System.out.println("There were no available lines to delete");
        }
        else
        {
          lines.deleteNode(currNode.getData());
          currNode = currNode.getNext();
          System.out.println(currNode.getData());
          almamaterlist.remove(currIndex);

        }
        
      }
        //will go to the next line of the almamater
      else if(userInput.equals("f"))
      {
        if(currNode.getNext() == null)//if there is no node after the current one will notify the user
          System.out.println("End of file");
        else
        {
        if(currNode.getNext()!= null)
            currIndex++;
          currNode = currNode.getNext();
          System.out.println("\n" + almamaterlist.get(currIndex));
          
        }
        
        
      }
      //will go to the previous node
      else if(userInput.equals("b"))
      {
        if(currNode.getPrev() == null)//if they are at the beginning will notify the user
        {
          System.out.println("At the beginning");
        }
        else
        {
          currNode = currNode.getPrev();
          if(currIndex != 0)
            currIndex--;
          System.out.println("\n" + almamaterlist.get(currIndex));
        }
        
      }
        //will bring back to the first line of the line
      else if(userInput.equals("h"))
      {
        currNode = lines.getHead();
       System.out.println("\n" + almamaterlist.get(0)); 
        currIndex = 0;
      }
        //will bring back to the last line of the code
      else if(userInput.equals("t"))
      {
        while(currNode.getNext() != null)
          currNode = currNode.getNext();
        System.out.println("\n" + almamaterlist.get(almamaterlist.size()-1));
        currIndex = almamaterlist.size() -1;
      }
        //will insert a new line after the current code
      else if(userInput.equals("i"))
      {
        String newLine = "";
        System.out.print("line that you want inserted: ");
        newLine = input.nextLine();

        lines.insertAfter(currNode, newLine);//linked list method will send and save the new line
        currIndex++;
        almamaterlist.add(currIndex, newLine);//adds too the arraylist
        currNode = currNode.getNext();
        System.out.println("\n" + almamaterlist.get(currIndex));
      }      
        //Will print out x amount of lines from the current line
      else if(userInput.equals("p"))
      {
        int userNum = 0;
        System.out.println("Lines: ");
        userNum = Integer.parseInt(input.nextLine());
        int counter = 0;

        System.out.println("--Beginning Excerpt--" + "\n_____________________");
        if(currNode == null)
        {
          System.out.println("No lines to print");
        }
        else if (currNode.getNext() == null)
        {
          System.out.println(currNode.getData());
        }
        else if(userNum > almamaterlist.size() -1)
        {
          userNum = almamaterlist.size();
          while(counter > userNum)
          {
            System.out.println("\n" + currNode.getData());
            currNode = currNode.getNext();
            counter++;
          }
        }
        else
        {
          while(counter < userNum)
          {
            System.out.println("\n" + currNode.getData());
            currNode = currNode.getNext(); 
            counter++;
          }
            
           
          }
        System.out.println("\n_____________________\n" + "End Excerpt");
        }
        
        
        
        
      

      else if(userInput.equals("q"))
      {
        System.out.print("\nExiting\n");
      }
      else{
        System.out.println("Invalid, please input a correct command");
      }

      
    }


    
    FileWriter writeFile = new FileWriter(userFile);
    
    for (int i = 0; i <almamaterlist.size(); i++)
      {
        if(i != almamaterlist.size()-1 )
          writeFile.write(almamaterlist.get(i) + "\n");
        else
        {
          writeFile.write(almamaterlist.get(i));
        }
      }
    writeFile.close();
  }

}




/*

Enter file name: almamater.txt

Opened 'almamater.txt' succesfully

q: Quit
d: Delete current line and print out next
f: Displays next line
b: displays previous line
h: displays first line
t: displays final line
i: inserts a line after current line and displays the new line
p: print x amount of lines from current file

Hail to thee Parsippany! Hear our voices sing to thee
Please input an option: f

Hail to thee Parsippany! Now and ever true we’ll be
Please input an option: f

Filled with honor faith and pride
Please input an option: i
line that you want inserted: hello dev

hello dev
Please input an option: b

Filled with honor faith and pride
Please input an option: b

Hail to thee Parsippany! Now and ever true we’ll be
Please input an option: f

Filled with honor faith and pride
Please input an option: p
Lines: 
3
--Beginning Excerpt--
_____________________

Filled with honor faith and pride

Red and Gray will untarnished fly.

Red and Gray every held on high

_____________________
End Excerpt
Please input an option: q

Exiting





*/
