# SER322_Del4

To create the database application, our database first must be created. This can be done using the collection of sql table generation and population instructions from the PDF. 

Once you have the database created, we can set up our program setup. This setup assumes the use of the JDK 11 and Eclipse on a Windows computer. 

First, download the JavaFX SDK for windows that is compatible with JDK 11. 

Next, import our project, making sure to include our source code and our Main.fxml file, all of which are contained in src.

Next, configure the Eclipse IDE to run programs with JavaFX. In our case, we went to Window -> Preferences -> Java -> Installed JREs. We then edited the default JRE and added the needed JavaFX jar files to the JRE.

Next, go to Run -> Run Configurations -> Java Applications. You will need to add VM arguments to launch the configuration. It looks like --module-path "\path\to\javafx-sdk-11.0.2\lib" --add-modules javafx.controls, javafx.fxml

After the JavaFX configuration, we'll need to add our mysql driver connector. You'll first need to download a connector.

Next, right click on the imported project and select Preferences. Go to Libraries, select Classpath, Add External Jars, and select your connector jar. 

This program should finally be ready for testing by selecting the run button. When the program runs, the Console will ask several questions. 

First it will ask for your driver. You will answer with com.mysql.jdbc.Driver, which should be included in the jdbc jar you added.

Next, it will ask for your database url. In our case, we answer with jdbc:mysql://localhost:3306/albumdb. If you created your database with our tables and named the database differently, simply change the last part of the url to the name of your database. 

Next, it will ask for your username for the database, then your password. 

Finally, the program will run!