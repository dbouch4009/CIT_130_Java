class ThreadObject extends Thread{
    private String id;
    private int count;
    private String msg;
    private boolean sync;
    public ThreadObject(String id, int count, String msg, boolean sync){
        this.id = id;
        this.count = count;
        this.msg = msg;
        this.sync = sync;
    }

    //init threads


    public void displayMessage(int index){
        System.out.print("		Thread ID: " + this.id);
        System.out.print(" MSG: " + this.msg);
        System.out.print(" -> "+ index + " of " + this.count + "\n");
    }

    public void displayMessageSync(int index){
        //implement sync
        System.out.print("		Thread ID: " + this.id);
        System.out.print(" MSG: " + this.msg);
        System.out.print(" -> "+ index + " of " + this.count + "\n");
    }
}