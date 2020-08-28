#!/bin/bash
gradle --stop
gradle build --continuous --stacktrace  &
gradle bootRun