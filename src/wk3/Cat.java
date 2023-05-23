package wk3;

public class Cat {

    private String name;
    int paws;

    public Cat(){}

    public Cat(String name, int paws) {
        this.name = name;
        this.paws = paws;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", paws=" + paws +
                '}';
    }
}
