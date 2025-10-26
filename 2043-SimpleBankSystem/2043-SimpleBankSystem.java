// Last updated: 27/10/2025, 00:50:27
class Bank {
    private final long[] bal;

    public Bank(long[] balance) {
        this.bal = balance;
    }

    private boolean valid(int acc) {
        return acc >= 1 && acc <= bal.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        int a = account1 - 1, b = account2 - 1;
        if (bal[a] < money) return false;
        bal[a] -= money;
        bal[b] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        bal[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;
        int a = account - 1;
        if (bal[a] < money) return false;
        bal[a] -= money;
        return true;
    }
}
