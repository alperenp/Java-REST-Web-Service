# Tomcat Installation on Eclipse
1.  Make sure your Eclipse has the Eclipse JST Server Adapters (Apache Tomcat, JOnAS, J2EE)
2.  Follow the [Guide](https://crunchify.com/step-by-step-guide-to-setup-and-install-apache-tomcat-server-in-eclipse-development-environment-ide/)
  *  If you encounter a problem in Step 3 of Guide, please see possible [solution](https://stackoverflow.com/questions/37024876/how-to-use-tomcat-8-5-x-and-tomee-7-x-with-eclipse)

# Creating First Web Service
1.  Install [Web Tools Platform](https://stackoverflow.com/questions/5531402/newbie-in-eclipse-i-dont-have-dynamic-web-project-i-am-under-linux-ubuntu) on your Eclipse (If you cannot create Dynamic Web Project)
2.  Create Dynamic Web Project
  *  Don't forget to change [build path](https://stackoverflow.com/questions/22914927/creating-a-src-main-java-folder-structure-in-eclipse-without-maven/22915508) to src/main/java
3.  Follow instructions in [guide](https://crunchify.com/create-very-simple-jersey-rest-service-and-send-json-data-from-java-client/)
  *  [Tutorial for Web Application and explanation](https://www.journaldev.com/1854/java-web-application-tutorial-for-beginners)
  *  One may need to change pom file because it uses old version of dependencies. Here is an updated version
![pom](/pics/pom.PNG)
  *  Here is web.xml file. Note that the info under `<servlet-mapping>` tag changing the url pattern of rest service.
![webxml](/pics/webxml.PNG)
  *  If you come up with a **SEVERE: Allocate exception for servlet [Jersey RESTful Application]java.lang.ClassNotFoundException: org.glassfish.jersey.servlet.ServletContainer** try to do following [solution for eclipse in second answer](https://stackoverflow.com/questions/26444790/java-lang-classnotfoundexception-org-glassfish-jersey-servlet-servletcontainer)