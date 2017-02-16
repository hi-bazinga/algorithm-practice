package practice;


public class WaitOrSleep {
    public static void main(String args[])
    {
    	WaitOrSleep ws = new WaitOrSleep();
    	ws.test();
        
    }
    
    public void test(){
    	final A a = new A();
    	Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
		            a.printThreadInfo();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
    	});
    	t1.start();
    	
    	Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
		            a.printThreadInfo();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
    	});
    	t2.start();
    }
    
    class A {
    	int i = 0;
        public synchronized void printThreadInfo() throws InterruptedException
        {
        	while (i < 10) {
        		Thread t=Thread.currentThread();
        		System.out.println("ThreadID:"+t.getId()+". " + i++);
        		
        	//	Thread.sleep(1000);		// sleep() do not release the lock
        		this.wait(1);			// wait() release the lock
        	}
        }
    }
}