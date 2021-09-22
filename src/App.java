public class App {
    static PiggyBank bank = new PiggyBank();

	public static void main(String[] args) throws Exception  {
		for (int i = 0; i < 3; i++) {
			Thread t = new MoneyCopier(bank, i);
			t.start();
		}
		System.out.println("main end");
	}
}

class PiggyBank {
	public int money;

	public void save (int money) {
		this.money += money;
	}

	public int getMoney () {
		return money;
	}
}

class MoneyCopier extends Thread {
	public int copyMoney;
	int count;
	PiggyBank bank;
	public MoneyCopier (PiggyBank bank, int count) {
		this.bank = bank;
		this.count = count;
	}
	public void run () {
		System.out.println(count + " start copy");

        for (int i = 0; i < 10000; i++) {
            bank.save(100);
            copyMoney = bank.getMoney();
        }
        System.out.println(count + " end copy");
        System.out.println("money : " + bank.getMoney() + " count : " + count);
	    System.out.println("copyMoney : " + copyMoney + " count : " + count);
	}
}