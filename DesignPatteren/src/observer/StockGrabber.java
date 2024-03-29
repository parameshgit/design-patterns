package observer;

import java.util.ArrayList;

public class StockGrabber implements Subject {

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;


    public StockGrabber() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);

    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        // Print out message (Have to increment index to match)
        System.out.println("Observer " + (observerIndex + 1) + " deleted");
        // Removes observer from the ArrayList
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(ibmPrice, aaplPrice, googPrice);
        }

    }


    public void setIBMPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setAAPLPrice(double aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObserver();
    }

    public void setGOOGPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}
