/**
 * This visitor must compute the age of the youngest manager.
 **/

class MinManagerAgeVisitor extends Visitor {
    int minManagerAge = 5000000;

    public int getResult() {
        if(minManagerAge >= 67 ){
          throw new IllegalArgumentException();
        }
        return  minManagerAge;

    }

    @Override
    public void visit(Manager manager) {
        minManagerAge = Math.min(manager.getAge(),minManagerAge);
    }

    @Override
    public void visit(Worker worker) {

    }
}
