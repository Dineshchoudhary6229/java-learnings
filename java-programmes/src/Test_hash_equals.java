class Test_hash_equals
{
 public static void main(String args[])
 {
 String a = "Ram";
 String b = "Ram";
 if(a.equals(b))
  {
   System.out.println("Both are equals and a hash value is: "+ a.hashCode() +"\n b hash value is :"+ b.hashCode());
  }
String c = "Anil";
String d = "Dinesh";
 if(!c.equals(d))
  {
   System.out.println("Both are unequal and a hash value is :"+ c.hashCode()+"\n b hash value is :"+ d.hashCode());
  }
 }
}