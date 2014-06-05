package com.dbquery.form;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int retVal=0;
		
		// add object to DB
		retVal=DBOperations.addObjectIntoDB(new DatabaseObject("vedhavyas", "vedhavyas@gmail.com"));
		if(retVal == 1){
			System.out.println("Sucess!!");
		}else{
			System.out.println("Couldnt add the object");
		}
		
		// get object by ID
		DatabaseObject object = DBOperations.getByID(2);
		DBOperations.printObj(object);
	
		
		// print all objects on DB
		DBOperations.printDbObjsFromList(DBOperations.getAllObjects());
	}
}
