package concurrent.threadDemo;

import java.util.Arrays;

public class Bank {

    private double[] accounts;

    public Bank(int n, double initialBal) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBal);
    }

    public void transfer(int from, int to, double amount) {
        System.out.print(Thread.currentThread());
        //if (accounts[from] < amount) return;
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d ",amount ,from, to);
        accounts[to] += amount;
        System.out.printf("total balance : %10.2f%n", getTotalBal());
    }

    public double getTotalBal(){
        double sum = 0;
        for (double a : accounts) sum += a;
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
