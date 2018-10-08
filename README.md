# SOAP-Service
SOAP Web Service using java with eclipse

Steps to create wsdl file
-------------------------
1. Right click on the project folder and choose
   New > Other > Web Service > Web Service  and press Next.
   
2. Select 
    Web service type: Bottom Up Java bean Web Service
    Service implementation: <Choose your service class>
  
3. Choose the configuration for client (if required). Leave the rest as it is.
4. Press Finish


Testing
-------
# With Browser
Type the url in your browser followed by '?wsdl'. You can find the url from the wsdl file.
Eg. In my case http://localhost:8080/SOAPService/services/EmailServiceImpl?wsdl
This will give you a xmal response

# With SOAP UI
Create project in SOAP UI using the wsdl url (http://localhost:8080/SOAPService/services/EmailServiceImpl?wsdl)
Change the input values in the input xml and send the request. The response will be displayed next to the input text area.

# With client 
You can find the client code from the following link
