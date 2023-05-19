package CoreJava;

public   class IndianTraffic implements CentralTraffic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//To Implement the Interface methods you need to define like below
		CentralTraffic c = new IndianTraffic();
		c.redStop();
		c.greenGo();
		c.FlashYellow();
		IndianTraffic a = new IndianTraffic();
		a.walkOnSymbol();
	}


	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println("Green Signal");
	}
	public void walkOnSymbol() {
		
	};

	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println("Red Signal");
	}

	public void FlashYellow() {
		// TODO Auto-generated method stub
		System.out.println("Yellow Signal");
	}

}
