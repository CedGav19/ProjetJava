package Bean;

import java.util.EventObject;

public class LogEvt extends EventObject
{
    private String msg;
    public String getLog() { return msg; }

    public LogEvt(Object source)
    {
        super(source);
    }

    public LogEvt(Object source, String log)
    {
        super(source);
        this.msg = log;
    }
}