package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Statement;
import java.util.ArrayList;

public class CobraJDBC {
	
	private Connection con;
	
	public CobraJDBC(Connection con){
		this.con = con;
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	
	public void addScore(Score score) {
		String sql = "INSERT INTO scores (nome, score, time, speed, mode) VALUES (?,?,?,?,?);";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, score.getNome());
			ps.setInt(2, score.getScore());
			ps.setTimestamp(3, Timestamp.valueOf(score.getDate()));
			ps.setInt(4, score.getSpeed());
			ps.setString(5, score.getMode());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Score> getHighscores(){
		ArrayList<Score> highscores = new ArrayList<Score>();
		String sql = "SELECT * FROM scores ORDER BY score DESC";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Score score = new Score();
				score.setNome(rs.getString("nome"));
				score.setScore(rs.getInt("score"));
				score.setDate(rs.getTimestamp("time").toLocalDateTime());
				score.setSpeed(rs.getInt("speed"));
				score.setMode(rs.getString("mode"));
				highscores.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return highscores;
	}
	
}
