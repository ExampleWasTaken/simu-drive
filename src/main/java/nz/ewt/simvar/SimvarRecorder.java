package nz.ewt.simvar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A SimvarRecorder can store <b>one</b> list of simvar values at a time. <br>
 * It can be cleared and a new recording can be started.
 */
public class SimvarRecorder {
    private boolean isRecording;
    private final List<SimvarRecord> recording = new ArrayList<>();

    public SimvarRecorder() {
        isRecording = false;
    }

    /**
     * @return An immutable version of the recording.
     */
    public List<SimvarRecord> getRecording() {
        return Collections.unmodifiableList(recording);
    }

    /**
     * Start recording. This will append new records to already existing ones if restarted.
     * @see #startNew()
     */
    public void start() {
        isRecording = true;
    }

    /**
     * Delete the current recording and start a new one.
     */
    public void startNew() {
        recording.clear();
        isRecording = true;
    }

    /**
     * Stop recording.
     */
    public void stop() {
        isRecording = false;
    }

    /**
     * Record a new value. <br>
     * If the recorder is not currently recording this will immediately return without recording anything.
     * @param simvarName The name of the simvar to record.
     * @param value The value of the simvar to record.
     */
    public void record(SimvarName simvarName, Object value) {
        if (!isRecording) return;
        recording.add(new SimvarRecord(simvarName, value));
    }

    /**
     * This will irreversibly delete the current recording.
     */
    public void deleteRecording() {
        recording.clear();
    }

    /**
     * Dump the recording to the console.
     */
    public void dumpRecording() {
        for (SimvarRecord current : recording) {
            System.out.println(current);
        }
    }
}
