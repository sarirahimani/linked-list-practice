package assignment1;

public class SequenceTester {
		public static void main(String[] args){
			ArraySeq<Integer> myArraySeq = new ArraySeq<Integer>();
			System.out.println(myArraySeq);
			ArraySeq<Integer> myOtherArraySeq = new ArraySeq<Integer>(5);
			System.out.println(myOtherArraySeq);
			myArraySeq.add(5);
			myArraySeq.add(10);
			myArraySeq.add(7);
			System.out.println(myArraySeq);
			myOtherArraySeq.add(1);
			myOtherArraySeq.add(2);
			myOtherArraySeq.add(3);
		
			System.out.println(myOtherArraySeq);
			myArraySeq.addAll(myOtherArraySeq);
			System.out.println(myArraySeq);
			System.out.println(myOtherArraySeq);
		
			myArraySeq.start();
			System.out.println(myArraySeq.removeCurrent());
			System.out.println("remove 5: "+myArraySeq);
			System.out.println(myArraySeq.getCurrent());
			myArraySeq.advance();
			System.out.println(myArraySeq.getCurrent());
			myArraySeq.advance();
			System.out.println(myArraySeq.getCurrent());
			System.out.println(myArraySeq.removeCurrent());
			System.out.println(myArraySeq.getCurrent());
			System.out.println(myArraySeq);
			System.out.println(myArraySeq.getCurrent());
			System.out.println(myArraySeq.removeCurrent());
			System.out.println(myArraySeq);
			System.out.println(myArraySeq.getCurrent());
			System.out.println(myArraySeq.size());
			System.out.println(myArraySeq.getCapacity());

			ArraySeq<Integer> newArraySeq = ArraySeq.concatenate(myArraySeq,myOtherArraySeq);
			System.out.println("newArraySeq: "+newArraySeq);
			System.out.println("ArraySeq's capacity: "+myArraySeq.getCapacity());
			myArraySeq.trimToSize();
			System.out.println("ArraySeq's capacity after trim: "+myArraySeq.getCapacity());
			System.out.println(myArraySeq);
			System.out.println("ArraySeq's size: "+myArraySeq.size());
			System.out.println("myArraySeq: "+myArraySeq);
			myArraySeq.ensureCapacity(10);
			System.out.println("ArraySeq's capacity after resize: "+myArraySeq.getCapacity());
			myArraySeq.addAll(newArraySeq);
			System.out.println("myArraySeq+newArraySeq:  "+myArraySeq);
			
			ArraySeq<Integer> seq = new ArraySeq<Integer>();
			seq.add(0);
			seq.add(1);
			seq.add(2);
			seq.add(3);
			seq.add(4);
			seq.add(5);
			seq.add(6);
			
			seq.start();
			System.out.println(seq);
			System.out.println(seq.size());
			System.out.println(seq.getCurrent());
			seq.advance();
			System.out.println(seq.getCurrent());
			seq.addAfter(15);
			System.out.println(seq.getCurrent());
			System.out.println(seq);
			System.out.println("size:"+seq.getCapacity());
			seq.advance();
			System.out.println(seq.getCurrent());
			seq.advance();
			System.out.println(seq.getCurrent());
			seq.advance();
			System.out.println(seq.getCurrent());
			seq.advance();
			System.out.println(seq.getCurrent());
			seq.advance();
			System.out.println(seq.getCurrent());
			seq.addAfter(10);
			System.out.println(seq.getCurrent());
			System.out.println(seq);
			System.out.println("size:"+seq.getCapacity());
			seq.start();
			seq.addAfter(22);
			System.out.println(seq.getCurrent());
			System.out.println(seq);
			System.out.println("size:"+seq.getCapacity());
			System.out.println("current before addBefore: "+seq.getCurrent());
			seq.addBefore(55);
			System.out.println("current after addBefore: "+seq.getCurrent());
			System.out.println(seq);
			seq.start();
			System.out.println("current before addBefore: "+seq.getCurrent());
			seq.addBefore(35);
			System.out.println("current after addBefore: "+seq.getCurrent());
			System.out.println(seq);
			
			ArraySeq<Integer> seq1 = new ArraySeq<Integer>();
			System.out.println(seq1);
			System.out.println("current before addBefore: "+seq1.getCurrent());
			seq1.addBefore(35);
			System.out.println(seq1);
			System.out.println("current after addBefore: "+seq1.getCurrent());
		}
	}
