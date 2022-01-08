package hw6part1task1;

public class BankAccount {



    public long number;
    public String owner;
    public double amount;

    //Create constructor

    public BankAccount (long number, String owner, double amount){
        this.number = number;
        this.owner = owner;
        this.amount = amount;
    }

    //Auto-gen getters
    public long getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public double getAmount() {
        return amount;
    }

    //Auto-gen setter
    public void setAmount(double amount) {
        this.amount = amount;
    }

    //Manual
    //Учитывается то что наличку можно снять только купюрами кратными 100
    public void withdrawCash(int requested){

        if ((requested % 100)<0  && requested<this.amount){
            this.amount = this.amount - requested;
            System.out.println("You've withdraw " + requested + " RUB");
            System.out.println("Money left: " + this.amount + " RUB");
        } else {
            System.out.println("Requested operation can not be completed");
        }

    }
}
