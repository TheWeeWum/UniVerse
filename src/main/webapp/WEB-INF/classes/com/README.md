## HOW TO GET RUNNING
First you have to install maven and Tomcat

For maven: Binary.zip <br>
For Tomcat: VERSION 9 is required NOT 10

You'll probably have to set up maven in your system environment
variables.

Then in intellij set up a new run configuration
Scroll down until you see Tomcat and select the local server
not EE.

Then on this code go to the terminal. If you've set up maven
correctly running <br>
mvn -version should tell you the version of maven you have. If this did not work
then you need to run <br>
mvn clean package <br>
this creates the runnable server package. Then go back to the
run configuration you set up and click Deployment then hit the
add button and add the UniVerse:war from the artifacts tab.
Then just run the tomcat configuration and it should work!



## view:
This folder contains the Servlets. 
A servlet is how the JSP's (The html type documents)
interact with the Java code. Basically when the JSP
tries to redirect the user to a new page for example
/profile
The servlet intercepts this request and runs the doGet 
method in the servlet. From here we can run the rest of
the code getting all the necessary data and then
putting it onto the new JSP page, then finally
redirect the user to the profile.jsp page.

doGet:
This method runs when trying to go to this page

doPost:
This method can be run by the JSP itself. For example
in the LoginServlet it is run when the user hits the
login button. 
