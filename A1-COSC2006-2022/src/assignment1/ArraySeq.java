package assignment1;



public class ArraySeq<E> {
	
	public E[] data;
	public static final int DEFAULT_CAPACITY = 10;
	public int items;
	public E current;
	
	
	public ArraySeq() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArraySeq(int initialCapacity) {
		data = (E[]) new Object[initialCapacity];
		items = 0;
		current=null;
	}

	public void add(E element){
		if(items >= getCapacity()){
			ensureCapacity(getCapacity()*2); 
		}
		data[items] = element;
		items++;
	}
	
	public void addAfter(E element) {
		
		if(current==null){
			
			if(items >= getCapacity()){ 
				ensureCapacity(getCapacity()*2); 
			}
			
			data[items] = element;
			items++;	
			current=element;
			
		}else{
			
			int i=0;
			while(data[i]!=current) {
				i++;
			}
			
				items++;
				E[] newData=(E[]) new Object[data.length+1];
				for(int k=0; k<=i;k++) {
					newData[k]=data[k];
				}
				newData[i+1]=element;
				for(int m=i+1;m<data.length;m++) {
					newData[m+1]=data[m];
				}
				data=newData;	
				current=element;
		}
			
	}
	
	public void addBefore(E element) {
	
		if(current==null){
					
			E[] newData=(E[]) new Object[data.length+1];
			newData[0]=element;
			for(int m=0;m<data.length;m++) {
				newData[m+1]=data[m];
			}
					items++;	
					current=element;
					data=newData;
		}else{
					
			int i=0;
			while(data[i]!=current) {
				i++;
			}
					
			items++;
			E[] newData=(E[]) new Object[data.length+1];
			
			for(int k=0; k<i;k++) {
				newData[k]=data[k];
			}
			newData[i]=element;
			for(int m=i;m<data.length;m++) {
				newData[m+1]=data[m];
			}
			data=newData;	
			current=element;
		}
			
	
	}
	
	
	
	
	
	public boolean removeCurrent() {
		if(isCurrent()){
			int i=0;
			E[] newData = (E[]) new Object[getCapacity()];
			
			while(data[i]!=current) {
				i++;
			}
			advance();
			if(i==0) {
				System.arraycopy(data, 1, newData, 0, items);
				data = newData;
				items--;
				return true;
			}else if(i==data.length-1) {
				data[i]=null;
				current=null;
				items--;
				return true;
			}else {
				System.arraycopy(data, 0, newData, 0, i);
				System.arraycopy(data, i + 1, newData, i, data.length - i - 1);
				data=newData;
				items--;
				return true;
			}
		}else {
			return false;
		}
	}

	public void advance() {
		int i=0;
		while(data[i]!=current) {
			i++;
		}
		
			for(int j=i+1; j<data.length; j++) {
				if(data[j]!=null){
					current=data[j];
					return;
				}else{
					current=null;
				}
			}
		
	}
	public void start() {
		if(items==0){
		current=null;
		}else{
			for(int i=0; i<data.length; i++){
				if(data[i]!=null){
					current=data[i];
					return;
				}
			}
		}
	}
	
	
	public void addAll(ArraySeq<E> addEnd) {
		E[] elements=addEnd.data;
		
		for(int i = 0; i < elements.length; i++){
			
			if(elements[i] != null) {
				
				if(items >= getCapacity()){ 
					ensureCapacity(getCapacity()*2);
				}
				
				data[items] = elements[i];
				items++;
			}
		}
			
	}
	
	
	public E getCurrent() {
		return current;
	}
	
	public boolean isCurrent() {
		if(current==null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public void ensureCapacity(int minimumCapacity) {
		if(minimumCapacity < getCapacity()) return;
		E[] newData = (E[]) new Object[minimumCapacity];
		System.arraycopy(data, 0, newData, 0, items);
		data = newData;
	}
	
	public static <E> ArraySeq<E> concatenate (ArraySeq<E> s1, ArraySeq<E> s2){
		int size = s1.size() + s2.size();
		ArraySeq<E> temp = new ArraySeq<E>(size);
		temp.addAll(s1);
		temp.addAll(s2);
		return temp;
		
	}
	public int getCapacity() {
		return data.length;
	}

	public void trimToSize() {
		E[] smallerSize = (E[]) new Object[items];
		System.arraycopy(data, 0, smallerSize, 0, items);
		data = smallerSize;
	}
	public int size() {
		return items;
	}
	public String toString(){
		StringBuilder str = new StringBuilder("");
		if(items > 0){
			for(int i = 0; i < items; i++){
				str.append(data[i]);
				if(i < items-1) str.append(" ");
			}
		}
		else str.append("This sequence is empty!");
		return str.toString();
	}


}
    
	

