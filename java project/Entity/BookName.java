package Entity;

public abstract class BookName {
    protected String name; 

    public BookName(String name) 
    {
        this.name = name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}