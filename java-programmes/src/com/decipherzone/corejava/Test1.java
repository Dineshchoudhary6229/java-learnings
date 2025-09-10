interface Parent1 {
    void fun();
}

interface Parent2 {
    void fun();
}

class Test implements Parent1, Parent2 {
    public void fun()
    {
        System.out.println("fun function");
    }

    public static void main(String[] args)
    {
        Test t = new Test();
        t.fun();
    }
}