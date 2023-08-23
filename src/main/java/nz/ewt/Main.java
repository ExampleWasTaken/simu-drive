package nz.ewt;

import nz.ewt.core.Simulatable;
import nz.ewt.core.SimulationEngine;

public class Main {
    public static void main(String[] args) {
        SimulationEngine engine = new SimulationEngine();
        engine.addComponent(new Simulatable() {
            @Override
            public void init() {

            }

            @Override
            public void update(double deltaTime) {
                System.out.println("DeltaTime:" + Math.round(deltaTime * 100.0) / 100.0);
            }
        });

        engine.start();
    }
}
