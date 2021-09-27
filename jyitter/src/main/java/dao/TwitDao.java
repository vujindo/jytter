package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Twit;

public class TwitDao {
	private Connection con = null;
	
	public TwitDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://10.64.144.5:3306/"
						+ "20jy0240?characterEncoding=UTF-8","20jy0240","20jy0240");
		}catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void connectionClose() {
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Twit> findAll() {
		String sql = "SELECT * FROM twitlist";
		ArrayList<Twit> ary = null;
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			ary = new ArrayList<Twit>();
			while (rs.next()) {
				Twit one = new Twit();
				one.setContent(rs.getString("content"));
				one.setName(rs.getString("name"));
				one.setTwitTime(rs.getString("twitTime"));
				ary.add(one);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ary;
	}
	
	public void addTwit(Twit twit) {
		String sql = "INSERT INTO twitlist(name, content,twitTime) VALUES (?,?,?)";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, twit.getName());
			state.setString(2, twit.getContent());
			state.setString(3, twit.getTwitTime());
			state.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Twit> searchTwit(String word) {
		String sql = "SELECT * FROM twitlist WHERE content LIKE ?";
		ArrayList<Twit> ary = new ArrayList<Twit>();;
		ResultSet rs = null;
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1,"%" + word + "%");
			state.execute();
			rs = state.getResultSet();
			
			while (rs.next()) {
				Twit one = new Twit();
				one.setContent(rs.getString("content"));
				one.setName(rs.getString("name"));
				one.setTwitTime(rs.getString("twitTime"));
				ary.add(one);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ary;
	}
}
