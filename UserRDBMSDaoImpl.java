package com.nucleus.dao;
import java.sql.*;

import com.nucleus.connection.ConnectionClass;
import com.nucleus.entity.User;


public class UserRDBMSDaoImpl implements UserDao {
	ConnectionClass conclass=new ConnectionClass();
	Connection con=conclass.getDbConnection();
	ResultSet rs=null,rs1=null;
	PreparedStatement ps=null,ps1=null;

	@Override
	public void signUp(User user) throws SQLException {
		
		ps1=con.prepareStatement("select email from user01");
		rs=ps1.executeQuery();
		int flag=0;
		while(rs.next())
		{
			if(user.getEmailId().equals(rs.getString("email")))
			{
				flag=1;
				break;
			}
		}
			if(flag==1)
			{
				System.out.println("account already exists try to sign in");
				
			}
			else
			{
		
		ps=con.prepareStatement("insert into user01 values(?,?,?,?)");
		ps.setString(1, user.getEmailId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getGender());
		ps.executeUpdate();
		
		System.out.println("account created");
			}
		}
	
	@Override
	public void signIn(User user) throws SQLException {
		String e = null,p = null,n=null;
		int flag=0;
		
		ps1=con.prepareStatement("select email from user01");
		rs1=ps1.executeQuery();
		while(rs1.next())
		{
			if(user.getEmailId().equals(rs1.getString(1)))
			{
				flag=1;
				break;
			}
		}
			
			if(flag==1)
			{
				ps=con.prepareStatement("select email,pass,username from user01 where email=?");
				ps.setString(1, user.getEmailId());
				rs=ps.executeQuery();
				while(rs.next())
				{
					 e=rs.getString(1);
					 p=rs.getString(2);
					n=rs.getString(3);
				}
				
				if(user.getEmailId().equals(e) && user.getPassword().equals(p))
				{
					
					System.out.println("welcome "+n);
					
				}
				else
				{
					System.out.println("retry again wrong id or password");
				}
				
			}
			else
			{
				System.out.println("account does not exists first sign up");
			}
		}
			
	}

	

