class ClassObject
{
    public <T> String what_is_it(T arg){
        try{

            if(arg instanceof Integer){
                throw new ClassObjectException("ClassObject: Integer");
            } else if(arg instanceof Double){
                throw new ClassObjectException("ClassObject: Double");
            } else if(arg instanceof String){
                throw new ClassObjectException("ClassObject: String");
            } else if(arg instanceof Boolean){
                throw new ClassObjectException("ClassObject: Bool");
            } else {
                throw new ClassObjectException("ClassObject: unknown type");
            }
        } catch(Exception e){
            return e.toString();
        }
    }
}