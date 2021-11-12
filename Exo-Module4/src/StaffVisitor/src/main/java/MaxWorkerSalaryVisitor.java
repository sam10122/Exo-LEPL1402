import java.util.ArrayList;
import java.util.List;


/**
 * This visitor must compute the salary of the worker who is the most
 * paid.
 **/

class MaxWorkerSalaryVisitor extends Visitor {
    float maxWorkerPaid = 0;

    public float getResult() {
        if(maxWorkerPaid <= 0){
            throw new IllegalArgumentException();
        }
        return maxWorkerPaid;
    }

    @Override
    public void visit(Manager manager) {

    }

    @Override
    public void visit(Worker worker) {
            maxWorkerPaid = Math.max(worker.getSalary(),maxWorkerPaid);
    }
}
