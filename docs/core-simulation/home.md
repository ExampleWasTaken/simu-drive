# Simulation Structure
This document aims to outline the structure of the simulation meaning the hierarchy of the different components and how
the simulation as a whole is built.

---

The core simulation documentation is contained in the `core-simulation` directory. Each component has its own file. You 
can navigate the documentation either by directly selecting the component you're interested in, or by clicking through (Tip: Start
here ;)).

---

## Terminology
Throughout this documentation there are a few terms use that you should be familiar with:

| Term             | Meaning                                                                                                                                                                                                                   |
|------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Component        | A component is any component of the simulation. E.g. the transmission or an individual drive shaft.                                                                                                                       |
| Child component  | A child component is a component that has one parent component.                                                                                                                                                           |
| Parent component | A parent component is a component that has at least one child component.                                                                                                                                                  |
| Orchestrator     | An orchestrator is a special component. It has no other use than to manage different sub systems. This means is that they do not contribute any data to the simulation and are rather the managers of components that do. |

> [!NOTE]  
> All components except the simulation engine (root) component can be parent *and* child components.

> [!NOTE]  
> A parent component can have `n > 0` amount of children.

> [!NOTE]  
> A child component can only have one parent and is *not* aware of its parent.


---

The root of the simulation is the simulation engine.

- [Simulation Engine](./simulation-engine.md)

Generally speaking the simulation has two parts: The hardware part and the software part. The latter being used to control
the former.

Both parts are managed by their own [orchestrator](./orchestrator.md):

- [Hardware Orchestrator](./hardware-orchestrator.md)
- [Software Orchestrator](./software-orchestrator.md)

---

