# Simvars
*Until the introduction of a CAN-Bus protocol simulation simvars will be used to communicate values between different 
sensor units.*
---
Simvars are basically global variables that can be accessed by every system. 

## Contents
<!-- TOC -->
* [Simvars](#simvars)
  * [Contents](#contents)
  * [Uncategorized](#uncategorized)
  * [Transmission](#transmission)
  * [Engine](#engine)
<!-- TOC -->

## Uncategorized

- VEHICLE_SPEED
  - Double
  - km/h


## Transmission

- TRANS_INPUT_SHAFT_{number}_RPM
  - Double
  - Revolutions per minute of the corresponding input shaft.
  - {number}
    - 1
    - 2

- TRANS_OUTPUT_SHAFT_RPM
  - Double
  - Revolutions per minute

- TRANS_ACTIVE_GEAR 
  - Int
  - Current active gear.
    Note: This value corresponds to the currently active gear i.e. the power transmitting gear.
  - | Value | Meaning                       |                     
    |-------|-------------------------------|
    | -1    | Neutral (i.e. no gear active) |
    | 0     | Reverse                       |
    | 1 - 6 | Gears 1 through 6             |


- TRANS_CLUTCH_{number}_GEAR
  - Int
  - Current selected gear on the corresponding clutch.
  - Note: Only clutch 1 has a reverse gear.
  - {number}
    - 1
    - 2

- TRANS_HYD_PUMP_RPM
  - Double
  - Transmission hydraulic pump revolutions per minute.

- TRANS_HYD_PUMP_PRESSURE
  - Double
  - Bar
  - Current pressure produced by the transmission hydraulic pump.

- TRANS_CLUTCH_{number}_PRESSURE
  - Double
  - Current pressure in bar acting upon the clutch.
  - {number}
    - 1
    - 2

- TRANS_CLUTCH_{number}_ENGINE_DISK_ANGLE
  - Double
  - Radians
  - Current angle of the engine side clutch disk.
  - {number}
    - 1
    - 2

- TRANS_CLUTCH_{number}_TRANS_DISK_ANGLE
  - Double
  - Radians
  - Current angle of the transmission side clutch disk.
  - {number}
    - 1
    - 2
  

## Engine
- CRANKSHAFT_ANGLE
  - Double
  - Radians
  - Current angle of the crankshaft.

- CRANKSHAFT_RPM
  - Double
  - Revolutions per minute of the crankshaft
