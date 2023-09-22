 This file contains temporary code that needs to be retained for later use after the refactor.

---

```java
class Transmission {
    double finalRatio_one = 4.77;
    double finalRatio_two = 3.44;

        Gear[] gears = new Gear[] {
        new Gear(-3.26),
                new Gear(2.93),
                new Gear(1.79),
                new Gear(1.13),
                new Gear(0.77),
                new Gear(0.81),
                new Gear(0.64),
    };
}

class TransmissionFluidPump {
    private void calcCurrentPressure() {
        double a = 10 / Math.exp(700 * (Math.log(2) / 6300));
        double b = Math.log(2) / 6300;
        currentPressure = a * Math.exp(b * rpm);
    }
}
```
