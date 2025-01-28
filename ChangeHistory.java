import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> historyList;

    public ChangeHistory() {
        this.historyList = new ArrayList<>();
    }

    public void add(double status) {
        this.historyList.add(status);
    }

    public void clear() {
        this.historyList.clear();
    }

    public double maxValue() {
        double maxValue = 0.0;

        for (Double value : historyList) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public double minValue() {
        double minValue = historyList.get(0);

        for (Double value : historyList) {
            if(value < minValue){
                minValue = value;
            }
        }
        return minValue;
    }

    public double average() {
        if (historyList.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        int count = 0;
        for (Double value : historyList) {
            total += value;
            count++;
        }
        return total / count;
    }

    @Override
    public String toString() {
        String list = historyList.toString();
        return list;
    }
}
