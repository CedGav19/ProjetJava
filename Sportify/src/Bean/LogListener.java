package Bean;

import java.util.EventListener;

public interface LogListener extends EventListener
{
    public void logDetected(LogEvt e);
}