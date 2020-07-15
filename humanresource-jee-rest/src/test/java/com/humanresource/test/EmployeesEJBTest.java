package com.humanresource.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.humanresource.core.model.Employees;
import com.humanresource.core.persistence.impl.GenericDAOImpl;

public class EmployeesEJBTest extends Mockito{
	
	@Mock
	Employees employees = new Employees(); 
	@Mock
	private EntityManager entityManager; 
	@InjectMocks
	private GenericDAOImpl<Employees, Long> dao;
	/*
	 * @Mock private EmployeesMapper employeesMapper;
	 */
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findByid() {
		dao.setClassEntity(Employees.class);
		Long id = 1L;
		employees = dao.findById(id);
		//Assert.assertNotNull(employees);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void findAll() {
		/*
		 * dao.setClassEntity(Employees.class); List<Employees> employees =
		 * dao.findAll();
		 */
		
		String sql = "Select e from Employees e";
		List<Employees> employees = dao.getEntityManager().createQuery(sql).getResultList();
		Assert.assertNotNull(employees);
	}
	
	@Test
	public void save() {
		Employees employees = Mockito.mock(Employees.class);
		employees.setName("Customer3");
		employees.setPassword("123456");
		employees.setEmail("customer3@employees.com");
		employees.setProfiles("ROLE_CUSTOMER");
		//dao.save(employees);
		dao.getEntityManager().persist(employees);
		dao.getEntityManager().flush();
		Assert.assertNotNull(employees.getId());
	}
	
}
