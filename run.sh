#!/bin/bash

cd "$(dirname "$0")" || exit 1


javac -d bin src/*.java && java -cp bin Main
