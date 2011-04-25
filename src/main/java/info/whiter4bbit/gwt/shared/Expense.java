package info.whiter4bbit.gwt.shared;

public class Expense {
    private String details;
    private String description;
    private Float amount;

    public Expense() {

    }

    public Expense(String description, String details, Float amount) {
        this.description = description;
        this.amount = amount;
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public Float getAmount() {
        return amount;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (amount != null ? !amount.equals(expense.amount) : expense.amount != null) return false;
        if (description != null ? !description.equals(expense.description) : expense.description != null) return false;
        if (details != null ? !details.equals(expense.details) : expense.details != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = details != null ? details.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
