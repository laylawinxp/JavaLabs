@Repeat(5)
public class Bank {
    double keyRate;
    String bankName;
    private char secretSymbol;

    Bank() {
        this.keyRate = 8.5;
        this.bankName = "Central Bank";
        this.secretSymbol = '^';
    }

    @Repeat(3)
    protected void setKeyRate(double rate) {
        keyRate = rate;
        System.out.println("Ключевая ставка составляет " + keyRate);
    }

    @Repeat(5)
    protected void countEmployees(String message) {
        System.out.println("В банке работает " + message);
    }

    @Repeat(4)
    public void multiplySumRate(Integer sum) {
        System.out.println("Умножить сумму на ключевую ставку: " + sum * keyRate);
    }

    @Repeat(6)
    public void showBankName(Bank bank) {
        System.out.println("Название банка: " + bank.bankName);
    }

    @Repeat(2)
    private void showCorrespondentAccount(int[] arr) {
        System.out.println("На корреспондентском счете 1500000000 руб. " + arr[0] + " коп.");
    }

    @Repeat(2)
    private void setSecretSymbol(char newSymbol) {
        secretSymbol = newSymbol;
        System.out.println("Установлен новый секретный символ: " + secretSymbol);
    }
}
