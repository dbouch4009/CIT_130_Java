class ClassObjectException extends Exception
{
    ClassObjectException(String input)
    {
        super(input);
        System.out.println(input);
    }
}
