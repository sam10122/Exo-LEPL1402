/**
 * This visitor must compute the mean salary of all the staff
 * (including both workers and managers).
 **/

class MeanSalaryVisitor extends Visitor {
    int size = 0;
    float meanSalary = 0;
    public float getResult() {
        if(meanSalary <= 0){
            throw new IllegalArgumentException();
        }
        return meanSalary/size;
    }

    @Override
    public void visit(Manager manager) {
        meanSalary += manager.getSalary();
        size++;
    }

    @Override
    public void visit(Worker worker) {
        meanSalary += worker.getSalary();
        size++;
    }
}
