package com.kashi.udacity.software.testing;

public class Queue {
	int max_size;
	int size;
	int head;
	int tail;
	int[] data;

	public Queue(int max_size) {
		this.max_size = max_size;
		this.size = 0;
		this.head = 0;
		this.tail = 0;
		this.data = new int[max_size];
	}

	public Boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}

	public Boolean isFull() {
		if (this.size == this.max_size)
			return true;
		else
			return false;
	}

	public Boolean add(int number) {
		if (isFull())
			return false;
		data[tail] = number;
		if (tail + 1 == max_size)
			tail = 0;
		
		else
			tail++;
		size++;
		return true;
	}

	public int delete() {
		if (isEmpty())
			return -1;
		int x = data[head];
		if (head + 1 == max_size)
			head = 0;
		else
			head++;
		size--;
		return x;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Queue's contents are:\n");
		for(int number:data){
			sb.append(number+"\n");
		}
		return sb.toString();

	}

}
