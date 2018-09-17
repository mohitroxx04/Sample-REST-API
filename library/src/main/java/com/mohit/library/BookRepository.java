package com.mohit.library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
	
	Connection con=null;
	
	public BookRepository()
	{
		String url="jdbc:mysql://localhost:3306/restdb";
		String uname="root";
		String pass="admin";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, uname, pass);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Book> getBooks()
	{
		List<Book> list=new ArrayList<>();
		String query="select * from book";
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				Book bk=new Book();
				bk.setId(rs.getInt(1));
				bk.setName(rs.getString(2));
				bk.setLocation(rs.getInt(3));
				
				list.add(bk);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public Book getBook(int id) {
		
		Book bk=new Book();
		String query="select * from book where id="+id;
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			
			bk.setId(rs.getInt(1));
			bk.setName(rs.getString(2));
			bk.setLocation(rs.getInt(3));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return bk;
	}

	public void create(Book bk) {
		
		String query="insert into book values (?,?,?)";
		try
		{
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, bk.getId());
			st.setString(2, bk.getName());
			st.setInt(3, bk.getLocation());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public void update(Book bk) {
		
		String query="update book set name=?, location=? where id=?";
		try
		{
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, bk.getName());
			st.setInt(2, bk.getLocation());
			st.setInt(3, bk.getId());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public void delete(int id) {
		
		String query="delete from book where id=?";
		try
		{
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	

}
