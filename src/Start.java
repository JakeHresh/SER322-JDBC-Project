import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;


public class Start extends Application{
	public static String driver;
	public static String url;
	public static String user;
	public static String pwd;
	static Scanner scan = new Scanner(System.in);
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Title");
		primaryStage.setScene(scene);
		primaryStage.show();
		/*Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//System.out.println("Hello World!");
				searchAlbumByName("Hotalbum");
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();*/
	}
	public static void main(String[] args) {
		/*ResultSet rs = null;
		Statement stmt = null;
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(" ", " ", " ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select Distinct E.EMPNO, E.ENAME, D.DNAME From emp AS E, dept AS D Where D.DEPTNO=E.DEPTNO");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}*/
		System.out.println("What is your driver?");
		driver = scan.nextLine();
		System.out.println("What is your database url?");
		url = scan.nextLine();
		System.out.println("What is your username?");
		user = scan.nextLine();
		System.out.println("What is your password?");
		pwd = scan.nextLine();
		launch(args);
	}
	
}
