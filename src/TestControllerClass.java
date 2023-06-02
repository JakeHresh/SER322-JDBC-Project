import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;
public class TestControllerClass {
	@FXML PieChart piechart;
	@FXML TextField textfield1;
	@FXML TextField textfield2;
	@FXML TextField textfield3;
	@FXML TextField textfield4;
	@FXML TextField textfield5;
	@FXML TextField textfield6;
	@FXML TextField textfield7;
	@FXML TextField textfield8;
	@FXML TextField textfield9;
	@FXML TextField textfield10;
	@FXML TextField textfield11;
	@FXML TextField textfield12;
	@FXML TextField textfield13;
	/*@FXML Label myLabel;
	public void sayHello(ActionEvent e) {
		myLabel.setText("It worked!");
		System.out.println("It Worked!");
	}*/
	
	public void btn(ActionEvent e) {
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Java", 50),
				new PieChart.Data("c++", 20),
				new PieChart.Data("python", 30),
				new PieChart.Data("c#", 10),
				new PieChart.Data("c", 15)
				);
		piechart.setData(list);
	}
	public void searchAlbumByName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT A.AlName FROM albumdb.album AS A WHERE A.AlName=?");
			stmt.setString(1, textfield1.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), 10));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchAlbumByArtistName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT A.AlName, S.NumberOfListens FROM albumdb.album AS A, albumdb.arthasal AS ARTHASAL, albumdb.song AS S, albumdb.alhass AS ALHASS WHERE A.AlName=ARTHASAL.AlName AND ARTHASAL.ArName=? AND A.AlName=ALHASS.AlName AND ALHASS.SName=S.SName;");
			stmt.setString(1, textfield2.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchAlbumBySongName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT A.AlName FROM albumdb.album AS A, albumdb.alhass AS ALHASS WHERE A.AlName=ALHASS.AlName AND ALHASS.SName=?");
			stmt.setString(1, textfield3.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), 10));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchAlbumByGenre(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT G.AlName, S.NumberOfListens FROM albumdb.genre AS G, albumdb.song AS S, albumdb.alhass AS ALHASS WHERE G.Genre=? AND ALHASS.AlName=G.AlName AND ALHASS.SName=S.SName");
			stmt.setString(1, textfield4.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchAlbumByPublisherName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT P.AlName, S.NumberOfListens FROM albumdb.publishes AS P, albumdb.alhass AS ALHASS, albumdb.song AS S WHERE P.PName=? AND ALHASS.AlName=P.AlName AND ALHASS.SName=S.SName");
			stmt.setString(1, textfield5.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchAlbumByLanguage(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT L.AlName, S.NumberOfListens FROM albumdb.language AS L, albumdb.alhass AS ALHASS, albumdb.song AS S WHERE L.Language=? AND ALHASS.AlName=L.AlName AND ALHASS.SName=S.SName");
			stmt.setString(1, textfield6.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT S.SName, S.NumberOfListens FROM albumdb.song AS S WHERE S.SName=?");
			stmt.setString(1, textfield7.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByArtistName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT S.SName, S.NumberOfListens FROM albumdb.song AS S, albumdb.alhass AS ALHASS, albumdb.arthasal AS ARTHASAL WHERE S.SName=ALHASS.SName AND ARTHASAL.ArName=? AND ARTHASAL.AlName=ALHASS.AlName");
			stmt.setString(1, textfield8.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByFeaturedArtistName(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT S.SName, SN.NumberOfListens FROM albumdb.shasfa AS S, albumdb.song AS SN WHERE S.FAName=? AND S.SName=SN.SName");
			stmt.setString(1, textfield9.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByMusicVideo(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT S.SName, SN.NumberOfListens FROM albumdb.musicvideo AS S, albumdb.song AS SN WHERE S.MusicVideo=? AND S.SName=SN.SName");
			stmt.setString(1, textfield10.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByGenre(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT ALHASS.SName, S.NumberOfListens FROM albumdb.genre AS G, albumdb.alhass AS ALHASS, albumdb.song AS S WHERE G.Genre=? AND G.AlName=ALHASS.AlName AND ALHASS.SName=S.SName");
			stmt.setString(1, textfield11.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByNumberOfListens(ActionEvent e)
	{
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		int num = 0;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT S.SName, S.NumberOfListens FROM albumdb.song AS S WHERE S.NumberOfListens=?");
			if(pattern.matcher(textfield12.getText()).matches())
				num = Integer.parseInt(textfield12.getText());
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
	public void searchSongByLanguage(ActionEvent e)
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		ObservableList<Data> list = FXCollections.observableArrayList();
		try
		{
			Class.forName(Start.driver);
			conn = DriverManager.getConnection(Start.url, Start.user, Start.pwd);
			stmt = conn.prepareStatement("SELECT DISTINCT S.SName, SN.NumberOfListens FROM albumdb.alhass AS S, albumdb.language AS L, albumdb.song AS SN WHERE L.Language=? AND L.AlName=S.AlName AND S.SName=SN.SName");
			stmt.setString(1, textfield13.getText());
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString(1)/* + "\t"*/);
				/*System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3));*/
				list.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
			}
			piechart.setData(list);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		}
	}
}
