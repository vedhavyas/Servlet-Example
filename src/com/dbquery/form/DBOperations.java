package com.dbquery.form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperations {
	public static ArrayList<DatabaseObject> getAllObjects(){
		Connection connection = ConnectionFactory.getConnection();
		ArrayList<DatabaseObject> dbObj = new ArrayList<DatabaseObject>();
		try {
			Statement stmnt = connection.createStatement();
			String sql = "select * from jdbctable";	
			ResultSet rs = stmnt.executeQuery(sql);
			while(rs.next()){
				dbObj.add(new DatabaseObject(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbObj;
	}
	
	public static int addObjectIntoDB(DatabaseObject obj){
		Connection connection = ConnectionFactory.getConnection();
		Statement stmnt;
		int retVal=-1;
		try {
			stmnt = connection.createStatement();
			String sql = "Insert into jdbctable (Name,Email) Values (\""+obj.getName()+"\",\""+obj.getEmail()+"\")";
			retVal=stmnt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static DatabaseObject getByID(int ID){
		Connection connection = ConnectionFactory.getConnection();
		DatabaseObject obj = null;
		try {
			Statement stmnt = connection.createStatement();
			String sql = "select * from jdbctable where ID="+ID;
			ResultSet rs = stmnt.executeQuery(sql);
			while(rs.next()){
				obj = new DatabaseObject(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void printDbObjsFromList(ArrayList<DatabaseObject> dbObj){
		System.out.println("-------------------------------");
		System.out.println("| ID |    Name   |    Email   |");
		System.out.println("-------------------------------");
		for(DatabaseObject object : dbObj){
			System.out.println("|"+object.getID()+"|"+object.getName()+"|"+object.getEmail()+"|");
			System.out.println("-------------------------------");
		}
	}
	
	public static void printObj(DatabaseObject object){
		System.out.println("-------------------------------");
		System.out.println("| ID |    Name   |    Email   |");
		System.out.println("-------------------------------");
		System.out.println("|"+object.getID()+"|"+object.getName()+"|"+object.getEmail()+"|");
		System.out.println("-------------------------------");
	}
}
