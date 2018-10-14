#!/bin/bash

set -e
set -o pipefail

if [ -d src ]; then echo "already setup"; exit 0; fi

gradle :wrapper --gradle-version=4.10.2 --distribution-type=bin

./gradlew clean

./gradlew vaadinCreateProject --name "DpornVaadin" --package co.dporn.vaadin.muksihs --baseTheme lumo


