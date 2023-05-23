package wk3;

public class Lion extends Cat{

    public double scariness;

    public Lion(){}

    public Lion(String name, int paws){
        //super(name, paws); // either a method or an instance variable
        //super() => method: constructor
        super(name, paws);
        int a = 123;
    }
    public Lion(String name, int paws, double scariness){
        this(name, paws);
        this.scariness = scariness;
    }

    @Override
    public String toString(){

        return "Lion" + super.toString().substring(3, super.toString().length() -1) +
                ", scariness = " + scariness + "}";

    }
}
