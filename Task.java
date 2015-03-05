
public class Task {
    Cell from, to;
    Task (Cell from, Cell to) {
        this.from = from;
        this.to = to;
    }
    public boolean check (Cell from, Cell to) {
        if (this.from == from && this.to == to) {
            System.out.println("Правильно!");
            return true;
        } else {
            return false;
        }
    }
}
