
package EJB;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity
public class calculation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int number1;
	private int number2;
	private String operation;
	private int result;
	
	public int getfirstnum()
	{
		return number1;
	}
	public void setNumber1(int number1)
	{
		this.number1 = number1;
	}
	public int getsecondnum()
	{
		return number2;
	}
	public void setsecnum(int number2) 
	{
		this.number2 = number2;
	}
	public String getoperation() 
	{
		return operation;
	}
	public void setoperation(String operation)
	{
		this.operation = operation;
	}
	public int getresult() 
	{
		return result;
	}
	public void setresult(int result)
	{
		this.result = result;
	}
	/*public calculation()
	{
		
	}
	public int getfirstnum()
	{
		return number1;
	}
	public int getsecondnum()
	{
		return number2;
	}
	public String getoperation()
	{
		return operation;
	}
	public int getresult()
	{
		return result;
	}
	public void setfirstnum(int numm1)
	{
		number1=numm1;
	}
	public void setsecnum(int numm2)
	{
		number2=numm2;
	}
	public void setresult(int res)
	{
		result=res;
	}
	public void setoperation(String operationn)
	{
		operation=operationn;
	}
	*/
	
	
	
	

}
