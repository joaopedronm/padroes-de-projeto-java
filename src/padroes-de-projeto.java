import java.util.ArrayList;
import java.util.List;

// Interface Observer (Observador)
interface Observer {
    void update(String message);
}

// Classe Concreta Observer (Observador)
class EventListener implements Observer {
    private String name;

    public EventListener(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu uma notificação: " + message);
    }
}

// Interface Subject (Sujeito)
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}

// Classe Concreta Subject (Sujeito)
class EventSource implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void createEvent(String message) {
        System.out.println("Evento criado: " + message);
        notifyObservers(message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando observadores
        Observer listener1 = new EventListener("Ouvinte 1");
        Observer listener2 = new EventListener("Ouvinte 2");

        // Criando o sujeito
        EventSource eventSource = new EventSource();

        // Registrando observadores no sujeito
        eventSource.registerObserver(listener1);
        eventSource.registerObserver(listener2);

        // Criando um evento que notificará os observadores
        eventSource.createEvent("Notificação de evento 1");
    }
}
