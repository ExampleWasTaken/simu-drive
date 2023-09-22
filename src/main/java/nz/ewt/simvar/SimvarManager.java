package nz.ewt.simvar;

import java.util.HashMap;
import java.util.Map;

public class SimvarManager {
    private Map<SimvarName, Object> simvars;

    private SimvarRecorder recorder;

    public SimvarManager() {
        simvars = new HashMap<>();
        recorder = new SimvarRecorder();
    }

    public SimvarRecorder getRecorder() {
        return recorder;
    }

    public void setSimvar(SimvarName name, Object value) {
        if (simvars.containsKey(name)) {
            simvars.replace(name, value);
        } else {
            simvars.put(name, value);
        }

        recorder.record(name, value);
    }

    public Object getSimvar(SimvarName simvarName) {
        if (!simvars.containsKey(simvarName)) return null;

        return simvars.get(simvarName);
    }

    public Map<SimvarName, Object> getAll() {
        return simvars;
    }
}
