#README

**FarmChat version 1.0 04/18/15**   
_java version "1.8.0_25"_   
_Java(TM) SE Runtime Environment (build 1.8.0_25-b17)_   
_Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)_   

FarmChat is an instant messenger client application. It allows multiple users
to communicate over a network via text and farm animal sounds. It has been
developed as a final project in CS2410 - Introduction to Graphical User Interfaces
in Java - at Utah State University.

FarmChat is designed to connect to a server application
(found here: https://github.com/denvaar/ChatServer).

**AUTHORS**

Bugs, questions, or comments? Please contact:

Denver Smith denverpsmith@gmail.com   
Chapter Doh  chapterdoh123@gmail.com

**THANKS**

Thanks to these people and resources who have provided help and feedback
for this project.

Dr. Young Woo Kwon   
People who answer questions on StackOverflow.com   
DeveloperWorks tutorial http://www.cn-java.com/download/data/book/socket_chat.pdf   

**INSTALL**

You may choose to compile this package yourself, or to run the executable .jar file.

1.  Clone or download this repository (https://github.com/denvaar/ChatClient).
2.  Run the .jar file. (java -jar FarmChat.jar) or 
    compile and run this package. (javac ChatClient/*.java && java ChatClient/Client).   

If you would like to create a .jar file after compilation, you can run this command:   
jar -cfe FarmChat.jar ChatClient.Client ChatClient/   


**BUGS**

-   Sometimes the client throws a nullpointer exception when starting up. Seems
    to be related to the initialization of components. This causes the chat output
    text area's scroll pane to function improperly.   
-   If an initial connection is not established, and the user clicks on the X button
    of the Client window, nothing happens.   


