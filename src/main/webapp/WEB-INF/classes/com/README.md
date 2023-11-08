
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
