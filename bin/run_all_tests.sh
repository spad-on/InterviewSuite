#!/usr/bin/env bash

get_pom_dir() {
  script_file=$(realpath $0)
  script_dir=$(dirname "$script_file")
  echo $(dirname "$script_dir")
}

pom_dir=`get_pom_dir`

if [ ! -f "$pom_dir/pom.xml" ]; then
  echo "pom.xml not found in $pom_dir"
  exit 1
fi

echo "Running mvn -f $pom_dir test"
mvn -f "$pom_dir" test
