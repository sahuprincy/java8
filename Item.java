package java8;

public class Item {
	 private final int i;

	    public Item(int i){
	        this.i = i;
	    }

	    public String getKey(){
	        return "Key-"+i;
	    }

	    @Override
	    public String toString() {
	        return "Item [i=" + i + "]";
	    }
}
