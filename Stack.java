package com.kashi.udacity.software.testing;

public class Stack {

	int[] data;
	int top;
	int maxSize;

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		top = -1;
		data = new int[maxSize];
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public boolean push(int number) {
		if (top == maxSize - 1)
			return false;
		data[++top] = number;
		return true;
	}

	public int pop() {
		if (isEmpty())
			return -1;
		return data[top--];
	}

}