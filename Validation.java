import java.util.Scanner;

public class Validation {
	public boolean dataLength(String s,int l)
	{
		int len=s.length();
		if(s.contains("."))
		{
			len--;
		}
		if(len==l)
			return true;
		else
			return false;
	}
	public boolean dataType(String s,String datatype)
	{
		int flag=0;
		Object ob1=s;
		if(datatype.equalsIgnoreCase("int"))
		{
			if(ob1 instanceof Integer)
			{
				return true;
			}
			else
				return false;
			/*try {
				Integer.parseInt(s);
				flag=1;
			}
			catch (NumberFormatException e) {
				flag=0;
			}
			if(flag==1)
				return true;
			else
				return false;*/
		}
		else if(datatype.equalsIgnoreCase("float"))
		{
			if(ob1 instanceof Float)
			{
				return true;
			}
			else
				return false;
			/*int pos=s.indexOf(".");
			int c=0;
			for(int i=pos+1;i<s.length();i++)
			{
				c+=1;
			}
	       if(c<=7)
	       return true;
	       else
	    	   return false;*/
	   }
		else if(datatype.equalsIgnoreCase("double"))
		{
			
			if(ob1 instanceof Double)
			{
				return true;
			}
			else
				return false;
			/*int pos=s.indexOf(".");
			int c=0;
			for(int i=pos+1;i<s.length();i++)
			{
				c+=1;
			}
	       if(c<=15)
	       return true;
	       else
	    	   return false;*/

			
		}
		else if(datatype.equalsIgnoreCase("char"))
		{
			
			if(ob1 instanceof Character)
			{
				return true;
			}
			else
				return false;
				
				/*
			int len=s.length();
			if(len==1 && (s.charAt(0)<48 || s.charAt(0)>57))
			{
				return true;
			}
			else
				return false;*/
				
			
		}
		else if(datatype.equalsIgnoreCase("boolean"))
		{
			if(ob1 instanceof Boolean)
			{
				return true;
			}
			else
				return false;
			/*if(s.equals("true")||s.equals("false"))
			{
				return true;
			}
			else
				return false;*/
		}
		else
		{
			
            
			try
			{
				Class.forName(datatype).isInstance(ob1);
				flag=1;
			}
			catch(ClassNotFoundException e)
			{
				flag=0;
			}
			if(flag==1)
				return true;
			else
				return false;
			
		}
		
		
	}
	public boolean specialCharacters(String s,char a[])
	{
		
		return true;
	}
	public boolean emailValidation()
	{
		
	}

	public static void main(String[] args) {
		
		/*try (Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Enter an integer : ");
			if (scanner.hasNextFloat()) 
			{
			System.out.println("You entered : " + scanner.nextFloat());
		    }
			else {
			System.out.println("The input is not an integer");
			}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}*/
		Scanner scanner = new Scanner(System.in);
		String fieldValue=scanner.next();
		String dataType=scanner.next();
		int l=scanner.nextInt();
		Validation validation=new Validation();
		boolean a=validation.dataLength(fieldValue, l);
		boolean b=validation.dataType(fieldValue, dataType);
		System.out.println(a+" "+b);
		
	}
}
