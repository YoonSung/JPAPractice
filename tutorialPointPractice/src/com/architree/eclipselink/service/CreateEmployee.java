package com.architree.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.architree.eclipselink.entity.Employee;

public class CreateEmployee 
{
	public static void main( String[ ] args ) 
	{
		create();
		find();
		delete();
		find();
	}

	/**
	 * In the above code the createEntityManagerFactory () creates a persistence unit by providing the same unique name 
	 * which we provide for persistence-unit in persistent.xml file. 
	 * The entitymanagerfactory object will create the entitymanger instance by using createEntityManager () method. 
	 * The entitymanager object creates entitytransaction instance for transaction management. 
	 * By using entitymanager object, we can persist entities into the database.
	 * 
	 * After compilation and execution of the above program you will get notifications from eclipselink library on the console panel of eclipse IDE.
	 */
	protected static void create() {
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.
				createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Employee employee = new Employee( ); 
		employee.setEid( 1201 );
		employee.setEname( "Gopal" );
		employee.setSalary( 40000 );
		employee.setDeg( "Technical Manager" );
		entitymanager.persist( employee );
		entitymanager.getTransaction( ).commit( );
		
		entitymanager.close( );
		emfactory.close( );
	}
	
	private static void find() {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.
				createEntityManager();
		Employee employee = entitymanager.
				find( Employee.class, 1201 );
		
		if (employee !=null) {
			System.out.println("employee ID = "+employee.getEid( ));
			System.out.println("employee NAME = "+employee.getEname( ));
			System.out.println("employee SALARY = "+employee.getSalary( ));
			System.out.println("employee DESIGNATION = "+employee.getDeg( ));	
		} else {
			System.out.println("employee is not found");
		}
				
	}
	
	private static void delete() {
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.
				createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Employee employee=entitymanager.
				find( Employee.class, 1201 );
		entitymanager.remove( employee );
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
	}
}