
package reto3.reto3.repositorios;

/**
 *
 * @author juanp
 */
public class StatusReservas {
    private int completed;
    private int cancelled;

    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getComplete() {
        return completed;
    }

    public void setComplete(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
