package nz.ewt.common;

import java.util.HashMap;

/**
 * Each component of an engine has a unique identifier for easier documentation.
 * This class represents such an identifier
 * as well as utility methods for retrieving the identifier and the type it denotes.
 */
public class Identifier {
    private Type type;

    private int id;

    public Identifier(Type type, int id) {
        this.type = type;
        this.id = id;
    }

    public Identifier(String identifier) throws Exception {
        char typeDesignator = identifier.charAt(0);
        if (identifier.substring(1).length() != 3) {
            throw new IllegalArgumentException("Identifier IDs must be three digits long.");
        }
        int id = Integer.parseInt(identifier.substring(1));

        this.type = new Type(typeDesignator);
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.get() + String.valueOf(id);
    }

    public static class Type {
        private static HashMap<Character, String> validChars;

        static {
            validChars = new HashMap();
            validChars.put('A', "AIR_INTAKE_AIR_FLOW_CONTROL");
            validChars.put('C', "CHASSIS_SUSPENSION");
            validChars.put('D', "DIAGNOSTICS_SYS");
            validChars.put('E', "ELEC_SYS");
            validChars.put('F', "FUEL_SYS");
            validChars.put('G', "SENSOR");
            validChars.put('H', "HEATING_AC");
            validChars.put('J', "CONTROL_UNIT");
            validChars.put('K', "CLIMATE_CONTROL_CABIN_COMFORT");
            validChars.put('L', "INTERIOR_LIGHTING_SYS");
            validChars.put('M', "ENGINE_MGMT_SYS");
            validChars.put('N', "SOLENOID_VALVES_AND_ACTUATORS");
            validChars.put('P', "POWERTRAIN");
            validChars.put('Q', "OCCUPANT_SAFETY_PROT");
            validChars.put('R', "INFOTAINMENT");
            validChars.put('S', "VEHICLE_SAFETY_PROT");
            validChars.put('T', "TRANSMISSION");
            validChars.put('U', "COMM_NETWORK_SYS");
            validChars.put('W', "VEHICLE_BODY");
            validChars.put('X', "NON_STANDARDIZED");
            validChars.put('Z', "SPECIALIZED");
        }

        private char type;

        public Type(char type) {
            if (!validChars.containsKey(type)) {
                throw new IllegalArgumentException("Illegal type designator.");
            }
        }

        public char get() {
            return type;
        }

        public String getString() {
            return validChars.get(type);
        }
    }
}
