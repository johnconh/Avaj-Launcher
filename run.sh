#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.jdasilva.avaj.simulator.Simulator scenario.txt