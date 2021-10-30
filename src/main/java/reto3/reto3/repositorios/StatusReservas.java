
package reto3.reto3.repositorios;

/**
 *
 * @author juanp
 */
public class StatusReservas {
    private int complete;
    private int cancelled;

    public StatusReservas(int complete, int cancelled) {
        this.complete = complete;
        this.cancelled = cancelled;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
