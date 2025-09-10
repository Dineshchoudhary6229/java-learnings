class Bank
{
    private long acc_no;
    private String email,name;
    private float amount;

    public long getAcc_no()
    {
        return acc_no;
    }
    public void setAcc_no(long acc_no)
    {
        this.acc_no=acc_no;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public float getAmount()
    {
        return amount;
    }
    public void setAmount(float amount)
    {
        this.amount=amount;
    }
}
class Encapsulation
{
    public static void main(String[] args)
    {
        Bank obj = new Bank();
        obj.setAcc_no(202020);
        obj.setName("Anil");
        obj.setEmail("xyz");
        obj.setAmount(20);
        System.out.println(obj.getName()+" "+obj.getAcc_no()+" "+obj.getEmail()+" "+obj.getAmount());



    }

}

















