package oracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_Data {
	public static List<User> getAllRecords() {
		List<User> list = new ArrayList<User>();
		try {
			Connection con = DataConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("user_id"));
				u.setFirstName(rs.getString("fname"));
				u.setLastName(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static int delete(int user_id) {
		int status = 0;
		try {
			Connection con = DataConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from users where user_id=?");
			ps.setInt(1, user_id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(User u) {
		int status = 0;
		try {
			Connection con = DataConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update users set fname=?,lname=?,email=? where user_id=?");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
