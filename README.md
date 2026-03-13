# Synapsify

Synapsify is a focus-enhancement engine that utilizes Android Accessibility Services to monitor app usage and reward deep-work sessions with XP.

## How it Works
1. **Focus Mode:** The user enters the "Safe Zone" within the Synapsify app.
2. **Monitoring:** The `AppDetectorService` monitors background package changes.
3. **Blocking:** If a distracting app is opened, the service triggers a `GLOBAL_ACTION_HOME`.
4. **Gamification:** Focus duration is converted into XP and stored via `StatsManager`.

## Project Structure
- `engine/`: Contains the Accessibility Service and Core blocking logic.
- `data/`: Manages user stats and XP persistence.
- `ui/`: (In Progress) Android XML layouts designed in Canva.

- Created by MohammadRafiul38
