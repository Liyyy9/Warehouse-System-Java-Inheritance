public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory historyList;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.setBalance(initialBalance);
        this.historyList = new ChangeHistory();
        this.historyList.add(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= howMuchSpaceLeft()) {
            this.balance = this.balance + amount;
            historyList.add(balance);
        } else {
            this.balance = this.capacity;
            historyList.add(balance);
        }
    }

    @Override
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > this.balance) {
            double allThatWeCan = this.balance;
            this.balance = 0.0;
            return allThatWeCan;
        }

        this.balance = this.balance - amount;
        historyList.add(balance);
        return amount;
    }

    public void printAnalysis() {
    System.out.printf("Product: %s%n", super.getName());
    System.out.println("History: " + history());
    System.out.printf("Largest amount of product: %.1f%n", historyList.maxValue());
    System.out.printf("Smallest amount of product: %.1f%n", historyList.minValue());
    System.out.printf("Average: %.1f%n", historyList.average());
    
}


    public String history() {
        return this.historyList.toString();
    }

}
