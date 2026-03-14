#!/usr/bin/env sh

# This script redirects the build to the real gradle wrapper
if [ -f "./app/Gradle Scripts/gradlew" ]; then
    exec "./app/Gradle Scripts/gradlew" "$@"
else
    # If it's not there, it tries to run standard gradle
    gradle "$@"
fi