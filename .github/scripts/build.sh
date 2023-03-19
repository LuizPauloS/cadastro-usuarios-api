#!/bin/bash
set -xe

  # Maven is used to build  and create a jar file.
  mvn -Dmaven.test.skip=true clean install


