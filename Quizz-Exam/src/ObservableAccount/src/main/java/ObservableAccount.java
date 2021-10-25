import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class implements a bank account.
 * You can deposit and withdraw money from the account.
 * Read carefully the comments of each method and fill the missing
 * parts marked with "TODO".
 * You can ADD any code you like in this class (new members, new methods, etc.).
 * but do not add a package
 */

public class ObservableAccount {

    public interface AccountObserver {
        void accountHasChanged();
    }

    public static class PrintObserver implements AccountObserver{
        @Override
        public void accountHasChanged() {
            System.out.println("le compte a changer");
        }
    }

    LinkedList<AccountObserver> observers = new LinkedList<>();
    LinkedList<Integer> max = new LinkedList<>();
    AccountObserver o;
    private int sold;

    /**
     * Get the account balance  (franc. "solde")
     * The initial balance of the account is 0.
     *
     * @return The balance
     */
    public int getBalance() {
        return sold;
    }

    /**
     * Deposit an amount into the account
     *
     * @param amount The amount to deposit
     */
    public void deposit(int amount) {
        sold += amount;
        if(observers != null){
            Iterator<AccountObserver> obs = observers.iterator();
            Iterator<Integer> maximum = max.iterator();
            for(int i = 0; i < observers.size(); i++){
                if(amount > maximum.next()){
                    obs.next().accountHasChanged();
                }
            }
        }
    }

    /**
     * Withdraw an amount from the account.
     * An account cannot become negative.
     * If you try to withdraw 1000 Euro from an account that has
     * only 500 Euro, the withdrawal is NOT executed.
     *
     * @param amount The sum to withdraw
     */
    public void withdraw(int amount) {
        if(sold > amount){
            sold -= amount;
        }
        if(observers != null){
            Iterator<AccountObserver> obs = observers.iterator();
            Iterator<Integer> maximum = max.iterator();
            for(int i = 0; i < observers.size(); i++){
                if(amount > maximum.next()){
                    obs.next().accountHasChanged();
                }
            }
        }

    }

    /**
     * Add an observer to the account.
     * The observer will be notified if an amount is deposited or withdrawn
     * that is greater than the specified maximum.
     * The observer must NOT be notified if the withdrawal is not executed
     * (see comment of the method 'withdraw')
     *
     * The user of this class can change the maximum for an added observer by calling
     * this method again with the same observer. Example:
     *      account.addObserver(myObserver,1000);
     *      account.addObserver(myObserver,2000); // change maximum for this observer
     *
     * @param observer The observer to add.
     * @param maximum The observer will be notified if the deposited or withdrawn
     *                amount is greater than "maximum".
     *
     */
    public void addObserver(AccountObserver observer, int maximum) {
        if(!observers.contains(observer)){
            o = observer;
            max.add(maximum);
            observers.add(o);
        }
        LinkedList<AccountObserver> otherO = new LinkedList<>();
        LinkedList<Integer> otherM = new LinkedList<>();
        Iterator<AccountObserver> obs = observers.iterator();
        Iterator<Integer> maxi = max.iterator();
        AccountObserver suivant = obs.next();
        for(int i = 0; i < observers.size(); i++){
           if(suivant == observer){
               otherO.add(suivant);
               otherM.add(maximum);
               if(obs.hasNext()){
                   suivant = obs.next();
               }
           }
           else {
               otherO.add(suivant);
               otherM.add(maxi.next());
               if(obs.hasNext()){
                   suivant = obs.next();
               }
           }
        }
        observers = otherO;
        max = otherM;
    }
}