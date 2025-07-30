class ThisAsArgumentInMethod
{  
  void m(ThisAsArgumentInMethod obj)
{  
  System.out.println("method is invoked");  
}  
  void p()
{  
  m(this);  
  }  
  public static void main(String args[])
{  
  ThisAsArgumentInMethod m = new ThisAsArgumentInMethod();  
  m.p();  
  }  
}  