package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.revature.model.User;
import com.revature.config.ConnectionUtil;

public class UserRepository implements CrudRepository<User>{
	ConnectionUtil cu = ConnectionUtil.getInstance();

	@Override
	public User save(User u) {
		Integer key = 0;
		try (Connection conn = cu.connect()) 
		{
			conn.setAutoCommit(false);
			String sql = "insert into app_user (username, pssword, first_name, last_name, role_id) " +
					"values (?, ?, ?, ?, ?)";
			String[] keys = {"user_id"};
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setInt(5, u.getRole().ordinal());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) 
			{
				System.out.println("User " + u.getUsername() + " successfully added.");
				key = rs.getInt(1);
				conn.commit();
			} // end if
			else 
			{
				System.out.println("User not added successfully.");
				conn.rollback();
			} // end else
		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		return u;
	}

	@Override
	public Set<User> findAll() {
		Set<User> users = new HashSet<>();
		try (Connection conn = cu.connect()) 
		{
		
		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		return users;
	}

	@Override
	public User findById(Integer id) {
		User user = new User();
		try (Connection conn = cu.connect()) 
		{
		
		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		return user;
	}

	@Override
	public boolean update(User u) {
		try (Connection conn = cu.connect()) 
		{
		
		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		try (Connection conn = cu.connect()) 
		{
		
		} catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		return false;
	}

	public User findUserByUsername(String username)
	{
		User user = new User();
		return user;
	}
	
	public User findUserByCredentials(String username, String pw)
	{
		User user = new User();
		return user;
	}
}